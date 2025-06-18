package br.edu.pucgoias.pji.vacinas.model;

public class Regiao {

    private final int id;
    private final String nome;

    public Regiao(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
