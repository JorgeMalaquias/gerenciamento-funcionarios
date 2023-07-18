package com.api.employees.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.employees.DTOs.FuncionarioDados;
import com.api.employees.DTOs.FuncionarioIdade;
import com.api.employees.DTOs.FuncionarioSalarioMinimo;
import com.api.employees.service.Acoes;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class Controller {

    @Autowired
    private Acoes acoes;

    @PostMapping("/funcionarios")
    public void inserirFuncionarios() {
        acoes.inserirTodos();
    }

    // Para deletar João da lista, basta passar "João" como parâmetro na url ficando
    // assim "/funcionarios/João"
    @DeleteMapping("/funcionarios/{nome}")
    public void deletarPorNome(@PathVariable String nome) {
        acoes.deletarPorNome(nome);
    }

    @GetMapping("/funcionarios")
    public List<FuncionarioDados> listarTodosFuncionarios() {
        return acoes.listarTodos();
    }

    @PatchMapping("/funcionarios")
    public void aumentarSalarios() {
        acoes.aumentarSalarios();
    }

    @GetMapping("/funcionarios/map")
    public Map<String, List<FuncionarioDados>> listaragrupadosEmMapPorFuncao() {
        return acoes.agrupadosEmMapPorFuncao();
    }

    @GetMapping("/funcionarios/funcao")
    public List<FuncionarioDados> listarAgrupadosPorFuncao() {
        return acoes.listarAgrupadosPorFuncao();
    }

    @GetMapping("/funcionarios/mes-aniversario")
    public List<FuncionarioDados> listarAniversariantesDoMes() {
        return acoes.listarAniversariantesDoMes();
    }

    @GetMapping("/funcionarios/mais-velho")
    public FuncionarioIdade listarMaisVelho() {
        return acoes.listarMaisVelho();

    }

    @GetMapping("/funcionarios/nome")
    public List<FuncionarioDados> listarTodosOrdenadosPorNomes() {
        return acoes.listarTodosOrdenadosPorNome();
    }

    @GetMapping("/funcionarios/total-salarios")
    public String totalDeSalarios() {
        return "O total em salários de funcionários é " + acoes.totalDeSalarios();
    }

    @GetMapping("/funcionarios/salarios-minimos")
    public List<FuncionarioSalarioMinimo> listarTodosComSalariosMinimos() {
        return acoes.listarTodosComSalariosMinimos();
    }

}
