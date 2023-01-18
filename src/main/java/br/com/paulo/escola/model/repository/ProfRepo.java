package br.com.paulo.escola.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.paulo.escola.model.entity.Professor;

public interface ProfRepo extends JpaRepository<Professor, Integer>{

}
