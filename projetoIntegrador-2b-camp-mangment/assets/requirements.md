### 1 - Requisitos Funcionais

#### 1.1. [RF001] Fazer Login do Organizador
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o organizador (Lucas) faça login na plataforma usando e-mail e senha em uma tela segura, garantindo acesso às funcionalidades de gestão de eventos.

#### 1.2. [RF002] Cadastrar Evento
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o organizador cadastre um evento em uma única tela, incluindo nome, data, número de vagas, valor da inscrição e configuração de quartos (quantidade de quartos, leitos por quarto e gênero).

#### 1.3. [RF003] Cadastrar Acampante
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o acampante (Ana) se cadastre na plataforma com nome, e-mail e gênero antes de participar de eventos, em um processo simples e único.

#### 1.2. [RF004] Visualizar Detalhes do Evento
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o acampante acesse um evento por um link e visualize suas informações (nome, data, vagas disponíveis e valor) em uma tela clara e acessível.

#### 1.5. [RF005] Inscrever-se com Escolha de Leito
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o acampante se inscreva em um evento, informando a forma de pagamento e escolhendo um leito em um quarto compatível com seu gênero, em uma única interface interativa.

#### 1.6. [RF006] Exibir Quartos e Ocupantes
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve exibir, durante a inscrição, os quartos disponíveis, leitos livres e nomes dos ocupantes atuais, atualizando em tempo real para auxiliar na escolha do acampante.

#### 1.7. [RF007] Verificar Vagas e Confirmar Inscrição
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve verificar automaticamente se há vagas e leitos disponíveis antes de confirmar a inscrição do acampante, bloqueando tentativas inválidas.

#### 1.8. [RF008] Enviar E-mail de Confirmação
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve enviar um e-mail automático ao acampante após a inscrição, contendo detalhes do evento, quarto e leito, em até 1 minuto.

#### 1.9. [RF009] Visualizar e Exportar Lista de Inscritos
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o organizador visualize a lista de inscritos, incluindo quartos e leitos ocupados, e exporte os dados em formato CSV em uma única tela.

#### 1.10. [RF010] Supervisionar Evento
**Prioridade:** [x] Essencial [ ] Importante [ ] Desejável  
**Descrição:** O sistema deve permitir que o supervisor (Pastor João) visualize os detalhes do evento, a lista de inscritos e a ocupação dos quartos em uma interface simplificada.

#### 1.11. [RF011] Enviar Lembretes Automáticos
**Prioridade:** [ ] Essencial [x] Importante [ ] Desejável  
**Descrição:** O sistema deve enviar lembretes automáticos por e-mail aos acampantes inscritos, entre 3 e 7 dias antes do evento, com data, local e instruções.

---

### 2 - Requisitos Não Funcionais

#### 2.1. [NF001] Acessibilidade
**Descrição:** O sistema deve ser acessível por navegadores web populares (Chrome, Firefox), garantindo compatibilidade ampla para os usuários.

#### 2.2. [NF002] Usabilidade
**Descrição:** A interface deve ser simples e intuitiva, projetada para usuários com pouca experiência tecnológica, facilitando o uso por organizadores, acampantes e supervisores.

#### 2.3. [NF003] Desempenho
**Descrição:** O sistema deve responder em até 3 segundos para ações como inscrição, cadastro ou escolha de leito, assegurando uma experiência fluida.

#### 2.2. [NF004] Segurança
**Descrição:** O sistema deve armazenar os dados com segurança, utilizando criptografia para senhas e proteção para informações sensíveis como gênero, alinhado a padrões de autenticação.

#### 2.5. [NF005] Restrição de Gênero
**Descrição:** O sistema deve garantir que acampantes só escolham quartos compatíveis com seu gênero registrado, aplicando validações automáticas durante a inscrição.