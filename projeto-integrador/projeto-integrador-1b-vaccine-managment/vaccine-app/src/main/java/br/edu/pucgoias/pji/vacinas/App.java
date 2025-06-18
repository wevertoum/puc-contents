package br.edu.pucgoias.pji.vacinas;

import br.edu.pucgoias.pji.vacinas.view.MenuView;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MenuView menu = new MenuView();
            menu.exibir();
        });
    }
}