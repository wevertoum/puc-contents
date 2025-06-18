package br.edu.pucgoias.pji.vacinas.view;

import br.edu.pucgoias.pji.vacinas.model.Paciente;
import br.edu.pucgoias.pji.vacinas.repository.PacienteRepository;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListaPacientesView {

    private final PacienteRepository pacienteRepository;

    public ListaPacientesView() {
        this.pacienteRepository = new PacienteRepository();
    }

    public void exibir() {
        try {
            List<Paciente> pacientes = pacienteRepository.buscarTodosPacientesDetalhado();

            String[] colunas = {"ID", "Nome", "Nascimento", "Endereço", "Região", "Escolaridade"};

            DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            for (Paciente p : pacientes) {
                Object[] row = {
                    p.getId(),
                    p.getNome(),
                    p.getDataNascimento(),
                    p.getEndereco(),
                    p.getNomeRegiao(),
                    p.getNivelEscolaridade()
                };
                tableModel.addRow(row);
            }

            JTable tabela = new JTable(tableModel);
            tabela.setPreferredScrollableViewportSize(new Dimension(800, 400));
            tabela.setFillsViewportHeight(true);

            JScrollPane scrollPane = new JScrollPane(tabela);

            JOptionPane.showMessageDialog(null, scrollPane, "Lista de Pacientes Cadastrados", JOptionPane.INFORMATION_MESSAGE);

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar a lista de pacientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
