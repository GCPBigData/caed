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
     String nomeMae;
     String endereco;
     String cidade;
     String estado;
     String cep;
     String pais;
     String telefone;
     BigDecimal valorChamado;
     BigDecimal valorHora;
     BigDecimal valorMes;
     String banco;
     String agencia;
     String conta;
     String nomeTitularConta;
     String cpfTitularConta;
     String status;
     LocalDateTime dataCadastro = LocalDateTime.now();

    public TecnicoDTO(Tecnico objTecnico) {
        id = objTecnico.getId();
        nome = objTecnico.getNome();
        rg = objTecnico.getRg();
        cpf = objTecnico.getCpf();
        dataNascimento = objTecnico.getDataNascimento();
        nomeMae = objTecnico.getNomeMae();
        endereco = objTecnico.getEndereco();
        cidade = objTecnico.getCidade();
        estado = objTecnico.getEstado();
        cep = objTecnico.getCep();
        pais = objTecnico.getPais();
        telefone = objTecnico.getTelefone();
        valorChamado = objTecnico.getValorChamado();
        valorHora = objTecnico.getValorHora();
        valorMes = objTecnico.getValorMes();
        banco = objTecnico.getBanco();
        agencia = objTecnico.getAgencia();
        conta = objTecnico.getConta();
        nomeTitularConta = objTecnico.getNomeTitularConta();
        cpfTitularConta = objTecnico.getCpfTitularConta();
        status = objTecnico.getStatus();
        dataCadastro = objTecnico.getDataCadastro();
    }
}