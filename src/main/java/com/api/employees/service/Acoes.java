package com.api.employees.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.employees.DTOs.FuncionarioDados;
import com.api.employees.models.Funcionario;
import com.api.employees.repository.Repository;

@Service
public class Acoes {
    @Autowired
    private Repository repositorio;

    public void inserirTodos() {
        List<Funcionario> lista = new ArrayList<Funcionario>();

        lista.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44), "Operador"));
        lista.add(new Funcionario("João", LocalDate.of(1990, 05, 12), new BigDecimal(2284.38), "Operador"));
        lista.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal(9836.14), "Coordenador"));
        lista.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88), "Diretor"));
        lista.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal(2234.68), "Recepcionista"));
        lista.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72), "Operador"));
        lista.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal(4071.84), "Contador"));
        lista.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal(3017.45), "Gerente"));
        lista.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal(1606.85), "Eletricista"));
        lista.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93), "Gerente"));

        repositorio.saveAll(lista);
    }

    public List<FuncionarioDados> listarTodos() {
        return repositorio.findAllAndFilter();
    }

    public List<Funcionario> listar() {
        return repositorio.findAll();
    }

    public void deletarPorNome() {
        Funcionario funcionario = repositorio.findByNome("João");
        System.out.println(funcionario.getNascimento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        repositorio.deleteById(funcionario.getId());
    }

    public void aumentarSalarios() {
        repositorio.increasingSalary();
    }

    public List<FuncionarioDados> listarAgrupadosPorFuncao() {
        return repositorio.findAllGroupedByFuncao();
    }
}
