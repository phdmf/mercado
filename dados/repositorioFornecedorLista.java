package Fornecedores;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorNaoEncontradoAtException;
import Excessoes.FornecedorNaoEncontradoPrException;
import Excessoes.FornecedorNomeJaCadastradoException;

public class repositorioFornecedorLista {
	
	
	class Lista {
		private String cnpj;
		private Lista proximo;

		Lista() {
			this.cnpj = null;
			this.proximo = null;
		}

		public void inserir(String cnpj) throws FornecedorNomeJaCadastradoException {
			if (this.cnpj.equals(null)) {
				this.cnpj = cnpj;
				this.proximo = new Lista();
			} else if (this.cnpj.equals(cnpj)) { // essa parte esta correta? 
				new FornecedorNomeJaCadastradoException();
			} else {
				this.proximo.inserir(cnpj);
			}
		}

		public boolean procurar(int cnpj) throws FornecedorNaoEncontradoPrException {
			if (this.cnpj.equals(cnpj)) { // pode aqui esse exception? 
				return true;
			} else if (this.proximo != null) {
				return this.proximo.procurar(cnpj);
			} else {
				return false;
			}
		}


		public void atualizar(fornecedor novo) throws FornecedorNaoEncontradoAtException  {
			if (this.cnpj != null) {
				if (this.cnpj.equals(novo.getCnpj())) { // ta dando erro aqui nao sei porque
					this.cnpj = novo; // ta dando erro aqui nao sei porque
				} else if {
					this.proximo.atualizar(novo);
				} else {
					new FornecedorNaoEncontradoAtException();
				}
			}		
		}

		
		public void remover(String cnpj) throws FornecedorDadosIncompletosException {

			if (this.cnpj != null) {
				if (this.cnpj.equals(cnpj)) {
					this.cnpj = this.proximo.cnpj;
					this.proximo = this.proximo.proximo; // nessa linha ele gera um
															// loop ate chegar no null?
				} else {
					this.proximo.remover(cnpj);
				}
			} else {
				new FornecedorDadosIncompletosException(); 
			}
		}

	}

}
