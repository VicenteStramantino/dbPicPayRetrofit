package com.example.apiclienteconta;


import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "conta")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private long numero_conta;

    private double saldo;

    private double limite_especial;

    private String cliente_cpf;


    public Conta(long numero_conta, double saldo, double limite_especial, String cliente_cpf) {
        this.numero_conta = numero_conta;
        this.saldo = saldo;
        this.limite_especial = limite_especial;
        this.cliente_cpf = cliente_cpf;
    }

    public Conta() {

    }

    public long getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(long numero_conta) {
        this.numero_conta = numero_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite_especial() {
        return limite_especial;
    }

    public void setLimite_especial(double limite_especial) {
        this.limite_especial = limite_especial;
    }

    public String getCliente_cpf() {
        return cliente_cpf;
    }

    public void setCliente_cpf(String cliente_cpf) {
        this.cliente_cpf = cliente_cpf;
    }

    @Override
    public String toString() {
        return "\nConta: " +
                "\nNumero da conta:" + numero_conta +
                "\nSaldo: " + saldo +
                "\nLimite especial: " + limite_especial +
                "\nCpf do cliente: " + cliente_cpf;
    }
}
