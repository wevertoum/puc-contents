
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import models.Movie;

public class App {

    public static void main(String[] args) {

        Queue<Movie> movieWatchlist = new LinkedList<>();

        while (true) {
            String[] options = {"Adicionar Filme", "Ver Lista de Filmes", "Assistir Próximo Filme", "Sair"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Sistema de Streaming de Filmes",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);

            switch (choice) {
                case 0 ->
                    addMovie(movieWatchlist);
                case 1 ->
                    showWatchlist(movieWatchlist);
                case 2 ->
                    watchNextMovie(movieWatchlist);
                case 3, -1 -> {

                    JOptionPane.showMessageDialog(null, "Fechando o sistema. Até logo!");
                    return;
                }
            }

        }
    }

    private static void addMovie(Queue<Movie> watchlist) {
        String title = JOptionPane.showInputDialog(null, "Digite o título do filme:");
        if (title == null || title.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O título não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String director = JOptionPane.showInputDialog(null, "Digite o diretor do filme:");
        if (director == null || director.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "O diretor não pode ser vazio.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Movie newMovie = new Movie(title.trim(), director.trim());
        watchlist.offer(newMovie);
        JOptionPane.showMessageDialog(null, "Filme \"" + title + "\" adicionado à lista!");
    }

    private static void showWatchlist(Queue<Movie> watchlist) {
        if (watchlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sua lista de filmes está vazia.");
            return;
        }

        StringBuilder listContent = new StringBuilder("Sua lista para assistir (do primeiro ao último adicionado):\n\n");
        int position = 1;

        for (Movie movie : watchlist) {
            listContent.append(position).append(". ").append(movie.toString()).append("\n");
            position++;
        }

        JOptionPane.showMessageDialog(null, listContent.toString(), "Lista de Filmes", JOptionPane.PLAIN_MESSAGE);
    }

    private static void watchNextMovie(Queue<Movie> watchlist) {
        if (watchlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há filmes na sua lista para assistir.");
            return;
        }

        Movie nextMovie = watchlist.poll();
        JOptionPane.showMessageDialog(null, "Assistindo agora: " + nextMovie.toString(), "Play!", JOptionPane.INFORMATION_MESSAGE);
    }
}
