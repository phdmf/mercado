package Fornecedor;

public class RepositorioFornecedoresArray implements RepositorioFornecedores {

	private Fornecedor[] fornecedores;
	private int indice;

	public RepositorioFornecedoresArray(int tam) {
		fornecedores = new Fornecedor[tam];
		indice = 0;
	}

	public void inserir(Fornecedor forn) throws FornecedorNomeJaCadastradoException { // ta apresentando erro
		if (!existir(forn)) {
			fornecedores[indice] = forn;
			indice = indice + 1;
		} else {
			throw new FornecedorNomeJaCadastradoException();
		}
	}

	public void atualizar(Fornecedor forn) throws FornecedorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
				fornecedores[i] = forn;
				achou = true;
			}
		}
		if (!achou) {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException { // assinatura do metodo
		for (int i = 0; i < indice; i++) {
			if (this.fornecedores[i].getCnpj().equals(cnpj)) {
				return this.fornecedores[i];
			}
		}
		throw new FornecedorNaoEncontradoException(); // n entendi
	}

	public void remover(Fornecedor forn) throws FornecedorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
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
			throw new FornecedorNaoEncontradoException();
		}
	}

	public boolean existir(Fornecedor forn) {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
				achou = true;
			}
		}
		return achou;
	}

	private int getIndice(Fornecedor forn) { // ta ok essa logica. OK
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.indice)) {
			n = fornecedores[i].getCnpj();
			if (n.equals(forn.getCnpj())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
}
