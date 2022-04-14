package br.com.zup.edu.personmanager.controller;

import br.com.zup.edu.personmanager.model.Pessoa;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class PessoaResponse {

    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String apelido;
    private String cpf;

    public PessoaResponse(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.apelido = pessoa.getApelido();
        this.cpf = pessoa.getCpf();
    }

    public PessoaResponse() {
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getApelido() {
        return apelido;
    }

    public String getCpf() {
        return cpf;
    }
}
