package br.caed.dto;

import br.caed.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
     Integer id;
     String nome;
     String cpf;
     String sexo;
     String email;
     String maiorIdade;
     LocalDateTime dataCriacao;
     LocalDateTime dataAlteracao;

    public PessoaDTO(Pessoa objPessoa) {
        id = objPessoa.getId();
        nome = objPessoa.getNome();
        cpf = objPessoa.getCpf();
        sexo = objPessoa.getEmail();
        email = objPessoa.getEmail();
        maiorIdade = objPessoa.getMaiorIdade();
        dataCriacao = objPessoa.getDataCriacao();
        dataAlteracao = objPessoa.getDataAlteracao();
    }
}
