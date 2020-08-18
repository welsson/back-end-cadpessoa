package br.com.welssoncavalcante.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.welssoncavalcante.domain.Pessoa;
import br.com.welssoncavalcante.dto.PessoaDTO;
import br.com.welssoncavalcante.payload.response.MessageResponse;
import br.com.welssoncavalcante.services.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	PessoaService pessoaService;
	
    @GetMapping("/pessoas")
    public ResponseEntity<List<PessoaDTO>> findAll() {
        List<Pessoa> pessoas = pessoaService.findAll();
        List<PessoaDTO> listDTO = pessoas.stream().map(x -> new PessoaDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

    @GetMapping("/pessoas/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable String id) {
    	Pessoa pessoa = pessoaService.findById(id);
        return ResponseEntity.ok().body(new PessoaDTO(pessoa));
    }

    
    @PostMapping("/pessoas")
    public ResponseEntity<?> create(@RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaService.fromDTO(pessoaDTO);
        boolean verifyCpf = pessoaService.getCpf(pessoaDTO.getCpf());
        if (verifyCpf) {
        	ResponseEntity
			.badRequest()
			.body(new MessageResponse("Error: CPF já cadastrado"));
        	return ResponseEntity.ok().body(null);
        }else
        	return ResponseEntity.ok().body(pessoaService.create(pessoa));
    }

    
    @PutMapping("/pessoas/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable String id, @RequestBody PessoaDTO pessoaDTO) {

    	Pessoa pessoa = pessoaService.fromDTO(pessoaDTO);
        pessoa.setId(id);
        return ResponseEntity.ok().body(new PessoaDTO(pessoaService.update(pessoa)));
    }
    @DeleteMapping("/pessoas/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
    	pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

	

}
