package com.dio.santander.bankline.repository;

import com.dio.santander.bankline.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    public List<Movimentacao>findByIdConta(Integer idConta);
}