package br.edu.pucgoias.pji.vacinas.view;

import br.edu.pucgoias.pji.vacinas.model.Escolaridade;
import br.edu.pucgoias.pji.vacinas.model.Regiao;
import br.edu.pucgoias.pji.vacinas.repository.PacienteRepository;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;

public class CadastroPacienteView {

    private final PacienteRepository pacienteRepository;

    public CadastroPacienteView() {
        this.pacienteRepository = new PacienteRepository();
    }

    public void exibirFormulario() {
        try {
            // Busca os dados para os JComboBox (selects)
            List<Regiao> regioes = pacienteRepository.buscarTodasRegioes();
            List<Escolaridade> escolaridades = pacienteRepository.buscarTodasEscolaridades();

            // Componentes do formulário
            JTextField nomeField = new JTextField(20);
            JTextField dataNascimentoField = new JTextField("AAAA-MM-DD", 10);
            JTextField enderecoField = new JTextField(30);
            JComboBox<Regiao> regiaoComboBox = new JComboBox<>(regioes.toArray(Regiao[]::new));
            JComboBox<Escolaridade> escolaridadeComboBox = new JComboBox<>(escolaridades.toArray(Escolaridade[]::new));

            // Painel para organizar os componentes
            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10)); // 2 colunas, espaçamento de 10px
            panel.add(new JLabel("Nome Completo:"));
            panel.add(nomeField);
            panel.add(new JLabel("Data de Nascimento:"));
            panel.add(dataNascimentoField);
            panel.add(new JLabel("Endereço:"));
            panel.add(enderecoField);
            panel.add(new JLabel("Região:"));
            panel.add(regiaoComboBox);
            panel.add(new JLabel("Escolaridade:"));
            panel.add(escolaridadeComboBox);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Cadastrar Novo Paciente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                // Pega os valores dos campos
                String nome = nomeField.getText();
                String dataNascimento = dataNascimentoField.getText();
                String endereco = enderecoField.getText();
                Regiao regiaoSelecionada = (Regiao) regiaoComboBox.getSelectedItem();
                Escolaridade escolaridadeSelecionada = (Escolaridade) escolaridadeComboBox.getSelectedItem();

                // Validação simples
                if (nome.trim().isEmpty() || regiaoSelecionada == null || escolaridadeSelecionada == null) {
                    JOptionPane.showMessageDialog(null, "Nome, Região e Escolaridade são campos obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Insere no banco de dados
                boolean sucesso = pacienteRepository.cadastrarPaciente(
                        nome,
                        dataNascimento,
                        endereco,
                        regiaoSelecionada.getId(),
                        escolaridadeSelecionada.getId()
                );

                if (sucesso) {
                    JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao cadastrar o paciente.", "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o formulário: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }
}
