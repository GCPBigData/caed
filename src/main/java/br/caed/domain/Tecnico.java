package br.caed.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("tecnico")
public class Tecnico {

    @Id
    Integer id;
    String nome;
    String rg;
    String cpf;
    @Column("data_nascimento")
    LocalDate dataNascimento;
    LocalDateTime dataCadastro = LocalDateTime.now();

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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tecnico)) return false;
        Tecnico tecnico = (Tecnico) o;
        return getId().equals(tecnico.getId()) &&
                getNome().equals(tecnico.getNome()) &&
                getRg().equals(tecnico.getRg()) &&
                getCpf().equals(tecnico.getCpf()) &&
                getDataNascimento().equals(tecnico.getDataNascimento()) &&
                getDataCadastro().equals(tecnico.getDataCadastro());
    }


}