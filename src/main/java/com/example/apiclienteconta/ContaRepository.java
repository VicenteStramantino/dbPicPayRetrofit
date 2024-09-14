package com.example.apiclienteconta;

import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
