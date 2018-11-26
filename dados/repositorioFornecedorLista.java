package Fornecedores;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNomeJaCadastradoException;

public class repositorioFornecedorLista {

	class Lista {
		private fornecedor fornecedor;
		private Lista proximo;

		Lista() {
			this.fornecedor = null;
			this.proximo = null;
		}

		// negocios cadastro (checa se tem ou não antes de ir pros metodos);
		//

		public void inserir(fornecedor forn) throws FornecedorNomeJaCadastradoException { // todo q for criado vai ter
			if (!existir(forn)) { // forn. e novo fornecedor
				if (this.fornecedor.equals(null)) {
					this.fornecedor = forn;
					this.proximo = new Lista();
				} else {
					this.proximo.inserir(forn);
				}
			} else {
				throw new FornecedorNomeJaCadastradoException();
			}
		}

		public fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException { 
			if (this.fornecedor.getCnpj().equals(cnpj)) {
				return fornecedor;
			} else if (this.proximo != null) {
				return this.proximo.procurar(cnpj);
			} else {
				throw new FornecedorNaoEncontradoException();
			}
		}

		public boolean existir(fornecedor cnpj) {
			if (this.fornecedor.getCnpj().equals(cnpj)) {
				return true;
			} else if (this.proximo != null) {
				return this.proximo.existir(cnpj);
			} else {
				return false;
			}
		}

		// nesse atualizar tem que criar um metodo no main para mudar x para y, por
		// exemplo

		public void atualizar(fornecedor novo) throws FornecedorNaoEncontradoException {
			if (this.fornecedor.getCnpj().equals(novo.getCnpj())) {
				this.fornecedor = novo;
			} else if (this.proximo != null) {
				this.proximo.atualizar(novo);
			} else {
				throw new FornecedorNaoEncontradoException();
			}
		}

		
		public void remover(fornecedor forn) throws FornecedorNaoEncontradoException {
			if (this.fornecedor.getCnpj().equals(forn.getCnpj())) {
				this.fornecedor = this.proximo.fornecedor;
				this.proximo = this.proximo.proximo; // nessa linha ele gera um loop ate chegar no null?

			} else if (this.proximo != null) {
				this.proximo.remover(forn);
			} else {
				throw new FornecedorNaoEncontradoException();
			}
		}

	}

}
