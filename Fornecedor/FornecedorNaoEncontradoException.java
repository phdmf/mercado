package Fornecedor;

public class FornecedorNaoEncontradoException extends Exception {
	public FornecedorNaoEncontradoException() {
		super("Fornecedor n�o foi encontrado ou n�o est� cadastrado!");

	}
}
