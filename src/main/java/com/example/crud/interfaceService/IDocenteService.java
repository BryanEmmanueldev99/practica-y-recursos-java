package com.example.crud.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.crud.dto.Docente;


public interface IDocenteService {
      public List<Docente>getDocentes();
      public Optional<Docente>getIdDocente(Long id);
      public int storeDocente(Docente d);
      public void optinal_store(Docente docente);
      public void UpdateDocente(Long id, Docente docente);
      public Long saveDocente(Long id);
      public void deleteDocente(Long id);
}
