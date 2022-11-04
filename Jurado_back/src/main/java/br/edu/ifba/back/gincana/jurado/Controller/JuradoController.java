package br.edu.ifba.back.gincana.jurado.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifba.back.gincana.jurado.Model.JuradoModel;
import br.edu.ifba.back.gincana.jurado.Repository.*;

@RestController
@RequestMapping("/jurado")
public class JuradoController {
	
	@Autowired
	private JuradoRepository repository;
	
	@GetMapping("/listall")
	public List<JuradoModel> listall() {
		List<JuradoModel> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
    public JuradoModel findById(@PathVariable Long id) {
		Optional<JuradoModel> obj = repository.findById(id);
		if ( obj.isPresent() )
			return obj.get();
        return null;
    }
	
	@PostMapping
	public JuradoModel insert (@RequestBody JuradoModel jurado) {
		JuradoModel result = repository.save(jurado);
		return result;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<JuradoModel> delete(@PathVariable Long id) {
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<JuradoModel> update(@PathVariable Long id, @RequestBody JuradoModel juradoModel) {
		var p = repository.findById(id);
        if (p.isPresent()) {
            var jurado = p.get();
            
            if (juradoModel.getNomeJurado() != null)
            	jurado.setNomeJurado(juradoModel.getNomeJurado());
            
            repository.save(jurado);
            return ResponseEntity.ok(jurado);
        } else {
        	return ResponseEntity.notFound().build();
        }
	}
}
