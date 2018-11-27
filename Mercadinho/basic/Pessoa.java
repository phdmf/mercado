package Mercadinho.basic;

import negocio_dados.RepositorioPessoas;

public class Pessoa {

	private String cpf;
	private String nome;
	private String nascimento;
	private String endereco;
	private int telefone;

	public Pessoa(String cpf, String nome, String nascimento, String endereco, int telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

}
