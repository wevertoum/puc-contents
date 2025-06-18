package br.edu.pucgoias.pji.vacinas.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.pucgoias.pji.vacinas.model.PacienteDropdown;
import br.edu.pucgoias.pji.vacinas.model.Vacina;
import br.edu.pucgoias.pji.vacinas.repository.AplicacaoRepository;

public class AplicacaoVacinaView {

    private final AplicacaoRepository aplicacaoRepository;

    public AplicacaoVacinaView() {
        this.aplicacaoRepository = new AplicacaoRepository();
    }

    public void exibirFormulario() {
        try {

            List<PacienteDropdown> pacientes = aplicacaoRepository.buscarTodosPacientesParaDropdown();
            List<Vacina> vacinas = aplicacaoRepository.buscarTodasVacinas();

            JComboBox<PacienteDropdown> pacienteComboBox = new JComboBox<>(pacientes.toArray(PacienteDropdown[]::new));
            JComboBox<Vacina> vacinaComboBox = new JComboBox<>(vacinas.toArray(Vacina[]::new));
            JTextField dataAplicacaoField = new JTextField("AAAA-MM-DD", 10);
            JTextField numeroDoseField = new JTextField(5);

            JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
            panel.add(new JLabel("Selecione o Paciente:"));
            panel.add(pacienteComboBox);
            panel.add(new JLabel("Selecione a Vacina:"));
            panel.add(vacinaComboBox);
            panel.add(new JLabel("Data da Aplicação:"));
            panel.add(dataAplicacaoField);
            panel.add(new JLabel("Número da Dose:"));
            panel.add(numeroDoseField);

            int result = JOptionPane.showConfirmDialog(null, panel,
                    "Registrar Aplicação de Vacina", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {

                PacienteDropdown pacienteSelecionado = (PacienteDropdown) pacienteComboBox.getSelectedItem();
                Vacina vacinaSelecionada = (Vacina) vacinaComboBox.getSelectedItem();
                String dataAplicacao = dataAplicacaoField.getText();
                String doseStr = numeroDoseField.getText();

                if (pacienteSelecionado == null || vacinaSelecionada == null || dataAplicacao.trim().isEmpty() || doseStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    int numeroDose = Integer.parseInt(doseStr);

                    boolean sucesso = aplicacaoRepository.registrarAplicacao(
                            pacienteSelecionado.getId(),
                            vacinaSelecionada.getId(),
                            dataAplicacao,
                            numeroDose
                    );

                    if (sucesso) {
                        JOptionPane.showMessageDialog(null, "Aplicação registrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha ao registrar a aplicação.", "Erro no Banco de Dados", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "O número da dose deve ser um valor numérico.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar o formulário: " + e.getMessage(), "Erro Crítico", JOptionPane.ERROR_MESSAGE);
        }
    }
}
