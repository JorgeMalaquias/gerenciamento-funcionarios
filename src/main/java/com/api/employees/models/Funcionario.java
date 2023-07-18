package com.api.employees.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/*record FuncionarioDados(String nome, LocalDate nascimento, BigDecimal salario, String funcao) {

}*/

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Funcionario extends Pessoa {
    public Funcionario(String nome, int ano, int mes, int dia, double salario, String funcao) {
        this.nome = nome;
        this.nascimento = LocalDate.of(ano, mes, dia);
        this.salario = new BigDecimal(salario);
        this.funcao = funcao;
    }

    @Column(nullable = false)
    private BigDecimal salario;
    @Column(length = 30, nullable = false)
    private String funcao;
}
