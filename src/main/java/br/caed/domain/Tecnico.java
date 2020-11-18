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
    String nomeMae;
    String endereco;
    String cidade;
    String estado;
    String cep;
    String pais;
    String telefone;
    @Column("valor_chamado")
    BigDecimal valorChamado;
    @Column("valor_hora")
    BigDecimal valorHora;
    @Column("valor_mensal")
    BigDecimal valorMes;
    String banco;
    String agencia;
    String conta;
    @Column("titular_conta")
    String nomeTitularConta;
    @Column("cpf_titular_conta")
    String cpfTitularConta;
    String status;
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

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public BigDecimal getValorChamado() {
        return valorChamado;
    }

    public void setValorChamado(BigDecimal valorChamado) {
        this.valorChamado = valorChamado;
    }

    public BigDecimal getValorHora() {
        return valorHora;
    }

    public void setValorHora(BigDecimal valorHora) {
        this.valorHora = valorHora;
    }

    public BigDecimal getValorMes() {
        return valorMes;
    }

    public void setValorMes(BigDecimal valorMes) {
        this.valorMes = valorMes;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getNomeTitularConta() {
        return nomeTitularConta;
    }

    public void setNomeTitularConta(String nomeTitularConta) {
        this.nomeTitularConta = nomeTitularConta;
    }

    public String getCpfTitularConta() {
        return cpfTitularConta;
    }

    public void setCpfTitularConta(String cpfTitularConta) {
        this.cpfTitularConta = cpfTitularConta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                getNomeMae().equals(tecnico.getNomeMae()) &&
                getEndereco().equals(tecnico.getEndereco()) &&
                getCidade().equals(tecnico.getCidade()) &&
                getEstado().equals(tecnico.getEstado()) &&
                getCep().equals(tecnico.getCep()) &&
                getPais().equals(tecnico.getPais()) &&
                getTelefone().equals(tecnico.getTelefone()) &&
                getValorChamado().equals(tecnico.getValorChamado()) &&
                getValorHora().equals(tecnico.getValorHora()) &&
                getValorMes().equals(tecnico.getValorMes()) &&
                getBanco().equals(tecnico.getBanco()) &&
                getAgencia().equals(tecnico.getAgencia()) &&
                getConta().equals(tecnico.getConta()) &&
                getNomeTitularConta().equals(tecnico.getNomeTitularConta()) &&
                getCpfTitularConta().equals(tecnico.getCpfTitularConta()) &&
                getStatus().equals(tecnico.getStatus()) &&
                getDataCadastro().equals(tecnico.getDataCadastro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome(), getRg(), getCpf(), getDataNascimento(), getNomeMae(), getEndereco(), getCidade(), getEstado(), getCep(), getPais(), getTelefone(), getValorChamado(), getValorHora(), getValorMes(), getBanco(), getAgencia(), getConta(), getNomeTitularConta(), getCpfTitularConta(), getStatus(), getDataCadastro());
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", nomeMae='" + nomeMae + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", cep='" + cep + '\'' +
                ", pais='" + pais + '\'' +
                ", telefone='" + telefone + '\'' +
                ", valorChamado=" + valorChamado +
                ", valorHora=" + valorHora +
                ", valorMes=" + valorMes +
                ", banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", conta='" + conta + '\'' +
                ", nomeTitularConta='" + nomeTitularConta + '\'' +
                ", cpfTitularConta='" + cpfTitularConta + '\'' +
                ", status='" + status + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }

}