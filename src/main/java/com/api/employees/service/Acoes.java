package com.api.employees.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.employees.DTOs.FuncionarioDados;
import com.api.employees.DTOs.FuncionarioIdade;
import com.api.employees.DTOs.FuncionarioSalarioMinimo;
import com.api.employees.models.Funcionario;
import com.api.employees.repository.Repository;

@Service
public class Acoes {
    @Autowired
    private Repository repositorio;

    public void inserirTodos() {
        List<Funcionario> lista = new ArrayList<Funcionario>();

        lista.add(new Funcionario("Maria", 2000, 10, 18, 2009.44, "Operador"));
        lista.add(new Funcionario("João", 1990, 05, 12, 2284.38, "Operador"));
        lista.add(new Funcionario("Caio", 1961, 5, 2, 9836.14, "Coordenador"));
        lista.add(new Funcionario("Miguel", 1988, 10, 14, 19119.8, "Diretor"));
        lista.add(new Funcionario("Alice", 1995, 1, 5, 2234.68, "Recepcionista"));
        lista.add(new Funcionario("Heitor", 1999, 11, 19, 1582.72, "Operador"));
        lista.add(new Funcionario("Arthur", 1993, 3, 31, 4071.84, "Contador"));
        lista.add(new Funcionario("Laura", 1994, 7, 8, 3017.45, "Gerente"));
        lista.add(new Funcionario("Heloísa", 2003, 5, 24, 1606.85, "Eletricista"));
        lista.add(new Funcionario("Helena", 1996, 9, 2, 2799.93, "Gerente"));

        repositorio.saveAll(lista);
    }

    public void deletarPorNome(String nome) {
        Funcionario funcionario = repositorio.findByNome(nome);
        repositorio.deleteById(funcionario.getId());
    }

    public List<FuncionarioDados> listarTodos() {
        return repositorio.findAllAndFilter();
    }

    public void aumentarSalarios() {
        repositorio.increasingSalary();
    }

    public Map<String, List<FuncionarioDados>> agrupadosEmMapPorFuncao() {
        Map<String, List<FuncionarioDados>> mapaNomes = new HashMap<String, List<FuncionarioDados>>();

        mapaNomes.put("Operador", repositorio.findAllByFuncao("Operador"));
        mapaNomes.put("Coordenador", repositorio.findAllByFuncao("Coordenador"));
        mapaNomes.put("Diretor", repositorio.findAllByFuncao("Diretor"));
        mapaNomes.put("Recepcionista", repositorio.findAllByFuncao("Recepcionista"));
        mapaNomes.put("Contador", repositorio.findAllByFuncao("Contador"));
        mapaNomes.put("Gerente", repositorio.findAllByFuncao("Gerente"));
        mapaNomes.put("Eletricista", repositorio.findAllByFuncao("Eletricista"));

        return mapaNomes;
    }

    public List<FuncionarioDados> listarAgrupadosPorFuncao() {
        return repositorio.findAllGroupedByFuncao();
    }

    public List<FuncionarioDados> listarAniversariantesDoMes() {
        return repositorio.findAllByMonthBirthDay();
    }

    public FuncionarioIdade listarMaisVelho() {
        return repositorio.findOlder().get(0);
    }

    public List<FuncionarioDados> listarTodosOrdenadosPorNome() {
        return repositorio.findAllAndOrderByNome();
    }

    public String totalDeSalarios() {
        return repositorio.totalSalary();
    }

    public List<FuncionarioSalarioMinimo> listarTodosComSalariosMinimos() {
        return repositorio.findAllWithMininumSalary();
    }
}
