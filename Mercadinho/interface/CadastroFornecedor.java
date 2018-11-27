package Mercadinho.negocioInterface;

import Excessoes.FornecedorNomeJaCadastradoException;
import Fornecedores.repositorioFornecedoresArray;

public class CadastroFornecedor {
	private repositorioFornecedores fornecedor;

	public inserir(String forn) {
		if (t == 'a' || t == 'A') {
			this.fornecedor = new repositorioFornecedoresArray();
		} else {
			this.fornecedor = new repositorioFornecedoresLista();
		}
	}

	public void cadastrar(fornecedor forn) throws FornecedorNomeJaCadastradoException {
		if (!(fornecedor.existe(forn.getCnpj()))) {
			fornecedor.inserir(forn);
		} else {
			throw new FornecedorNomeJaCadastradoException();
		}
	}

	public fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
		return fornecedor.procurar(cnpj);
	}

	public void atualizar(fornecedor forn) throws FornecedorNaoEncontradoException {
		fornecedor.remover(forn);
	}

}
