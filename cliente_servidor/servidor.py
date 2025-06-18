import socket
import os
import threading

HOST = '127.0.0.1'
PORT = 5000
DIR_ARQUIVOS = "arquivos_servidor"

if not os.path.exists(DIR_ARQUIVOS):
    os.makedirs(DIR_ARQUIVOS)

def handle_client(conn, addr):
    """
    Função que lida com cada cliente conectado em uma thread separada.
    Recebe comandos do cliente e executa as ações correspondentes (upload, listar ou download).
    """
    print(f"[SERVIDOR] Nova conexão de {addr}")
    
    while True:
        try:
            comando = conn.recv(1024).decode().strip()
            if not comando:
                break

            if comando == "UPLOAD":
                nome_arquivo = conn.recv(1024).decode().strip()
                if not nome_arquivo:
                    break
                conn.send("NOME_OK".encode())

                tamanho_str = conn.recv(1024).decode().strip()
                if not tamanho_str:
                    break
                try:
                    tamanho_arquivo = int(tamanho_str)
                except ValueError as e:
                    print(f"[SERVIDOR] Erro: Tamanho inválido recebido: {tamanho_str}")
                    conn.send("ERRO_TAMANHO".encode())
                    continue
                conn.send("TAMANHO_OK".encode())

                caminho_arquivo = os.path.join(DIR_ARQUIVOS, nome_arquivo)
                with open(caminho_arquivo, "wb") as f:
                    bytes_recebidos = 0
                    while bytes_recebidos < tamanho_arquivo:
                        dados = conn.recv(min(1024, tamanho_arquivo - bytes_recebidos))
                        if not dados:
                            break
                        f.write(dados)
                        bytes_recebidos += len(dados)
                print(f"[SERVIDOR] Arquivo {nome_arquivo} recebido de {addr}")
                conn.send("UPLOAD_OK".encode())

            elif comando == "LIST":
                arquivos = os.listdir(DIR_ARQUIVOS)
                if arquivos:
                    lista_arquivos = "\n".join(arquivos)
                else:
                    lista_arquivos = "Nenhum arquivo disponível"
                conn.send(lista_arquivos.encode())

            elif comando.startswith("DOWNLOAD"):
                try:
                    nome_arquivo = comando.split()[1]
                except IndexError:
                    conn.send("NOT_FOUND".encode())
                    continue

                caminho_arquivo = os.path.join(DIR_ARQUIVOS, nome_arquivo)
                if os.path.exists(caminho_arquivo):
                    conn.send("EXISTS".encode())
                    tamanho_arquivo = os.path.getsize(caminho_arquivo)
                    conn.send(str(tamanho_arquivo).encode())
                    confirmacao = conn.recv(1024).decode().strip()
                    if confirmacao != "TAMANHO_OK":
                        print(f"[SERVIDOR] Cliente não confirmou tamanho do arquivo {nome_arquivo}")
                        continue
                    with open(caminho_arquivo, "rb") as f:
                        while True:
                            dados = f.read(1024)
                            if not dados:
                                break
                            conn.send(dados)
                    print(f"[SERVIDOR] Arquivo {nome_arquivo} enviado para {addr}")
                else:
                    conn.send("NOT_FOUND".encode())

        except Exception as e:
            print(f"[SERVIDOR] Erro ao lidar com {addr}: {e}")
            break
    
    conn.close()
    print(f"[SERVIDOR] Conexão com {addr} encerrada")

def main():
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind((HOST, PORT))
    server_socket.listen(5)
    print(f"[SERVIDOR] Escutando em {HOST}:{PORT}...")

    while True:
        conn, addr = server_socket.accept()
        thread = threading.Thread(target=handle_client, args=(conn, addr))
        thread.start()

if __name__ == "__main__":
    main()