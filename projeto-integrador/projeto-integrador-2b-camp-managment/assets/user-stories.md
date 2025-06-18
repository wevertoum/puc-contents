### Histórias de Usuário

#### HU 1: Login do Organizador

**🙍‍♂️ História de Usuário:**  
**Eu, como usuário:** Lucas, organizador de acampamentos da igreja,  
**Eu quero/gostaria:** fazer login na plataforma de forma segura,  
**Para que eu:** possa acessar as funcionalidades de gestão dos eventos com facilidade.

**🤦‍♀️ Dores:**

- Processos manuais demorados para verificar quem tem acesso às informações.
- Risco de acesso não autorizado sem autenticação.

**🙍‍♂️ Solução:**

- Criar uma tela de login com campos para e-mail e senha, garantindo autenticação segura.

**📝 Regras de Negócio e Possíveis Mensagens de Erro:**

- E-mail e senha são obrigatórios.
- Mensagens de erro:
  - "E-mail ou senha inválidos."
  - "Preencha todos os campos."

---

#### HU 2: Cadastro de Evento

**🙍‍♂️ História de Usuário:**  
**Eu, como usuário:** Lucas, organizador de acampamentos,  
**Eu quero/gostaria:** cadastrar um evento com nome, data, número de vagas, valor da inscrição e configuração de quartos,  
**Para que eu:** possa organizar os acampamentos de forma estruturada e automatizada e enviar o link desse evento para os acampantes.

**🤦‍♀️ Dores:**

- Uso de planilhas manuais que geram erros e confusão.
- Dificuldade em configurar quartos e leitos sem um sistema claro.

**🙍‍♂️ Solução:**

- Desenvolver uma tela de cadastro com campos para nome, data, vagas, valor e uma seção para definir N quartos (com N leitos e gênero).

**📝 Regras de Negócio e Possíveis Mensagens de Erro:**

- Todos os campos são obrigatórios.
- Número de vagas e leitos deve ser maior que zero.
- Mensagens de erro:
  - "Nome do evento é obrigatório."
  - "Defina pelo menos um quarto para o evento."

---

#### HU 3: Cadastro de Acampante

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** me cadastrar na plataforma com nome, e-mail e gênero,  
**Para que eu:** possa participar dos eventos sem precisar repetir informações toda vez.

**🤦‍♀️ Dores:**

- Preenchimento repetitivo de dados em formulários avulsos.
- Falta de controle sobre quem já está cadastrado.

**🙍‍♂️ Solução:**

- Criar uma tela de cadastro inicial para acampantes com campos obrigatórios: nome, e-mail e gênero.

**📝 Regras de Negócio e Possíveis Mensagens de Erro:**

- E-mail deve ser único.
- Gênero deve ser selecionado (masculino ou feminino).
- Mensagens de erro:
  - "E-mail já cadastrado."
  - "Selecione seu gênero."

---

#### HU 4: Visualização de Evento

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** acessar o evento por um link e visualizar suas informações (nome, data, vagas, valor),  
**Para que eu:** possa decidir se quero me inscrever com base em informações claras.

**🤦‍♀️ Dores:**

- Informações confusas ou incompletas no WhatsApp.
- Dificuldade em saber se ainda há vagas disponíveis.

**🙍‍♂️ Solução:**

- Desenvolver uma página acessível por link que exiba os detalhes do evento de forma simples e visível.

**📝 Regras de Negócio:**

- Mostrar "Vagas esgotadas" se não houver mais vagas disponíveis.

---

#### HU 5: Inscrição com Escolha de Leito

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** me inscrever no evento, informar a forma de pagamento e escolher um leito em um quarto do meu gênero,  
**Para que eu:** possa garantir minha participação e ficar no quarto que prefiro.

**🤦‍♀️ Dores:**

- Inscrições manuais que não garantem o quarto desejado.
- Risco de ser alocada em um quarto incompatível com o gênero.

**🙍‍♂️ Solução:**

- Criar uma tela de inscrição com campos para forma de pagamento e uma seção interativa mostrando quartos disponíveis, leitos livres e ocupantes, restrita ao gênero do usuário.

**📝 Regras de Negócio e Possíveis Mensagens de Erro:**

- Apenas quartos do gênero do usuário são exibidos.
- Mensagens de erro:
  - "Nenhum leito disponível no quarto selecionado."
  - "Selecione uma forma de pagamento."

---

