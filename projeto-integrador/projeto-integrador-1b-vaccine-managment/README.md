# Projeto Integrador I-B - Gerenciamento de Vacinas  

### 📁 Entregáveis

* **Script SQL de criação do banco de dados:**
  Deve ser incluído como **anexo no relatório**, contendo os comandos necessários para gerar as tabelas, relacionamentos e dados iniciais.

* **Modelagem do banco:**

  * **Modelo Conceitual:** Criado no **BRModelo**, apresentando uma visão de alto nível do sistema (entidades e relacionamentos, sem detalhes técnicos).
  * **Modelo Lógico:** Elaborado no **MySQL Workbench**, representando as entidades, atributos, relacionamentos, **cardinalidades**, **chaves primárias (PK)** e **estrangeiras (FK)**.
  * **Modelo Físico:** Código SQL gerado a partir do modelo lógico, utilizado para **criar fisicamente o banco de dados** no MySQL.

---

### 🧩 Banco de Dados

* O **banco será criado com MySQL**.
* Será necessário:

  * Fazer o **download do MySQL**.
  * Modelar o banco utilizando o **Workbench**.
  * Gerar e rodar o script SQL para criar o banco.

---

### 💻 Aplicação Java

* A aplicação **deve ser desenvolvida em Java** e conter:

  * Uma **interface de comunicação** (gráfica ou console) que permita **interagir com o banco de dados**.
  * Funcionalidades para:

    * **Cadastrar dados** no banco (INSERT).
    * **Buscar e exibir informações** (SELECT, incluindo comandos com **INNER JOIN** e outras cláusulas SQL).
* A integração com o banco será feita via **JDBC** (Java Database Connectivity).

---

### 🎥 Demonstração em Vídeo

* O vídeo de apresentação deve demonstrar:

  * A **execução do script SQL**, mostrando o banco sendo criado com sucesso.
  * A **aplicação em funcionamento**, incluindo:

    * Inserções de dados.
    * Consultas realizadas com comandos SQL diretamente ou via aplicação (como SELECT com INNER JOIN, etc.).
