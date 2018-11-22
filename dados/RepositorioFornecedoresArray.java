package Fornecedores;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorInexistenteConsultaException;
import Excessoes.FornecedorNaoEncontradoAtException;
import Excessoes.FornecedorNaoEncontradoPrException;
import Excessoes.FornecedorNomeJaCadastradoException;
import negocio.repositorioFornecedores;

public class repositorioFornecedoresArray implements repositorioFornecedores {

	private fornecedor[] fornecedores;
	private int indice;

	public repositorioFornecedoresArray(int tam) {
		fornecedores = new fornecedor[tam];
		indice = 0;
	}

	public void inserir(fornecedor f) throws FornecedorNomeJaCadastradoException { // ta apresentando erro
		if (!fornecedor.this.getCnpj().equals(f)) { // ta apresentando erro
		fornecedores[indice] = f;
		indice = indice + 1;
	} else {
		new FornecedorNomeJaCadastradoException();
	}
	}

	public void atualizar(fornecedor cnpj) throws FornecedorNaoEncontradoAtException  {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(fornecedores.equals(cnpj))) {
				fornecedores[i] = fornecedores[i];
				achou = true;
			}
		}
		if (!achou) {
			new FornecedorNaoEncontradoAtException(); 
		}
	}

	public fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoPrException {
		fornecedor fornecedores = null;
		for (int i = 0; i < indice; i++) {
			if (this.fornecedores[i].getCnpj().equals(cnpj)) {
				this.fornecedores = this.fornecedores; 
				//return fornecedores;
			} else {
				new FornecedorNaoEncontradoPrException();
		}
	}
		return fornecedores;
	}

	public void remover (String cnpj) throws FornecedorDadosIncompletosException {
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
			new FornecedorDadosIncompletosException() ;
		}
	}

	public boolean existe(String cnpj) throws FornecedorInexistenteConsultaException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(cnpj)) {
				achou = true;
			}
		}
		return achou;
	}

}
