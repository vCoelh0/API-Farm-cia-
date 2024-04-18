package com.remedios.vinicius.curso.remedio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {

	List<Remedio> findAllByAtivoTrue();

}
 