import socket
import os

HOST = '127.0.0.1'
PORT = 5000
DIR_DOWNLOADS = "downloads_cliente"
DIR_ORIGINAIS = "original_files"

if not os.path.exists(DIR_DOWNLOADS):
    os.makedirs(DIR_DOWNLOADS)

def enviar_arquivo(conn, nome_arquivo):
    """
    Função para enviar um arquivo ao servidor.
    Envia o comando UPLOAD, o nome do arquivo, o tamanho e o conteúdo.
    """
    caminho_arquivo = os.path.join(DIR_ORIGINAIS, nome_arquivo)
    if not os.path.exists(caminho_arquivo):
        print(f"[CLIENTE] Arquivo {nome_arquivo} não encontrado")
        return False

    try:
        conn.send("UPLOAD".encode())
        conn.send(nome_arquivo.encode())
        confirmacao = conn.recv(1024).decode().strip()
        if confirmacao != "NOME_OK":
            print("[CLIENTE] Erro: Servidor não confirmou o nome do arquivo")
            return False

        tamanho_arquivo = os.path.getsize(caminho_arquivo)
        conn.send(str(tamanho_arquivo).encode())
        confirmacao = conn.recv(1024).decode().strip()
        if confirmacao != "TAMANHO_OK":
            print("[CLIENTE] Erro: Servidor não confirmou o tamanho do arquivo")
            return False

        with open(caminho_arquivo, "rb") as f:
            while True:
                dados = f.read(1024)
                if not dados:
                    break
                conn.send(dados)
        confirmacao = conn.recv(1024).decode().strip()
        if confirmacao == "UPLOAD_OK":
            print(f"[CLIENTE] Arquivo {nome_arquivo} enviado com sucesso")
            return True
        else:
            print("[CLIENTE] Erro: Upload não foi concluído com sucesso")
            return False
    except Exception as e:
        print(f"[CLIENTE] Erro ao enviar arquivo: {e}")
        return False

def listar_arquivos(conn):
    """
    Função para listar os arquivos disponíveis no servidor.
    Envia o comando LIST e recebe a lista de arquivos.
    """
    try:
        conn.send("LIST".encode())
        lista_arquivos = conn.recv(1024).decode().strip()
        print("[CLIENTE] Arquivos disponíveis no servidor:")
        print(lista_arquivos)
        return True
    except Exception as e:
        print(f"[CLIENTE] Erro ao listar arquivos: {e}")
        return False

def baixar_arquivo(conn, nome_arquivo):
    """
    Função para baixar um arquivo do servidor.
    Envia o comando DOWNLOAD, verifica se o arquivo existe e recebe o conteúdo.
    """
    try:
        conn.send(f"DOWNLOAD {nome_arquivo}".encode())
        resposta = conn.recv(1024).decode().strip()

        if resposta == "NOT_FOUND":
            print(f"[CLIENTE] Arquivo {nome_arquivo} não encontrado no servidor")
            return True
        elif resposta != "EXISTS":
            print(f"[CLIENTE] Resposta inesperada do servidor: {resposta}")
            return True

        tamanho_str = conn.recv(1024).decode().strip()
        try:
            tamanho_arquivo = int(tamanho_str)
        except ValueError as e:
            print(f"[CLIENTE] Erro: Tamanho inválido recebido: {tamanho_str}")
            return True

        conn.send("TAMANHO_OK".encode())

        caminho_download = os.path.join(DIR_DOWNLOADS, nome_arquivo)
        with open(caminho_download, "wb") as f:
            bytes_recebidos = 0
            while bytes_recebidos < tamanho_arquivo:
                dados = conn.recv(min(1024, tamanho_arquivo - bytes_recebidos))
                if not dados:
                    break
                f.write(dados)
                bytes_recebidos += len(dados)
        print(f"[CLIENTE] Arquivo {nome_arquivo} baixado com sucesso")
        return True
    except Exception as e:
        print(f"[CLIENTE] Erro ao baixar arquivo: {e}")
        return True 

def main():
    try:
        client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        client_socket.connect((HOST, PORT))
        print("[CLIENTE] Conectado ao servidor")
    except Exception as e:
        print(f"[CLIENTE] Erro ao conectar ao servidor: {e}")
        return

    while True:
        print("\n[CLIENTE] Escolha uma opção:")
        print("1 - Enviar arquivo")
        print("2 - Listar arquivos no servidor")
        print("3 - Baixar arquivo")
        print("4 - Sair")
        opcao = input("Opção: ")

        try:
            if opcao == "1":
                nome_arquivo = input("Digite o nome do arquivo para enviar (ex.: filetosend1.txt): ")
                if not enviar_arquivo(client_socket, nome_arquivo):
                    break
            elif opcao == "2":
                if not listar_arquivos(client_socket):
                    break
            elif opcao == "3":
                nome_arquivo = input("Digite o nome do arquivo para baixar: ")
                if not baixar_arquivo(client_socket, nome_arquivo):
                    break
            elif opcao == "4":
                break
            else:
                print("Opção inválida")
        except Exception as e:
            print(f"[CLIENTE] Erro durante a operação: {e}")
            break

    client_socket.close()
    print("[CLIENTE] Conexão encerrada")

if __name__ == "__main__":
    main()