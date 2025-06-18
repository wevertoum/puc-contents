package br.edu.pucgoias.pji.vacinas.model;

public class Escolaridade {

    private final int id;
    private final String nivel;

    public Escolaridade(int id, String nivel) {
        this.id = id;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return nivel;
    }
}
