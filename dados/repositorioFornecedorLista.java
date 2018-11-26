package Fornecedores;

import Excessoes.FornecedorNaoEncontradoAtException;

public class repositorioFornecedorLista {
	
	
	class Lista {
		private String cnpj;
		private Lista proximo;

		Lista() {
			this.cnpj = null;
			this.proximo = null;
		}

		public void inserir(String cnpj) {
			if (this.cnpj.equals(null)) {
				this.cnpj = cnpj;
				this.proximo = new Lista();
			} else {
				this.proximo.inserir(cnpj);
			}
		}

		public boolean procurar(int cnpj) {
			if (this.cnpj.equals(cnpj)) {
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
					throw new FornecedorNaoEncontradoAtException();
				}
			}		
		}



		
		public void remover(String cnpj) {

			if (this.cnpj != null) {
				if (this.cnpj.equals(cnpj)) {
					this.cnpj = this.proximo.cnpj;
					this.proximo = this.proximo.proximo; // nessa linha ele gera um
															// loop ate chegar no null?
				} else {
					this.proximo.remover(cnpj);
				}
			} else {
				throw new RuntimeException(); // falta inserir os erros
			}
		}

	}

}
