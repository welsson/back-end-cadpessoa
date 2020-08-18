package br.com.welssoncavalcante.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.welssoncavalcante.domain.Pessoa;
import br.com.welssoncavalcante.dto.PessoaDTO;
import br.com.welssoncavalcante.repository.PessoaRepository;
import br.com.welssoncavalcante.services.exception.ObjectNotFoundException;

@Service
public class PessoaService {
	
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public Boolean getCpf(String cpf) {
        return pessoaRepository.findByCpf(cpf).isPresent();
    }

    public  Pessoa findById(String id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return pessoa.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada!"));
    }

    public  Pessoa findByNome(String nome) {
        Optional<Pessoa> pessoa = pessoaRepository.findByNome(nome);
        return pessoa.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado!"));
    }

    public Pessoa create(Pessoa pessoa){
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	pessoa.setDataCadastro(LocalDate.now().format(formatter));
        return pessoaRepository.save(pessoa);
    }

    public Pessoa fromDTO (PessoaDTO pessoaDTO) {
        return new Pessoa(pessoaDTO); 
    }
    
    public Pessoa update(Pessoa pessoa) {
        Optional<Pessoa> updatePessoa = pessoaRepository.findById(pessoa.getId());
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        pessoa.setDataAtualizado(LocalDate.now().format(formatter));
        return updatePessoa.map(u -> pessoaRepository.save(new Pessoa(u.getId(),
        		pessoa.getNome(), 
        		pessoa.getSexo(), pessoa.getEmail(), pessoa.getDataNascimento(),
        		pessoa.getNaturalidade(), pessoa.getNacionalidade(),
        		pessoa.getCpf(), pessoa.getDataCadastro(), pessoa.getDataAtualizado())))
                .orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrada!"));
    }

    public void delete(String id) {
    	pessoaRepository.deleteById(id);
    }



}
