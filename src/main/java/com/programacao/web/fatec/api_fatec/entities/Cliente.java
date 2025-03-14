package com.programacao.web.fatec.api_fatec.entities;

public class Cliente {
    private Long id;
    private String nome;
    private int idade;
    private String endereco;
    
    public void cliente() {

    }
    public Long getId() {
        return id;
    }
    public void setId(Long idCount) {
        this.id = idCount;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
