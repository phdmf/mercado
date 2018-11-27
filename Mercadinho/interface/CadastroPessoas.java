package Mercadinho.Sointerfaces;

import Mercadinho.basic.*;
import Mercadinho.exception.*;

public class CadastroPessoas {

	private RepositorioPessoas pessoas;

	public void inserir(Pessoa pessoa) throws PessoaJaCadastradaException {
		if (!pessoas.existir(pessoa.getCpf())) {
			pessoas.inserir(pessoa);
		} else {
			throw new PessoaJaCadastradaException();
		}
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException {
		pessoas.atualizar(pessoa);
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException {
		pessoas.remover(cpf);
	}

	public Pessoa procurar(String cpf) throws PessoaNaoEncontradaException {
		return pessoas.procurar(cpf);
	}

}
