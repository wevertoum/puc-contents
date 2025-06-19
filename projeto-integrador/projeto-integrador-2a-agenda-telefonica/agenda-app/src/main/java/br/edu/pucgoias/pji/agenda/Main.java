package br.edu.pucgoias.pji.agenda;

import javax.swing.SwingUtilities;

import br.edu.pucgoias.pji.agenda.view.MenuView;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuView().exibir();
        });
    }
}
