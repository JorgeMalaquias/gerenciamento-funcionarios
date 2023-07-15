package com.api.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.employees.DTOs.FuncionarioDados;
import com.api.employees.DTOs.FuncionarioIdade;
import com.api.employees.models.Funcionario;
import com.api.employees.service.Acoes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class Controller {

    @Autowired
    private Acoes acoes;

    @PostMapping("/funcionarios")
    public void criarFuncionarios() {
        acoes.inserirTodos();
    }

    @GetMapping("/funcionarios")
    public List<FuncionarioDados> listarTodos() {
        return acoes.listarTodos();
    }

    @DeleteMapping("/funcionarios")
    public void deletarPorNome() {
        acoes.deletarPorNome();
    }

    @PatchMapping("/funcionarios")
    public void aumentarSalarios() {
        acoes.aumentarSalarios();
    }

    @GetMapping("/funcionarios/funcao")
    public List<FuncionarioDados> listarAgrupadosPorFuncao() {
        return acoes.listarAgrupadosPorFuncao();
    }

    @GetMapping("/funcionarios/mes-aniversario")
    public List<FuncionarioDados> listarAniversariantesDoMes() {
        return acoes.listarAniversariantesDoMes();
    }

    @GetMapping("/funcionarios/nome")
    public List<FuncionarioDados> listarTodosOrdenadosPorNomes() {
        return acoes.listarTodosOrdenadosPorNome();
    }

    @GetMapping("/funcionarios/mais-velho")
    public FuncionarioIdade listarMaisVelho() {
        return acoes.listarMaisVelho();

    }
}
