package br.com.welssoncavalcante.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.welssoncavalcante.domain.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa,String> {

	Optional<Pessoa> findByNome (String nome);
	
	Optional<Pessoa> findByCpf (String cpf);
	
}
