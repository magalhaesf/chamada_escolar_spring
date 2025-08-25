package com.magalhaes.recuperacao.controller;

import java.util.List;
import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.magalhaes.recuperacao.dto.DisciplinaDto;
import com.magalhaes.recuperacao.modelo.Disciplina;
import com.magalhaes.recuperacao.repository.DisciplinaRepository;

@RestController
@RequestMapping(value = "/disciplina")
public class DisciplinaController {

    
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping(value = "/listaDisciplina")
    public List<Disciplina> findAll(){
        return disciplinaRepository.findAll();

    }

    @PostMapping(value = "/insert")
    public ResponseEntity<?> insert(@RequestBody DisciplinaDto disciplinaDto){
        Disciplina disciplina = disciplinaDto.novaDisciplina();
        System.out.println(disciplina.toString());

        disciplinaRepository.save(disciplina);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/id")
        .buildAndExpand(disciplina.getId())
        .toUri();

    return ResponseEntity.created(uri).body(disciplina);
    }

    @DeleteMapping(value = "apagar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        disciplinaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    
}

