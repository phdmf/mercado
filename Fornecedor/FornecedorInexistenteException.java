package Fornecedor;

public class FornecedorInexistenteException extends Exception {
	public FornecedorInexistenteException() {
		super("Fornecedor n�o foi encontrado ou n�o est� cadastrado!");

	}

}
