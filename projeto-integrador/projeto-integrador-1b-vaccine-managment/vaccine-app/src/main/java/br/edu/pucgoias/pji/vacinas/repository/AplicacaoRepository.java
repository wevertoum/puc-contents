package br.edu.pucgoias.pji.vacinas.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.pucgoias.pji.vacinas.db.DatabaseConnection;
import br.edu.pucgoias.pji.vacinas.model.PacienteDropdown;
import br.edu.pucgoias.pji.vacinas.model.Vacina;

public class AplicacaoRepository {

    /**
     * Busca todos os pacientes (ID e Nome) para preencher um dropdown.
     *
     * @return uma lista de objetos PacienteDropdown.
     */
    public List<PacienteDropdown> buscarTodosPacientesParaDropdown() throws SQLException {
        List<PacienteDropdown> pacientes = new ArrayList<>();
        String sql = "SELECT ID_Paciente, Nome FROM Paciente ORDER BY Nome";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                pacientes.add(new PacienteDropdown(rs.getInt("ID_Paciente"), rs.getString("Nome")));
            }
        }
        return pacientes;
    }

    /**
     * Busca todas as vacinas (ID e Nome) para preencher um dropdown.
     *
     * @return uma lista de objetos Vacina.
     */
    public List<Vacina> buscarTodasVacinas() throws SQLException {
        List<Vacina> vacinas = new ArrayList<>();
        String sql = "SELECT ID_Vacina, Nome_Vacina FROM Vacina ORDER BY Nome_Vacina";

        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                vacinas.add(new Vacina(rs.getInt("ID_Vacina"), rs.getString("Nome_Vacina")));
            }
        }
        return vacinas;
    }

    /**
     * Registra uma nova aplicação de vacina no banco de dados.
     *
     * @param idPaciente O ID do paciente selecionado.
     * @param idVacina O ID da vacina selecionada.
     * @param dataAplicacao A data da aplicação no formato AAAA-MM-DD.
     * @param numeroDose O número da dose.
     */
    public boolean registrarAplicacao(int idPaciente, int idVacina, String dataAplicacao, int numeroDose) {
        String sql = "INSERT INTO Aplicacao_Vacina (ID_Paciente, ID_Vacina, Data_Aplicacao, Numero_Dose) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPaciente);
            pstmt.setInt(2, idVacina);
            pstmt.setString(3, dataAplicacao);
            pstmt.setInt(4, numeroDose);

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (SQLException e) {
            return false;
        }
    }
}
