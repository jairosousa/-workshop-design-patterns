package com.algaworks.model;

/**
 * @Autor Jairo Nascimento
 * @Created 02/01/2022 - 11:01
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

    public Boolean getVip() {
        return vip;
    }

    public void setVip(Boolean vip) {
        this.vip = vip;
    }

    public Boolean isVip() {
        return vip;
    }
}
