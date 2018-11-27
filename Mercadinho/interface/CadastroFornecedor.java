package Mercadinho.Sointerfaces;

import Mercadinho.basic.Fornecedor;
import Mercadinho.exception.FornecedorNaoEncontradoException;
import Mercadinho.exception.FornecedorNomeJaCadastradoException;
import Mercadinho.repositorio.RepositorioFornecedorLista;
import Mercadinho.repositorio.RepositorioFornecedoresArray;

public class CadastroFornecedor {
	private RepositorioFornecedores fornecedor;

	public CadastroFornecedor(char t) {
		if (t == 'a' || t == 'A') {
			this.fornecedor = new RepositorioFornecedoresArray();
		} else {
			this.fornecedor = new RepositorioFornecedorLista();
		}
	}

	public void cadastrar(Fornecedor forn) throws FornecedorNomeJaCadastradoException {
		if (!fornecedor.existir(forn.getCnpj())) {
			fornecedor.inserir(forn);
		} else {
			throw new FornecedorNomeJaCadastradoException();
		}
	}

	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
		return fornecedor.procurar(cnpj);
	}

	public void atualizar(Fornecedor forn) throws FornecedorNaoEncontradoException {
		fornecedor.remover(forn);
	}

}
