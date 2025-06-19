
# Projeto Agenda Telefônica

Bem-vindo(a)! Este é um guia de onboarding para você entender rapidamente como a aplicação de **Agenda Telefônica** em Java funciona, desde a estrutura do banco até o funcionamento do código.

---

## 🗄️ 1. Ponto de Partida: O Banco de Dados

Tudo começa com o banco de dados.

* **Banco:** `AgendaTelefonica` (MySQL)
* **Tabela:** `contato`
* **Campos:** `id_contato`, `nome`, `telefone`, `email`
* **Criação:** O script `database/logico/create_database.sql` cria automaticamente o banco e a tabela.
  **👉 Não é necessário criar nada manualmente.**

---

## 2. Arquitetura do Projeto

O projeto usa **Maven** e segue o padrão em 3 camadas principais. A **regra de ouro**: cada camada só se comunica com a camada imediatamente abaixo.

### view (Interface Gráfica)

* **Classe principal:** `MenuView.java`
* **Função:** Exibe a janela principal (JFrame), botões como "Adicionar", "Listar", etc.
* **Observações:** Usa `JOptionPane` para formulários e mensagens.
* ❗ **Importante:** A view **não se conecta diretamente ao banco** nem usa SQL.

### repository (A Camada de Dados)

* **Classe:** `ContatoRepository.java`
* **Função:** Acessa o banco de dados (DAO - Data Access Object)
* **Operações:** Contém os comandos SQL (`INSERT`, `SELECT`, `UPDATE`, `DELETE`)
* **Conexão:** Usa a classe `DatabaseConnection` para se conectar ao banco.

### model e db (Suporte)

* `db/DatabaseConnection.java`: Responsável por fornecer conexões com o banco (contém usuário e senha).
* `model/Contato.java`: POJO (Plain Old Java Object) que representa um contato e carrega os dados entre as camadas.

---

## 3. Fluxo de Funcionamento (Exemplo: Adicionar Contato)

### 1. Usuário clica:

> O botão "Adicionar Contato" é acionado na `MenuView`.

### 2. View pede os dados:

> Um `JOptionPane` solicita ao usuário: Nome, Telefone e Email.

### 3. View cria o "pacote":

> Um novo objeto `Contato` é criado com os dados informados.

### 4. View delega a tarefa:

> A `MenuView` chama `repository.adicionarContato(contato)`.

### 5. Repository executa:

> O `ContatoRepository` realiza a conexão com o banco, executa o `INSERT INTO contato (...) VALUES (...)` e fecha a conexão.

### 6. Feedback:

> A resposta (`true` ou `false`) é retornada à `MenuView`, que mostra:

* ✅ "Contato adicionado com sucesso!"
* ❌ "Falha ao adicionar"

> Todas as outras ações (Listar, Atualizar, Remover) seguem exatamente essa mesma lógica:

* A **View inicia a ação**
* O **Repository executa a lógica com SQL**
* O **Model transporta os dados**

---

## Requisitos Técnicos

* Java 17+
* MySQL 8+
* Maven 3.8+
