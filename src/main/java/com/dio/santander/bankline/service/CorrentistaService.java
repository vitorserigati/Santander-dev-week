package com.dio.santander.bankline.service;

import com.dio.santander.bankline.dto.NovoCorrentista;
import com.dio.santander.bankline.model.Conta;
import com.dio.santander.bankline.model.Correntista;
import com.dio.santander.bankline.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;
    public void save(NovoCorrentista novocorrentista){
        Correntista correntista = new Correntista();
        correntista.setCpf(novocorrentista.getCpf());
        correntista.setNome(novocorrentista.getNome());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);
        repository.save(correntista);
    }
}
