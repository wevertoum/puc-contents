Para esse sistema de controle de pedidos, eu utilizaria **4 tabelas** principais para estruturar o banco de dados de forma eficiente e sem redundância de dados. A seguir, detalho cada uma delas e seus respectivos campos.

#### **1. Tabela de Clientes**

Esta tabela armazenará todas as informações pertinentes aos clientes que realizam os pedidos.

* **Tabela: `Clientes`**
    * `ID_Cliente` (Chave Primária, Identificador único do cliente)
    * `Nome` (Nome completo do cliente)
    * `CPF_CNPJ` (Cadastro de Pessoa Física ou Jurídica)
    * `Endereco` (Endereço de entrega)
    * `Email` (Endereço de e-mail para contato)
    * `Telefone` (Número de telefone para contato)

---

#### **2. Tabela de Produtos**

Aqui serão cadastrados todos os materiais de escritório que a empresa LENS comercializa.

* **Tabela: `Produtos`**
    * `ID_Produto` (Chave Primária, Identificador único do produto)
    * `NomeProduto` (Nome ou descrição do produto)
    * `PrecoUnitario` (Valor de venda de cada unidade do produto)
    * `Estoque` (Quantidade do produto disponível em estoque)

---

#### **3. Tabela de Pedidos**

Esta tabela registrará cada pedido feito por um cliente, funcionando como o cabeçalho da transação.

* **Tabela: `Pedidos`**
    * `ID_Pedido` (Chave Primária, Identificador único do pedido)
    * `ID_Cliente` (Chave Estrangeira, referenciando a tabela `Clientes` para saber quem fez o pedido)
    * `DataPedido` (Data e hora em que o pedido foi realizado)
    * `StatusPedido` (Status atual do pedido, como "Processando", "Enviado", "Entregue")

---

#### **4. Tabela de Itens do Pedido**

Esta tabela de associação é fundamental para detalhar quais produtos e em qual quantidade compõem cada pedido, resolvendo a relação de "muitos-para-muitos" entre pedidos e produtos.

* **Tabela: `ItensPedido`**
    * `ID_ItemPedido` (Chave Primária, Identificador único do item no pedido)
    * `ID_Pedido` (Chave Estrangeira, referenciando a tabela `Pedidos`)
    * `ID_Produto` (Chave Estrangeira, referenciando a tabela `Produtos`)
    * `Quantidade` (Número de unidades daquele produto no pedido)
    * `PrecoUnitario` (Preço do produto no momento da compra, para manter o histórico caso o valor mude)