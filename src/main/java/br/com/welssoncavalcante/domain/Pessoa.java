package br.com.welssoncavalcante.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import br.com.welssoncavalcante.dto.PessoaDTO;


@Document()
public class Pessoa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;
	private String nome;
	private String sexo;
	private String email;
	private String dataNascimento;
	private String naturalidade;
	private String nacionalidade;
	private String cpf;
	private String dataCadastro;
	private String dataAtualizado;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}

	public Pessoa(
			String nome,
			String sexo,
			String email,
			String dataNascimento,
			String naturalidade,
			String nacionalidade,
			String cpf,
			String dataCadastro,
			String dataAtualizado
			) {
    	this.nome = nome;
    	this.sexo = sexo;
    	this.email = email;
    	this.dataNascimento = dataNascimento;
    	this.naturalidade = naturalidade;
    	this.nacionalidade = nacionalidade;
    	this.cpf = cpf;
    	this.dataCadastro = dataCadastro;
    	this.dataAtualizado = dataAtualizado;
	}

	public Pessoa(
			String id,
			String nome,
			String sexo,
			String email,
			String dataNascimento,
			String naturalidade,
			String nacionalidade,
			String cpf,
			String dataCadastro,
			String dataAtualizado
			) {
        this.id = id;
    	this.nome = nome;
    	this.sexo = sexo;
    	this.email = email;
    	this.dataNascimento = dataNascimento;
    	this.naturalidade = naturalidade;
    	this.nacionalidade = nacionalidade;
    	this.cpf = cpf;
    	this.dataCadastro = dataCadastro;
    	this.dataAtualizado = dataAtualizado;
	}
	

    public Pessoa(PessoaDTO pessoaDTO) {
        this.id = pessoaDTO.getId();
    	this.nome = pessoaDTO.getNome();
    	this.sexo = pessoaDTO.getSexo();
    	this.email = pessoaDTO.getEmail();
    	this.dataNascimento = pessoaDTO.getDataNascimento();
    	this.naturalidade = pessoaDTO.getNaturalidade();
    	this.nacionalidade = pessoaDTO.getNacionalidade();
    	this.cpf = pessoaDTO.getCpf();
    	this.dataCadastro = pessoaDTO.getDataCadastro();
    	this.dataAtualizado = pessoaDTO.getDataAtualizado();
    }


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataAtualizado() {
		return dataAtualizado;
	}

	public void setDataAtualizado(String dataAtualizado) {
		this.dataAtualizado = dataAtualizado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
