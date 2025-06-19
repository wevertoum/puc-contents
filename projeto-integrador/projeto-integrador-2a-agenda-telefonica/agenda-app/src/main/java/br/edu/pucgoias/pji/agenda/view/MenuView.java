package br.edu.pucgoias.pji.agenda.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.edu.pucgoias.pji.agenda.model.Contato;
import br.edu.pucgoias.pji.agenda.repository.ContatoRepository;

public class MenuView {

    private final ContatoRepository repository;

    public MenuView() {
        this.repository = new ContatoRepository();
    }

    public void exibir() {
        JFrame frame = new JFrame("Agenda Telefônica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 320);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        JButton btnAdicionar = createMenuButton("Adicionar Contato");
        JButton btnListar = createMenuButton("Listar / Visualizar");
        JButton btnAtualizar = createMenuButton("Atualizar Contato");
        JButton btnRemover = createMenuButton("Remover Contato");

        buttonsPanel.add(btnAdicionar);
        buttonsPanel.add(btnListar);
        buttonsPanel.add(btnAtualizar);
        buttonsPanel.add(btnRemover);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.BOLD, 12));

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(btnSair, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        btnAdicionar.addActionListener(e -> acaoAdicionar());
        btnListar.addActionListener(e -> acaoListar());
        btnAtualizar.addActionListener(e -> acaoAtualizar());
        btnRemover.addActionListener(e -> acaoRemover());

        btnSair.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });
    }

    private void acaoAdicionar() {
        JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
        JTextField nomeField = new JTextField();
        JTextField telefoneField = new JTextField();
        JTextField emailField = new JTextField();
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("Telefone:"));
        panel.add(telefoneField);
        panel.add(new JLabel("E-mail:"));
        panel.add(emailField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Novo Contato",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            if (nomeField.getText().isEmpty() || telefoneField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome e Telefone são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Contato novoContato = new Contato(nomeField.getText(), telefoneField.getText(), emailField.getText());
            if (repository.adicionarContato(novoContato)) {
                JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao adicionar contato.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void acaoListar() {
        List<Contato> contatos = repository.listarContatos();
        String[] colunas = {"ID", "Nome", "Telefone", "E-mail"};
        DefaultTableModel tableModel = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Contato contato : contatos) {
            Object[] row = {contato.getId(), contato.getNome(), contato.getTelefone(), contato.getEmail()};
            tableModel.addRow(row);
        }
        JTable tabela = new JTable(tableModel);
        JOptionPane.showMessageDialog(null, new JScrollPane(tabela), "Lista de Contatos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void acaoAtualizar() {
        String idStr = JOptionPane.showInputDialog(null, "Digite o ID do contato que deseja atualizar:",
                "Atualizar Contato", JOptionPane.QUESTION_MESSAGE);
        if (idStr == null || idStr.trim().isEmpty()) {
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            JPanel panel = new JPanel(new GridLayout(0, 2, 5, 5));
            JTextField nomeField = new JTextField();
            JTextField telefoneField = new JTextField();
            JTextField emailField = new JTextField();
            panel.add(new JLabel("Novo Nome:"));
            panel.add(nomeField);
            panel.add(new JLabel("Novo Telefone:"));
            panel.add(telefoneField);
            panel.add(new JLabel("Novo E-mail:"));
            panel.add(emailField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Atualizar Contato ID: " + id,
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                if (nomeField.getText().isEmpty() || telefoneField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nome e Telefone são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Contato contatoAtualizado = new Contato(id, nomeField.getText(), telefoneField.getText(), emailField.getText());
                if (repository.atualizarContato(contatoAtualizado)) {
                    JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao atualizar contato. Verifique o ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Por favor, digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void acaoRemover() {
        String idStr = JOptionPane.showInputDialog(null, "Digite o ID do contato que deseja remover:",
                "Remover Contato", JOptionPane.QUESTION_MESSAGE);
        if (idStr == null || idStr.trim().isEmpty()) {
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover o contato com ID " + id + "?",
                    "Confirmar Remoção", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                if (repository.removerContato(id)) {
                    JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao remover contato. Verifique o ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido. Por favor, digite um número.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFocusPainted(false);
        return button;
    }
}
