package br.edu.pucgoias.pji.vacinas.repository;

import br.edu.pucgoias.pji.vacinas.db.DatabaseConnection;
import br.edu.pucgoias.pji.vacinas.model.Escolaridade;
import br.edu.pucgoias.pji.vacinas.model.Paciente;
import br.edu.pucgoias.pji.vacinas.model.Regiao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    /**
     * Busca todos os pacientes com informações detalhadas de região e
     * escolaridade.
     *
     * @return uma lista de objetos Paciente.
     */
    public List<Paciente> buscarTodosPacientesDetalhado() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        String sql = """
            SELECT
                p.ID_Paciente,
                p.Nome,
                p.Data_Nascimento,
                p.Endereco,
                r.Nome_Regiao,
                e.Nivel AS Nivel_Escolaridade
            FROM
                Paciente AS p
            JOIN
                Regiao AS r ON p.ID_Regiao = r.ID_Regiao
            JOIN
                Escolaridade AS e ON p.ID_Escolaridade = e.ID_Escolaridade
            ORDER BY
                p.Nome;
        """;

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pacientes.add(new Paciente(
                        rs.getInt("ID_Paciente"),
                        rs.getString("Nome"),
                        rs.getDate("Data_Nascimento"),
                        rs.getString("Endereco"),
                        rs.getString("Nome_Regiao"),
                        rs.getString("Nivel_Escolaridade")
                ));
            }
        }
        return pacientes;
    }

    /**
     * Busca todas as regiões cadastradas no banco de dados.
     *
     * @return uma lista de objetos Regiao.
     */
    public List<Regiao> buscarTodasRegioes() throws SQLException {
        List<Regiao> regioes = new ArrayList<>();
        String sql = "SELECT ID_Regiao, Nome_Regiao FROM Regiao ORDER BY Nome_Regiao";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                regioes.add(new Regiao(rs.getInt("ID_Regiao"), rs.getString("Nome_Regiao")));
            }
        }
        return regioes;
    }

    /**
     * Busca todos os níveis de escolaridade cadastrados no banco.
     *
     * @return uma lista de objetos Escolaridade.
     */
    public List<Escolaridade> buscarTodasEscolaridades() throws SQLException {
        List<Escolaridade> escolaridades = new ArrayList<>();
        String sql = "SELECT ID_Escolaridade, Nivel FROM Escolaridade ORDER BY ID_Escolaridade";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                escolaridades.add(new Escolaridade(rs.getInt("ID_Escolaridade"), rs.getString("Nivel")));
            }
        }
        return escolaridades;
    }

    /**
     * Insere um novo paciente no banco de dados.
     */
    public boolean cadastrarPaciente(String nome, String dataNascimento, String endereco, int idRegiao, int idEscolaridade) {
        String sql = "INSERT INTO `Paciente` (`Nome`, `Data_Nascimento`, `Endereco`, `ID_Regiao`, `ID_Escolaridade`) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nome);
            pstmt.setString(2, dataNascimento);
            pstmt.setString(3, endereco);
            pstmt.setInt(4, idRegiao);
            pstmt.setInt(5, idEscolaridade);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            return false;
        }
    }
}
