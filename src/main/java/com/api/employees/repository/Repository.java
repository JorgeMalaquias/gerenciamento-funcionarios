package com.api.employees.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.api.employees.DTOs.FuncionarioDados;
import com.api.employees.DTOs.FuncionarioIdade;
import com.api.employees.DTOs.FuncionarioSalarioMinimo;
import com.api.employees.models.Funcionario;

public interface Repository extends JpaRepository<Funcionario, Long> {
    Funcionario findByNome(String nome);

    @Query(value = "SELECT nome, FORMATDATETIME(nascimento,'dd-MM-yyyy') AS nascimento, TO_CHAR(salario,'99G999D00') AS salario, funcao FROM Pessoa WHERE funcao=:funcao", nativeQuery = true)
    List<FuncionarioDados> findAllByFuncao(String funcao);

    @Query(value = "SELECT nome, FORMATDATETIME(nascimento,'dd-MM-yyyy') AS nascimento, TO_CHAR(salario,'99G999D00') AS salario, funcao FROM Pessoa", nativeQuery = true)
    List<FuncionarioDados> findAllAndFilter();

    @Modifying()
    @Transactional
    @Query(value = "UPDATE Pessoa p SET p.salario = salario*1.1", nativeQuery = true)
    void increasingSalary();

    @Query(value = "SELECT nome, FORMATDATETIME(nascimento,'dd-MM-yyyy') AS nascimento, TO_CHAR(salario,'99G999D00') AS salario, funcao FROM Pessoa GROUP BY funcao, nome", nativeQuery = true)
    List<FuncionarioDados> findAllGroupedByFuncao();

    @Query(value = "SELECT nome, FORMATDATETIME(nascimento,'dd-MM-yyyy') AS nascimento, TO_CHAR(salario,'99G999D00') AS salario, funcao FROM Pessoa WHERE EXTRACT(MONTH FROM nascimento) = 10 OR EXTRACT(MONTH FROM nascimento) = 12", nativeQuery = true)
    List<FuncionarioDados> findAllByMonthBirthDay();

    @Query(value = "SELECT nome, FORMATDATETIME(nascimento,'dd-MM-yyyy') AS nascimento, TO_CHAR(salario,'99G999D00') AS salario, funcao FROM Pessoa ORDER BY nome ASC", nativeQuery = true)
    List<FuncionarioDados> findAllAndOrderByNome();

    @Query(value = "SELECT nome, MAX(DATEDIFF(YEAR, nascimento, NOW())) AS idade FROM Pessoa GROUP BY nascimento", nativeQuery = true)
    List<FuncionarioIdade> findOlder();

    @Query(value = "SELECT TO_CHAR(SUM(salario),'99G999D00') FROM Pessoa", nativeQuery = true)
    String totalSalary();

    @Query(value = "SELECT nome, TO_CHAR(salario/1212,'99D00') AS salariosMinimos FROM Pessoa", nativeQuery = true)
    List<FuncionarioSalarioMinimo> findAllWithMininumSalary();
}

// DATE(nascimento.format(DateTimeFormatter.ofPattern('dd-MM-yyyy')))
