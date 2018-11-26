package Fornecedores;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorInexistenteConsultaException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNomeJaCadastradoException;
import negocio.repositorioFornecedores;

public class repositorioFornecedoresArray implements repositorioFornecedores {

	private fornecedor[] fornecedores;
	private int indice;

	public repositorioFornecedoresArray(int tam) {
		fornecedores = new fornecedor[tam];
		indice = 0;
	}

	public void inserir(fornecedor forn) throws FornecedorNomeJaCadastradoException { // ta apresentando erro
		if (!fornecedores.equals(null)) {
		fornecedores[indice] = forn;
		indice = indice + 1;
	} else {
		new FornecedorNomeJaCadastradoException();
	}
	}

	public void atualizar(fornecedor forn) throws FornecedorNaoEncontradoException  {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.equals(forn))) {
				fornecedores[i] = fornecedores[i];
				achou = true;
			}
		}
		if (!achou) {
			new FornecedorNaoEncontradoException(); 
		}
	}

	public fornecedor procurar(fornecedor forn) throws FornecedorNaoEncontradoException {
		fornecedor fornecedores = null;
		for (int i = 0; i < indice; i++) {
			if (this.fornecedores[i].getCnpj().equals(forn)) {
				return fornecedores;
			}
	} return null;
	}

	public void remover (fornecedor forn) throws FornecedorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn)) {
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

	public boolean existir(fornecedor forn) throws FornecedorInexistenteConsultaException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn)) {
				achou = true;
			}
		}
		return achou;
	}
	
	private int getIndice(fornecedor forn) {
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.indice)) {
			n = fornecedores[i].getCnpj();
			if (n.equals(forn)) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
}

	
