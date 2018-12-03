package Fornecedor;

import Fornecedor.RepositorioFornecedores;

public class NegocioFornecedor {

	private RepositorioFornecedores repForn;

	// Metodo que inicia os atributos da classe negocio de fornecedor

	public NegocioFornecedor(RepositorioFornecedores repForn) {
		this.repForn = repForn;
	}

	// Metodo que cadastra pessoas no repositório de pessoas

	public void cadastrar(Fornecedor fornecedor) throws FornecedorNomeJaCadastradoException {
		try {

			this.repForn.procurar(fornecedor.getCnpj());
			throw new FornecedorNomeJaCadastradoException();
		} catch (FornecedorNaoEncontradoException e) {
			this.repForn.inserir(fornecedor);
		}
	}

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {

		if (this.repForn.procurar(fornecedor.getCnpj()) != null) {
			this.repForn.atualizar(fornecedor);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {

		Fornecedor fornecedor = this.repForn.procurar(cnpj);
		if (fornecedor == null) {
			throw new FornecedorNaoEncontradoException();
		} else {
			return fornecedor;
		}
	}

	public void remover(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {

		if (this.repForn.existir(fornecedor)) {
			// if (repForn.equals(fornecedor.getCnpj()))
			this.repForn.remover(fornecedor);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

}
