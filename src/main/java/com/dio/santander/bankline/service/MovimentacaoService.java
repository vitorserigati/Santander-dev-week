package com.dio.santander.bankline.service;

import com.dio.santander.bankline.dto.NovaMovimentacao;
import com.dio.santander.bankline.model.Correntista;
import com.dio.santander.bankline.model.Movimentacao;
import com.dio.santander.bankline.model.MovimentacaoTipo;
import com.dio.santander.bankline.repository.CorrentistaRepository;
import com.dio.santander.bankline.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;
    public void save(NovaMovimentacao novaMovimentacao){
        Movimentacao movimentacao = new Movimentacao();
        Double valor = novaMovimentacao.getTipo()== MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(novaMovimentacao.getValor());

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);

        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }
}
