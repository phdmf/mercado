package Fornecedores;

import negocio.repositorioFornecedores;

public class repositorioFornecedoresArray implements repositorioFornecedores {

	private fornecedor[] fornecedores;
	private int indice;

	public repositorioFornecedoresArray(int tam) {
		fornecedores = new fornecedor[tam];
		indice = 0;
	}

	public void inserir(fornecedor f) {
		fornecedores[indice] = f;
		indice = indice + 1;
	}

	public void atualizar(fornecedor cnpj) {// throws ProdutoNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(fornecedores.equals(cnpj))) {
				fornecedores[i] = fornecedores[i];
				achou = true;
			}
		}
		if (!achou) {
			// throw new ProdutoNaoEncontradoException() ;
		}
	}

	public fornecedor procurar(String cnpj) { // throws PessoaNaoEncontradaException {
		fornecedor fornecedores = null;
		for (int i = 0; i < indice; i++) {
			if (this.fornecedores[i].getCnpj().equals(cnpj)) {
				this.fornecedores = fornecedor[i];
			}
		}
		if (this.fornecedores != null) {
			return fornecedores;
		} else {
			// throw new PessoaNaoEncontradaException();
		}
	}

	public void remover(String cnpj) { // throws ProdutoNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(cnpj)) {
				achou = true;
				fornecedores[i] = null;
				int j = i;
				for (i = j; i < indice; i++) {
					if (i != indice - 1) {
						fornecedores[i] = fornecedores[i + 1];
					} else {
						fornecedores[i] = null;
						indice--;
					}
				}
			}
		}
		if (!achou) {
			// throw new ProdutoNaoEncontradoException() ;
		}
	}

	public boolean existe(String cnpj) {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(cnpj)) {
				achou = true;
			}
		}
		return achou;
	}

}
