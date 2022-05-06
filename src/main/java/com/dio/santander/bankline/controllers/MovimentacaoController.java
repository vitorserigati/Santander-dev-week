package com.dio.santander.bankline.controllers;

import com.dio.santander.bankline.dto.NovaMovimentacao;
import com.dio.santander.bankline.dto.NovoCorrentista;
import com.dio.santander.bankline.model.Correntista;
import com.dio.santander.bankline.model.Movimentacao;
import com.dio.santander.bankline.repository.CorrentistaRepository;
import com.dio.santander.bankline.repository.MovimentacaoRepository;
import com.dio.santander.bankline.service.CorrentistaService;
import com.dio.santander.bankline.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;
    @Autowired
    private MovimentacaoService service;
    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao){
        service.save(movimentacao);
    }
}
