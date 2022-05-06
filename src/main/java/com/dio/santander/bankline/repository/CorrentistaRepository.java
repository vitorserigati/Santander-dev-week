package com.dio.santander.bankline.repository;

import com.dio.santander.bankline.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}