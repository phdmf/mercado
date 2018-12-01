package Fornecedor;

public class RepositorioFornecedorLista implements RepositorioFornecedores {

		private Fornecedor fornecedor;
		private RepositorioFornecedorLista proximo;

		public RepositorioFornecedorLista() {
			this.fornecedor = null;
			this.proximo = null;
		}
	

		// negocios cadastro (checa se tem ou não antes de ir pros metodos);
		//

		public void inserir(Fornecedor forn) throws FornecedorNomeJaCadastradoException { // todo q for criado vai ter
			if (!existir(forn)) { // forn. e novo fornecedor
				if (this.fornecedor.equals(null)) {
					this.fornecedor = forn;
					this.proximo = new RepositorioFornecedorLista();
				} else {
					this.proximo.inserir(forn);
				}
			} else {
				throw new FornecedorNomeJaCadastradoException();
			}
		}

		public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException {
			if (this.fornecedor.getCnpj().equals(cnpj)) {
				return fornecedor;
			} else if (this.proximo != null) {
				return this.proximo.procurar(cnpj);
			} else {
				throw new FornecedorNaoEncontradoException();
			}
		}

		public boolean existir(Fornecedor cnpj) {
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

		public void atualizar(Fornecedor novo) throws FornecedorNaoEncontradoException {
			if (this.fornecedor.getCnpj().equals(novo.getCnpj())) {
				this.fornecedor = novo;
			} else if (this.proximo != null) {
				this.proximo.atualizar(novo);
			} else {
				throw new FornecedorNaoEncontradoException();
			}
		}

		public void remover(Fornecedor forn) throws FornecedorNaoEncontradoException {
			if (this.fornecedor.getCnpj().equals(forn.getCnpj())) {
				this.fornecedor = this.proximo.fornecedor;
				this.proximo = this.proximo.proximo; // nessa linha ele gera um loop ate chegar no null?

			} else if (this.proximo != null) {
				this.proximo.remover(forn);
			} else {
				throw new FornecedorNaoEncontradoException();
			}
		}
	

	
	
	/*
	public String alarmeInicio(Cantina cantina) {
	String aviso = cantina.getNome() + " acabou de abrir! :)";
	return aviso;
}

public String alarmeFim(Cantina cantina) {
	String aviso = cantina.getNome() + " acabou de fechar! :(";
	return aviso;
}

}

*/

}
