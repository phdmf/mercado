package Mercadinho.repositorio;

import basicas.Pessoa;
import excecoes.PessoaNaoEncontradaException;
import negocio_dados.RepositorioPessoas;

public class RepositorioPessoasArray implements RepositorioPessoas {
	
	private Pessoa[] pessoas;
	private int indice;
	
	public RepositorioPessoasArray(int tam) {
		pessoas = new Pessoa[tam];
		indice = 0;
	}
	
	public void inserir(Pessoa pessoa) {
		pessoas[indice] = pessoa;
		indice = indice + 1;
	}
	
	//Método de *procurar* aplicando o "getIndice" diretamente :D 
	public Pessoa procurar (String cpf) throws PessoaNaoEncontradaException {
		Pessoa p = null;
		
		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				p = pessoas[i];
			}
		}
		if(p != null) {
			return p;
		}else {
			throw new PessoaNaoEncontradaException();
		}
	}
	// Método remover aplicando o "getIndice" diretamente :D
	public void remover(String cpf) throws PessoaNaoEncontradaException{
		boolean find = false;
		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				indice = indice - 1;
				pessoas[i] = pessoas[indice];
				pessoas[i] = null;
				find = true;
			}
		}
		if (!find) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException{
		boolean find = false;
		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(pessoa.getCpf())) {
				pessoas[i] = pessoa;
				find = true;
			}
		}
		if (!find) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public boolean existe (String cpf) {
		boolean find = false;
		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				find = true;
			}
		}
		return find;
	}
	
	//Exemplo do Projeto feito por Sérgio. Decidir se uso ou não no buscar, atualizar e remover 
	/*private int getIndice(String cpf) {
		String c;
		boolean find = false;
		int i = 0;
		while ((!find) && (i < this.indice)) {
			c = pessoas[i].getCpf();
			if(c.equals(cpf)) {
				find = true;
			}
			else {
				i = i + 1;
			}
		}
		return i;
	}*/
	
	/*
	 * Método de procurar com o getIndice
	 
	 public Pessoa procurar (String cpf) throws PNEException {
		Pessoa p = null;
		int i = this.getIndice(cpf);
		
		if (i == this.indice) {
			throw new PNEException();
		}else {
			p = this.pessoas[i];
		}
		return p;
	}
	*/
	
	/*
	 * Método remover com o getIndice 
	 
	 public void remover(String cpf) throws PNEException{
		int i = this.getIndice(cpf);
		if (i == this.indice) {
			throw new PNEException();
		}else {
			this.indice = this.indice - 1;
			this.pessoas[i] = this.pessoas[this.indice];
			this.pessoas[this.indice] = null;
		}
	}
	*/
	
	/*
	 * Método atualizar com o getIndice 
	 
	 public void atualizar(Pessoa pessoa) throws PNEException{
		int i = this.getIndice(pessoa.getCpf());
		if(i == this.indice) {
			throw new PNEException();
		}else {
			this.pessoas[i] = pessoa;
		}
	 */
	

}
