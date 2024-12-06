package com.example.crud.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.dto.Docente;

@Repository
public interface IDocente extends JpaRepository<Docente, Long> {

}
