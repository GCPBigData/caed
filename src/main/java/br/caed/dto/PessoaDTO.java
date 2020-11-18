package br.caed.dto;

import br.caed.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
     Integer id;
     String nome;
     String cpf;
     String sexo;
    LocalDate dataNascimento;
     String email;
     String maiorIdade;
     LocalDateTime dataCriacao;
     LocalDateTime dataAlteracao;

    public PessoaDTO(Pessoa objPessoa) {
        id = objPessoa.getId();
        nome = objPessoa.getNome();
        cpf = objPessoa.getCpf();
        sexo = objPessoa.getSexo();
        dataNascimento = objPessoa.getDataNascimento();
        email = objPessoa.getEmail();
        maiorIdade = objPessoa.getMaiorIdade();
        dataCriacao = objPessoa.getDataCriacao();
        dataAlteracao = objPessoa.getDataAlteracao();
    }
}
