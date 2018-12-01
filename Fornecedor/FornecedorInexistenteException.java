package Fornecedor;

public class FornecedorInexistenteException extends Exception {
	public FornecedorInexistenteException() {
		super("Fornecedor não foi encontrado ou não está cadastrado!");

	}

}
