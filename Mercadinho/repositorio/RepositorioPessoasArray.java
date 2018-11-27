package Mercadinho.repositorio;

import Mercadinho.Sointerfaces.RepositorioPessoas;
import Mercadinho.basic.Pessoa;
import Mercadinho.exception.*;

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

	// MÃ©todo de *procurar* aplicando o "getIndice" diretamente :D
	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		Pessoa p = null;

		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				p = pessoas[i];
			}
		}
		if (p != null) {
			return p;
		} else {
			throw new PessoaNaoEncontradaException();
		}
	}

	// MÃ©todo remover aplicando o "getIndice" diretamente :D
	public void remover(String cpf) throws PessoaNaoEncontradaException {
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

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
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

	public boolean existir(String cpf) {
		boolean find = false;
		for (int i = 0; i < indice; i++) {
			if (pessoas[i].getCpf().equals(cpf)) {
				find = true;
			}
		}
		return find;
	}

	// Exemplo do Projeto feito por SÃ©rgio. Decidir se uso ou nÃ£o no buscar,
	// atualizar e remover
	/*
	 * private int getIndice(String cpf) { String c; boolean find = false; int i =
	 * 0; while ((!find) && (i < this.indice)) { c = pessoas[i].getCpf();
	 * if(c.equals(cpf)) { find = true; } else { i = i + 1; } } return i; }
	 */

	/*
	 * MÃ©todo de procurar com o getIndice
	 * 
	 * public Pessoa procurar (String cpf) throws PNEException { Pessoa p = null;
	 * int i = this.getIndice(cpf);
	 * 
	 * if (i == this.indice) { throw new PNEException(); }else { p =
	 * this.pessoas[i]; } return p; }
	 */

	/*
	 * MÃ©todo remover com o getIndice
	 * 
	 * public void remover(String cpf) throws PNEException{ int i =
	 * this.getIndice(cpf); if (i == this.indice) { throw new PNEException(); }else
	 * { this.indice = this.indice - 1; this.pessoas[i] = this.pessoas[this.indice];
	 * this.pessoas[this.indice] = null; } }
	 */

	/*
	 * MÃ©todo atualizar com o getIndice
	 * 
	 * public void atualizar(Pessoa pessoa) throws PNEException{ int i =
	 * this.getIndice(pessoa.getCpf()); if(i == this.indice) { throw new
	 * PNEException(); }else { this.pessoas[i] = pessoa; }
	 */

}
