package br.caed.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column("NOME")
    @NonNull
    @Size(max = 100, message = "CPF tamanho naximo 100 digitos")
    private String nome;

    @Column("CPF")
    @NonNull
    @Size(max = 5, message = "CPF tamanho naximo 11 digitos")
    private String cpf;

    @Column("SEXO")
    @NonNull
    private String sexo;

    @Column("DATA_NASCIMENTO")
    @NonNull
    private LocalDate dataNascimento;

    @Column("EMAIL")
    @Email
    private String email;

    @Column("MAIOR_IDADE")
    private String maiorIdade;

    @Column("DATA_CRIACAO")
    private LocalDateTime dataCriacao;

    @Column("DATA_ALTERACAO")
    private LocalDateTime dataAlteracao;


}