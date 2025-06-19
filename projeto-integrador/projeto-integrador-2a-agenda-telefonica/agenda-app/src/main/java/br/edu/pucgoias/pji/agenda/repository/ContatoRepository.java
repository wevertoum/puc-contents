package br.edu.pucgoias.pji.agenda.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.edu.pucgoias.pji.agenda.db.DatabaseConnection;
import br.edu.pucgoias.pji.agenda.model.Contato;

public class ContatoRepository {

    // adicionarContato (CREATE)
    public boolean adicionarContato(Contato contato) {
        String sql = "INSERT INTO contato(nome, telefone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getEmail());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // listarContatos (READ)
    public List<Contato> listarContatos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM contato ORDER BY nome";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contatos.add(new Contato(
                        rs.getInt("id_contato"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("email")));
            }
        } catch (SQLException e) {
        }
        return contatos;
    }

    // atualizarContato (UPDATE)
    public boolean atualizarContato(Contato contato) {
        String sql = "UPDATE contato SET nome = ?, telefone = ?, email = ? WHERE id_contato = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getTelefone());
            pstmt.setString(3, contato.getEmail());
            pstmt.setInt(4, contato.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    // removerContato (DELETE)
    public boolean removerContato(int id) {
        String sql = "DELETE FROM contato WHERE id_contato = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
