package br.edu.pucgoias.pji.vacinas.view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.edu.pucgoias.pji.vacinas.repository.RelatorioRepository;

public class MenuView {

    private final RelatorioRepository relatorioRepository;
    private final CadastroPacienteView cadastroPacienteView;
    private final ListaPacientesView listaPacientesView;
    private final AplicacaoVacinaView aplicacaoVacinaView;

    public MenuView() {
        this.relatorioRepository = new RelatorioRepository();
        this.cadastroPacienteView = new CadastroPacienteView();
        this.listaPacientesView = new ListaPacientesView();
        this.aplicacaoVacinaView = new AplicacaoVacinaView();
    }

    public void exibir() {
        JFrame frame = new JFrame("Menu Principal - Controle de Vacinas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel menuButtonsPanel = new JPanel(new GridLayout(3, 2, 15, 15));

        JButton btnCadastrarPaciente = createMenuButton("Cadastrar Paciente");
        JButton btnListarPacientes = createMenuButton("Listar Pacientes");
        JButton btnRegistrarAplicacao = createMenuButton("Registrar Aplicação");
        JButton btnListarAplicacoes = createMenuButton("Lista de Aplicações");
        JButton btnRelacaoVacina = createMenuButton("Relação Vacina x Prevenção");

        menuButtonsPanel.add(btnCadastrarPaciente);
        menuButtonsPanel.add(btnListarPacientes);
        menuButtonsPanel.add(btnRegistrarAplicacao);
        menuButtonsPanel.add(btnListarAplicacoes);
        menuButtonsPanel.add(btnRelacaoVacina);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.BOLD, 12));

        btnCadastrarPaciente.addActionListener(e -> cadastroPacienteView.exibirFormulario());
        btnListarPacientes.addActionListener(e -> listaPacientesView.exibir());
        btnRegistrarAplicacao.addActionListener(e -> aplicacaoVacinaView.exibirFormulario());

        btnListarAplicacoes.addActionListener(e -> {
            String relatorio = relatorioRepository.gerarRelatorioAplicacoes();
            exibirResultadoEmDialogo(relatorio, "Relatório de Aplicações");
        });

        btnRelacaoVacina.addActionListener(e -> {
            String relatorio = relatorioRepository.gerarRelatorioVacinaPrevencao();
            exibirResultadoEmDialogo(relatorio, "Relatório Vacina x Prevenção");
        });

        btnSair.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });

        mainPanel.add(menuButtonsPanel, BorderLayout.CENTER);
        mainPanel.add(btnSair, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);
    }

    private JButton createMenuButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void exibirResultadoEmDialogo(String resultado, String titulo) {
        JTextArea textArea = new JTextArea(resultado);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
