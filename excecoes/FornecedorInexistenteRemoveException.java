package Excessoes;

public class FornecedorInexistenteRemoveException extends Exception {
	public FornecedorInexistenteRemoveException() {
		super("Fornecedor n�o foi encontrado ou n�o est� cadastrado! A��o abortada!");

	}

}
