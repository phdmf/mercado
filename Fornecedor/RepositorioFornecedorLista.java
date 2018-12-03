package Fornecedor;

public class RepositorioFornecedorLista implements RepositorioFornecedores {

	private Fornecedor fornecedor;
	private RepositorioFornecedorLista proximo;

	public RepositorioFornecedorLista() {
		this.fornecedor = null;
		this.proximo = null;
	}

	public void inserir(Fornecedor forn)
			throws FornecedorNomeJaCadastradoException { // todo q for criado
															// vai ter
			if (this.fornecedor == null) {
				this.fornecedor = forn;
				this.proximo = new RepositorioFornecedorLista();
			} else {
				this.proximo.inserir(forn);
		}
	}

	public void atualizar(Fornecedor novo)
			throws FornecedorNaoEncontradoException {
		if (this.fornecedor != null && this.fornecedor.getCnpj().equals(novo.getCnpj())) {
			this.fornecedor = novo;
		} else if (this.proximo != null) {
			this.proximo.atualizar(novo);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

	// negocios cadastro (checa se tem ou não antes de ir pros metodos);
	//

	public Fornecedor procurar(String cnpj)  throws FornecedorNaoEncontradoException {
		if (this.fornecedor != null && this.fornecedor.getCnpj().equals(cnpj)) {
			return fornecedor;
		} else if (this.proximo != null) {
			return this.proximo.procurar(cnpj);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public boolean existir(Fornecedor forn) {
		if (this.fornecedor != null && this.fornecedor.getCnpj().equals(forn.getCnpj())) {
			// If (this....existir(funcionario.getCnpj()))
			return true;
		} else if (this.proximo != null) {
			return this.proximo.existir(forn);
		} else {
			return false;
		}
	}

	public void remover(Fornecedor forn)
			throws FornecedorNaoEncontradoException {
		if (this.fornecedor != null
				&& this.fornecedor.getCnpj().equals(forn.getCnpj())) {
			this.fornecedor = this.proximo.fornecedor;
			this.proximo = this.proximo.proximo; 

		} else if (this.proximo != null) {
			this.proximo.remover(forn);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

}