#### HU 6: Exibição de Quartos e Ocupantes

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** ver os quartos disponíveis, leitos livres e nomes dos ocupantes ao escolher meu leito,  
**Para que eu:** possa decidir onde ficar com base em quem já está no quarto.

**🤦‍♀️ Dores:**

- Falta de visibilidade sobre quem está nos quartos.
- Escolhas aleatórias que não atendem às preferências.

**🙍‍♂️ Solução:**

- Exibir uma lista ou grade de quartos com leitos numerados, indicando quais estão livres e os nomes dos ocupantes atuais.

**📝 Regras de Negócio:**

- Atualizar em tempo real conforme outros acampantes escolhem leitos.

---

#### HU 7: Verificação de Vagas e Confirmação

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** que o sistema verifique se há vagas e leitos disponíveis antes de confirmar minha inscrição,  
**Para que eu:** tenha certeza de que minha participação está garantida.

**🤦‍♀️ Dores:**

- Inscrições aceitas sem vagas disponíveis, gerando confusão.
- Atraso na confirmação manual pelo organizador.

**🙍‍♂️ Solução:**

- Implementar uma validação automática que bloqueia a inscrição se não houver vagas ou leitos.

**📝 Regras de Negócio e Possíveis Mensagens de Erro:**

- Mensagem de erro: "Evento lotado. Não há vagas ou leitos disponíveis."

---

#### HU 8: Envio de E-mail de Confirmação

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** receber um e-mail de confirmação com detalhes do quarto e leito após me inscrever,  
**Para que eu:** tenha um comprovante imediato da minha inscrição.

**🤦‍♀️ Dores:**

- Atraso na confirmação manual pelo Lucas.
- Falta de registro formal da inscrição.

**🙍‍♂️ Solução:**

- Enviar automaticamente um e-mail com nome do evento, data, quarto, leito e instruções.

**📝 Regras de Negócio:**

- E-mail deve ser enviado em até 1 minuto após a inscrição.

---

#### HU 9: Visualização e Exportação da Lista de Inscritos

**🙍‍♂️ História de Usuário:**  
**Eu, como usuário:** Lucas, organizador,  
**Eu quero/gostaria:** visualizar a lista de inscritos com quartos e leitos ocupados e exportá-la em CSV,  
**Para que eu:** possa gerenciar o evento e compartilhar relatórios com o supervisor.

**🤦‍♀️ Dores:**

- Relatórios manuais demorados e propensos a erros.
- Dificuldade em compartilhar dados organizados.

**🙍‍♂️ Solução:**

- Criar uma tela com uma tabela de inscritos (nome, quarto, leito) e um botão para exportar em CSV.

**📝 Regras de Negócio:**

- Exportação deve incluir todos os dados visíveis na tabela.

---

#### HU 10: Supervisão do Evento

**🙍‍♂️ História de Usuário:**  
**Eu, como usuário:** Pastor João, supervisor,  
**Eu quero/gostaria:** visualizar os detalhes do evento, lista de inscritos e ocupação dos quartos,  
**Para que eu:** possa aprovar o evento e garantir que as regras da igreja sejam seguidas.

**🤦‍♀️ Dores:**

- Dependência de relatórios enviados manualmente pelo Lucas.
- Falta de visibilidade sobre a separação de gêneros nos quartos.

**🙍‍♂️ Solução:**

- Desenvolver uma tela simples com detalhes do evento e uma visão dos quartos ocupados, acessível ao supervisor.

**📝 Regras de Negócio:**

- Interface deve ser minimalista e fácil de navegar.

--- 

#### HU 11: Envio de Lembretes Automáticos

**🙍‍♀️ História de Usuário:**  
**Eu, como usuário:** Ana, acampante,  
**Eu quero/gostaria:** receber lembretes automáticos por e-mail alguns dias antes do evento,  
**Para que eu:** possa me preparar com antecedência e não esquecer do acampamento.  

**🤦‍♀️ Dores:**  
- Esquecimento do evento por falta de lembretes.  
- Dependência de comunicações manuais do organizador, que podem atrasar ou falhar.  

**🙍‍♂️ Solução:**  
- Implementar um sistema que envie automaticamente e-mails de lembrete aos inscritos, contendo data, local e instruções do evento.  

**📝 Regras de Negócio e Possíveis Mensagens de Erro:**  
- O lembrete deve ser enviado a todos os inscritos confirmados, entre 3 e 7 dias antes do evento.  
- Mensagem de erro (caso falhe): "Erro ao enviar lembrete. Verifique o e-mail cadastrado."  
