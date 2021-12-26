package com.algaworks.model;

/**
 * @Autor Jairo Nascimento
 * @Created 26/12/2021 - 15:23
 */
public class Cliente {

    private String nome;
    private Boolean vip;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean isVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }
}
