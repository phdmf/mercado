package Excessoes;

public class FornecedorInexistenteRemoveException extends Exception {
	public FornecedorInexistenteRemoveException() {
		super("Fornecedor não foi encontrado ou não está cadastrado! Ação abortada!");

	}

}
