package br.caed.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@With
@Table("pessoa")
public class Pessoa {
    @Id
    @Column("ID")
    private Long id;
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
    private String dataCriacao;
    @Column("DATA_ALTERACAO")
    private String dataAlteracao;
}