package com.dio.santander.bankline.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Conta {

    @Column(name = "conta_numero")
    private Long Numero;

    @Column(name = "conta_saldo")
    private Double Saldo;

    public Long getNumero() {
        return Numero;
    }

    public void setNumero(Long numero) {
        this.Numero = numero;
    }

    public Double getSaldo() {
        return Saldo;
    }

    public void setSaldo(Double saldo) {
        this.Saldo = saldo;
    }
}
