package com.magalhaes.recuperacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.magalhaes.recuperacao.modelo.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    @Query(value="select * from Disciplina where nome like ?", nativeQuery = true)
    public Disciplina findByNome(String nome);

}
