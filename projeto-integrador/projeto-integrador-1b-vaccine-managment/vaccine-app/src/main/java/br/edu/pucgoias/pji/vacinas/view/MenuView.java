package br.edu.pucgoias.pji.vacinas.view;

import br.edu.pucgoias.pji.vacinas.repository.RelatorioRepository;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuView {

    private final RelatorioRepository relatorioRepository;
    private final CadastroPacienteView cadastroPacienteView;
    private final ListaPacientesView listaPacientesView;

    public MenuView() {
        this.relatorioRepository = new RelatorioRepository();
        this.cadastroPacienteView = new CadastroPacienteView();
        this.listaPacientesView = new ListaPacientesView();
    }

    public void exibir() {
        String[] opcoes = {"Cadastrar Paciente", "Lista de Aplicações (Vacinas)", "Relação Vacina x Prevenção", "Sair"};

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Selecione uma opção:",
                    "Menu Principal - Controle de Vacinas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            switch (escolha) {
                case 0 -> // Cadastrar Paciente
                    cadastroPacienteView.exibirFormulario();
                case 1 -> // Listar Pacientes
                    listaPacientesView.exibir();
                case 2 -> {
                    // Lista de Aplicações
                    String relatorioAplicacoes = relatorioRepository.gerarRelatorioAplicacoes();
                    exibirResultadoEmDialogo(relatorioAplicacoes, "Relatório de Aplicações");
                }
                case 3 -> {
                    // Relação Vacina x Prevenção
                    String relatorioPrevencao = relatorioRepository.gerarRelatorioVacinaPrevencao();
                    exibirResultadoEmDialogo(relatorioPrevencao, "Relatório Vacina x Prevenção");
                }
                case 4, JOptionPane.CLOSED_OPTION -> {
                    JOptionPane.showMessageDialog(null, "Encerrando aplicação...");
                    return;
                }
            }
            // Sair
        }
    }

    private void exibirResultadoEmDialogo(String resultado, String titulo) {
        JTextArea textArea = new JTextArea(resultado);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 400));
        JOptionPane.showMessageDialog(null, scrollPane, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
