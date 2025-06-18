#### Jornada Administrativa (Requer Login)
Telas acessadas por Lucas (Organizador) e Pastor João (Supervisor) após autenticação.

1. **Tela de Login (RF001, HU1)**  
   - **Objetivo:** Autenticar Lucas e Pastor João para acessar o sistema administrativo.  
   - **Elementos:**  
     - Campo: "E-mail".  
     - Campo: "Senha".  
     - Botão: "Entrar".  
     - Mensagem de erro: "E-mail ou senha inválidos".  
   - **Notas:** Logo "CampGestor" no topo, design simples. Após login, redireciona para Gestão ou Supervisão.

2. **Tela de Gestão de Eventos (RF002, RF009, HU2, HU9)**  
   - **Objetivo:** Permitir que Lucas cadastre eventos e gerencie inscritos.  
   - **Elementos:**  
     - Seção "Cadastrar Evento":  
       - Campos: "Nome", "Data", "Nº de Vagas", "Valor".  
       - Subseção "Quartos": "Nº de quartos", "Leitos por quarto", "Gênero" (dropdown), Nome do quarto.
       - Botão: "Salvar".  
     - Seção "Lista de Inscritos":  
       - Tabela: "Nome", "Quarto", "Leito".  
       - Botão: "Exportar CSV".  
   - **Notas:** Layout dividido em duas áreas, com botão "Logout" no canto superior direito.

3. **Tela de Supervisão do Evento (RF010, HU10)**  
   - **Objetivo:** Permitir que Pastor João revise detalhes e ocupação.  
   - **Elementos:**  
     - Título: "Acampamento de Verão 2025".  
     - Texto: "Data: 15-17/07/2025 | Vagas: 20".  
     - Tabela: "Nome", "Quarto", "Leito".  
     - Lista: "Quarto 1 (Masculino): João, Pedro | Quarto 2 (Feminino): Ana".  
   - **Notas:** Interface limpa, com botão "Logout" no topo.

---

#### Jornada do Acampante (Sem Login)

4. **Tela de Cadastro de Acampante (RF003, HU3)**  
   - **Objetivo:** Permitir que Ana se cadastre para participar do evento.  
   - **Elementos:**  
     - Campo: "Nome".  
     - Campo: "E-mail".  
     - Dropdown: "Gênero" (Masculino, Feminino).  
     - Botão: "Cadastrar".  
     - Mensagem de erro: "E-mail já cadastrado".  
   - **Notas:** Tela inicial do link público, sem opção de login. Após cadastro, avança automaticamente para os detalhes do evento.

5. **Tela de Visualização de Detalhes do Evento (RF004, HU4)**  
   - **Objetivo:** Mostrar informações do evento para Ana decidir se inscrever.  
   - **Elementos:**  
     - Título: "Acampamento de Verão 2025".  
     - Texto: "Data: 15-17/07/2025".  
     - Texto: "Vagas disponíveis: 20".  
     - Texto: "Valor: R$ 150,00".  
     - Botão: "Inscrever-se".  
     - Mensagem: "Vagas esgotadas" (se aplicável).  
   - **Notas:** Layout público, botão destacado leva à inscrição.

6. **Tela de Inscrição com Escolha de Leito (RF005, RF006, RF007, HU5, HU6, HU7)**  
   - **Objetivo:** Permitir que Ana se inscreva e escolha um leito.  
   - **Elementos:**  
     - Seção "Forma de Pagamento":  
       - Dropdown: "Forma de pagamento" (Boleto, Cartão).  
     - Seção "Escolha de Quarto":  
       - Lista: "Quarto 1 - Masculino: 2/4 leitos livres" (filtrado por gênero do cadastro).  
       - Subitens: "Leito 1 (João)", "Leito 2 (livre)" com botão "Escolher".  
     - Botão: "Confirmar Inscrição".  
     - Mensagem de erro: "Erro ao realizar inscrição".  
   - **Notas:** Interface interativa, sem opção de login, apenas fluxo público.

7. **Tela de Confirmação de Inscrição (RF008, HU8)**  
   - **Objetivo:** Confirmar a inscrição de Ana e informar o envio do e-mail.  
   - **Elementos:**  
     - Título: "Inscrição Confirmada!".  
     - Texto: "Acampamento de Verão 2025".  
     - Texto: "Quarto: 1 | Leito: 2".  
     - Texto: "E-mail enviado para ana@email.com".  
     - Botão: "Voltar ao Início" (leva à tela de detalhes ou página inicial pública).  
   - **Notas:** Design positivo com ícone de check.

8. **E-mail de Lembrete (RF011, HU11)**  
   - **Objetivo:** Mockup do e-mail de lembrete enviado a Ana.  
   - **Elementos:**  
     - Assunto: "Lembrete: Acampamento de Verão 2025".  
     - Texto: "Olá, Ana! Seu acampamento: 15-17/07/2025".  
     - Texto: "Local: Sítio Esperança | Quarto 2, Leito 1".  
     - Texto: "Até lá!".  
   - **Notas:** Layout de e-mail típico, sem interação.

---

### Fluxo Resumido
1. **Jornada Administrativa (com Login):**  
   - Login → Gestão de Eventos (Lucas) ou Supervisão do Evento (Pastor João).  
   - Fluxo: Lucas cadastra o evento e gera o link público; ambos visualizam inscritos.

2. **Jornada do Acampante (sem Login):**  
   - Cadastro de Acampante → Visualização de Detalhes do Evento → Inscrição com Escolha de Leito → Confirmação de Inscrição → Recebe e-mail de confirmação e lembrete.  
   - Fluxo: Ana acessa o link gerado, segue o processo público e recebe comunicações por e-mail.