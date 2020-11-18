package br.caed.dto;

import br.caed.domain.Tecnico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoDTO {
     Integer id;
     String nome;
     String rg;
     String cpf;
     LocalDate dataNascimento;
     LocalDateTime dataCadastro = LocalDateTime.now();

    public TecnicoDTO(Tecnico objTecnico) {
        id = objTecnico.getId();
        nome = objTecnico.getNome();
        rg = objTecnico.getRg();
        cpf = objTecnico.getCpf();
        dataNascimento = objTecnico.getDataNascimento();
        dataCadastro = objTecnico.getDataCadastro();
    }
}