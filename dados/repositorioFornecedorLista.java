package Fornecedores;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNomeJaCadastradoException;

public class repositorioFornecedorLista {

	class Lista {
		private fornecedor fornecedores;
		private Lista proximo;

		Lista() {
			this.fornecedores = null;
			this.proximo = null;
		}

		// negocios cadastro (checa se tem ou não antes de ir pros metodos)

		public void inserir(fornecedor forn) throws FornecedorNomeJaCadastradoException { // todo q for criado vai ter
																							// forn. e novo fornecedor
			if (this.fornecedores.equals(null)) {
				this.fornecedores = forn;
				this.proximo = new Lista();
			} else {
				this.proximo.inserir(forn);
			}
		}

		public fornecedor procurar(fornecedor forn) throws FornecedorNaoEncontradoException {
			if (this.fornecedores.equals(forn)) { // pode aqui esse exception?
				return forn;
			} else {
				return this.proximo.procurar(forn);
			}
		}

		public boolean existir(fornecedor cnpj) {
			if (this.fornecedores.equals(cnpj)) {
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
			if (this.fornecedores.getCnpj().equals(novo.getCnpj())) {
				this.fornecedores = novo;
			} else {
				this.proximo.atualizar(novo);
			}
		}

		public void remover(fornecedor forn) throws FornecedorDadosIncompletosException {
			if (this.fornecedores.equals(forn)) {
				this.fornecedores = this.proximo.fornecedores;
				this.proximo = this.proximo.proximo; // nessa linha ele gera um
														// loop ate chegar no null?
			} else {
				this.proximo.remover(forn);
			}
		}

	}

}
