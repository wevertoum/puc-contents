package br.edu.pucgoias.pji.vacinas.model;

import java.sql.Date;

public class Paciente {

    private final int id;
    private final String nome;
    private final Date dataNascimento;
    private final String endereco;
    private final String nomeRegiao;
    private final String nivelEscolaridade;

    public Paciente(int id, String nome, Date dataNascimento, String endereco, String nomeRegiao, String nivelEscolaridade) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.nomeRegiao = nomeRegiao;
        this.nivelEscolaridade = nivelEscolaridade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNomeRegiao() {
        return nomeRegiao;
    }

    public String getNivelEscolaridade() {
        return nivelEscolaridade;
    }
}
