# Sistema de Compartilhamento de Arquivos (SiCA)

## 1. Introdução

O **Sistema de Compartilhamento de Arquivos (SiCA)** é uma aplicação cliente-servidor desenvolvida em Python que permite a transferência de arquivos entre máquinas via rede utilizando sockets TCP.

### Objetivo
O objetivo do SiCA é fornecer uma solução simples para:
- Enviar arquivos do cliente para o servidor (upload).
- Listar os arquivos disponíveis no servidor.
- Baixar arquivos do servidor para o cliente (download).

## 2. Estrutura do Projeto

A estrutura de pastas do projeto é a seguinte:

```
~/cliente_servidor
├── arquivos_servidor/        # Diretório dos arquivos recebidos
│   └── filetosend1.txt       # Exemplo de arquivo enviado
├── cliente.py                # Código do programa cliente
├── downloads_cliente/        # Diretório onde o cliente salva os arquivos baixados
├── original_files/           # Diretório com os arquivos originais que o cliente pode enviar
│   ├── filetosend1.txt
│   ├── filetosend2.txt
│   ├── filetosend3.txt
│   ├── filetosend4.txt
│   ├── filetosend5.txt
│   └── filetosend6.txt
└── servidor.py               # Código do programa servidor
```

## 3. Funcionalidades

O sistema oferece três funcionalidades principais:
1. **Upload de Arquivos**: O cliente pode enviar arquivos da pasta `original_files` para o servidor.
2. **Listagem de Arquivos**: O cliente pode listar os arquivos disponíveis no diretório `arquivos_servidor` do servidor.
3. **Download de Arquivos**: O cliente pode baixar arquivos do servidor para a pasta `downloads_cliente`.

## 4. Como Usar

### 4.1. Configuração Inicial
1. Certifique-se de que as pastas `arquivos_servidor`, `downloads_cliente` e `original_files` existem no diretório do projeto.
2. Coloque os arquivos que deseja enviar ao servidor na pasta `original_files`.

### 4.2. Iniciando o Servidor
1. Abra um terminal e navegue até o diretório do projeto.
2. Execute o servidor com o comando:
   ```bash
   python servidor.py
   ```
3. O servidor começará a escutar conexões no endereço `127.0.0.1` (localhost) na porta `5000`.

   Saída esperada:
   ```
   [SERVIDOR] Escutando em 127.0.0.1:5000...
   ```

### 4.3. Iniciando o Cliente
1. Abra outro terminal e navegue até o diretório do projeto.
2. Execute o cliente com o comando:
   ```bash
   python cliente.py
   ```
3. O cliente se conectará ao servidor e exibirá um menu interativo.

   Saída esperada:
   ```
   [CLIENTE] Conectado ao servidor

   [CLIENTE] Escolha uma opção:
   1 - Enviar arquivo
   2 - Listar arquivos no servidor
   3 - Baixar arquivo
   4 - Sair
   Opção:
   ```
