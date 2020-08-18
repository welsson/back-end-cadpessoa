package br.com.welssoncavalcante.dto;

import java.io.Serializable;

import br.com.welssoncavalcante.domain.Pessoa;

public class PessoaDTO implements Serializable {
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

    public PessoaDTO() { }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
    	this.nome = pessoa.getNome();
    	this.sexo = pessoa.getSexo();
    	this.email = pessoa.getEmail();
    	this.dataNascimento = pessoa.getDataNascimento();
    	this.naturalidade = pessoa.getNaturalidade();
    	this.nacionalidade = pessoa.getNacionalidade();
    	this.cpf = pessoa.getCpf();
    	this.dataCadastro = pessoa.getDataCadastro();
        this.dataAtualizado = pessoa.getDataAtualizado();
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

	

    
}
