package com.example.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dto.Docente;
import com.example.crud.interfaceService.IDocenteService;
import com.example.crud.interfaces.IDocente;

@Service
public class DocenteService implements IDocenteService {

    @Autowired
    private IDocente iDocente;

    @Override
    public List<Docente> getDocentes() {
        List<Docente> docentes = iDocente.findAll();
        return docentes;
    }

    @Override
    public Optional<Docente> getIdDocente(Long id) {
        Optional<Docente> docente = iDocente.findById(id);
        return docente;
    }

    @Override
    public int storeDocente(Docente d) {
        int response = 0;
        Docente docente = iDocente.save(d);
        if(!docente.equals(null)) response = 1;
        return response;
    }

    @Override
    //Este metodo tambien guarda como el de arriba, pero me gusta más este
    public void optinal_store(Docente docente) {
        iDocente.save(docente);
    }

    @Override
    public void UpdateDocente(Long id, Docente docente) {
        Optional<Docente> recuperaDocente = iDocente.findById(id);
        if(!recuperaDocente.isPresent()) {
            //no hagas nada
        } else {
          docente.setId(recuperaDocente.get().getId());
          iDocente.save(docente);
        }
    }

    @Override
    public Long saveDocente(Long id) {
        //ESTE YA NO
        return null;
    }

    @Override
    public void deleteDocente(Long id) {
        Docente docenteId = iDocente.findById(id).get();
        iDocente.delete(docenteId);
    }

   

}
