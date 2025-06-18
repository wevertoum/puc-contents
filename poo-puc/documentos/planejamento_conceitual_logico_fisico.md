### Plano de Ação pro Novo Banco de Dados

**Fase 1: Levantamento e Requisitos**
Antes de qualquer coisa, a gente precisa entender o problema de verdade. Isso significa conversar com o pessoal que usa o sistema, mapear como os dados entram, saem e circulam, e definir metas claras de performance (tipo “consulta X tem que responder em até 3 segundos”).
Essa etapa evita retrabalho e garante que o banco será feito pra funcionar bem no que realmente importa.

**Fase 2: Projeto Conceitual**
Aqui desenhamos o “esqueleto” do banco, sem pensar em tecnologia ainda. Identificamos as principais entidades (tipo Cliente, Produto, Pedido), seus dados e como elas se ligam.
Fazer isso bem evita bagunça, dados duplicados e garante que as regras de negócio estejam certas desde o começo.

**Fase 3: Projeto Lógico**
Agora sim a gente transforma aquele esqueleto em tabelas, colunas e relacionamentos, já pensando no modelo relacional.
A gente normaliza pra evitar repetição de dados e escolhe tipos adequados pra cada campo (ex: usar número onde deve ser número). Isso deixa o banco mais leve e rápido pra gravar e atualizar informações.

**Fase 4: Projeto Físico**
Por fim, partimos pra implementação real. Aqui definimos o que precisa de índice, se vale a pena particionar tabelas grandes e como distribuir os dados (pra atender gente em várias regiões do mundo, por exemplo).
Essa parte é focada 100% em performance. A ideia é deixar tudo rodando liso, sem travar.
