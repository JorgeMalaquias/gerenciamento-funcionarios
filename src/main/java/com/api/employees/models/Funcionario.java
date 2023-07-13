package com.api.employees.models;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Funcionario extends Pessoa {
    @Column(nullable = false)
    private BigDecimal salario;
    @Column(length = 30, nullable = false)
    private String funcao;
}
