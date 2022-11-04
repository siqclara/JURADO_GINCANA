package br.edu.ifba.back.gincana.jurado.Repository;

	
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

import br.edu.ifba.back.gincana.jurado.Model.*;

	@Repository
	public interface JuradoRepository extends JpaRepository<JuradoModel, Long>{

	}


