package br.caed.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("pessoa")
public class Pessoa {
    @Id
    @Column("ID")
    private Integer id;

    @Column("NOME")
    private String nome;

    @Column("CPF")
    private String cpf;

    @Column("SEXO")
    private String sexo;

    @Column("EMAIL")
    private String email;

    @Column("MAIOR_IDADE")
    private String maiorIdade;

    @Column("DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column("DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaiorIdade() {
        return maiorIdade;
    }

    public void setMaiorIdade(String maiorIdade) {
        this.maiorIdade = maiorIdade;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }
}