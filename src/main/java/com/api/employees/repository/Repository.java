package com.api.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.api.employees.DTOs.FuncionarioDados;
import com.api.employees.models.Funcionario;

public interface Repository extends JpaRepository<Funcionario, Long> {
    /*
     * @Query(value = "SELECT nome, nascimento, salario, funcao FROM Pessoa",
     * nativeQuery = true)
     * List<FuncionarioDados> findAllAndFilter();
     */

    @Query(value = "SELECT nome, nascimento, FORMATDATETIME(nascimento,'dd-MM-yyyy') AS nascimentoFormatado , salario, funcao FROM Pessoa", nativeQuery = true)
    List<FuncionarioDados> findAllAndFilter();

    Funcionario findByNome(String nome);
}

// DATE(nascimento.format(DateTimeFormatter.ofPattern('dd-MM-yyyy')))