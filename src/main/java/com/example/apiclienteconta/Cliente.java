package com.example.apiclienteconta;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Size(min = 11, max = 11)
    @CPF
    private String cpf;

    @NotNull
    @Size(min = 2, max = 200)
    private String nome;


    @NotNull
    @Size(min = 11, max = 2000)
    @Email
    private String email;


    @NotNull
    @Size(min = 11, max = 2000)
    private String telefone;


    @NotNull
    @Size(max = 30)
    private String idhash;

    @NotNull
    private String senha;

    public Cliente(String cpf, String nome, String email, String telefone, String idhash, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.idhash = idhash;
        this.senha = senha;
    }

    public Cliente() {

    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIdhash() {
        return idhash;
    }

    public void setIdhash(String idhash) {
        this.idhash = idhash;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "\nCliente:" +
                "\nCPF: " + cpf +
                "\nNome: " + nome +
                "\nEmail: " + email +
                "\nTelefone: " + telefone;
    }
}
