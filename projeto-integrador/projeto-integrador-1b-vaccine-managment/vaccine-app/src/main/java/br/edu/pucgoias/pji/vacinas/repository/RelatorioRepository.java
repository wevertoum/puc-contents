package br.edu.pucgoias.pji.vacinas.repository;

import br.edu.pucgoias.pji.vacinas.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RelatorioRepository {

    /**
     * Gera um relatório de todas as vacinas e as doenças que elas previnem.
     *
     * @return uma String formatada com o relatório.
     */
    public String gerarRelatorioVacinaPrevencao() {
        String sql = """
            SELECT
                v.Nome_Vacina,
                d.Nome_Doenca
            FROM
                Vacina_Previne_Doenca AS vpd
            JOIN
                Vacina AS v ON vpd.ID_Vacina = v.ID_Vacina
            JOIN
                Doenca AS d ON vpd.ID_Doenca = d.ID_Doenca
            ORDER BY
                v.Nome_Vacina;
        """;

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("--- RELAÇÃO VACINA x DOENÇA PREVENIDA ---\n\n");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            String vacinaAtual = "";
            while (rs.next()) {
                String nomeVacina = rs.getString("Nome_Vacina");
                String nomeDoenca = rs.getString("Nome_Doenca");

                if (!nomeVacina.equals(vacinaAtual)) {
                    relatorio.append("\nVACINA: ").append(nomeVacina).append("\n");
                    relatorio.append("  - Previne: ").append(nomeDoenca).append("\n");
                    vacinaAtual = nomeVacina;
                } else {
                    relatorio.append("  - Previne: ").append(nomeDoenca).append("\n");
                }
            }
        } catch (SQLException e) {
            return "Erro ao gerar o relatório: " + e.getMessage();
        }

        return relatorio.toString();
    }

    /**
     * Gera um relatório de todas as aplicações de vacinas por paciente.
     *
     * @return uma String formatada com o relatório.
     */
    public String gerarRelatorioAplicacoes() {
        String sql = """
            SELECT
                p.Nome AS 'Paciente',
                v.Nome_Vacina AS 'Vacina Aplicada',
                av.Data_Aplicacao AS 'Data da Aplicação',
                av.Numero_Dose AS 'Dose',
                (SELECT GROUP_CONCAT(d.Nome_Doenca SEPARATOR ', ')
                 FROM Vacina_Previne_Doenca vpd
                 JOIN Doenca d ON vpd.ID_Doenca = d.ID_Doenca
                 WHERE vpd.ID_Vacina = av.ID_Vacina) AS 'Doenças Prevenidas'
            FROM
                Aplicacao_Vacina AS av
            JOIN
                Paciente AS p ON av.ID_Paciente = p.ID_Paciente
            JOIN
                Vacina AS v ON av.ID_Vacina = v.ID_Vacina
            ORDER BY
                p.Nome, av.Data_Aplicacao;
        """;

        StringBuilder relatorio = new StringBuilder();
        relatorio.append("--- LISTA DE APLICAÇÕES DE VACINAS POR PACIENTE ---\n\n");

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                relatorio.append("Paciente: ").append(rs.getString("Paciente")).append("\n");
                relatorio.append("  - Vacina: ").append(rs.getString("Vacina Aplicada")).append("\n");
                relatorio.append("  - Data: ").append(rs.getDate("Data da Aplicação")).append("\n");
                relatorio.append("  - Dose: ").append(rs.getInt("Dose")).append("ª\n");
                relatorio.append("  - Previne: ").append(rs.getString("Doenças Prevenidas")).append("\n");
                relatorio.append("--------------------------------------------------\n");
            }
        } catch (SQLException e) {
            return "Erro ao gerar o relatório: " + e.getMessage();
        }

        return relatorio.toString();
    }
}
