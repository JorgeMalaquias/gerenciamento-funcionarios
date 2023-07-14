package com.api.employees.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface FuncionarioDados {
    String getNome();

    LocalDate getNascimento();

    String getNascimentoFormatado();

    BigDecimal getSalario();

    String getFuncao();
}