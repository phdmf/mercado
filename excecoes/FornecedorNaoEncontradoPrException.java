package Excessoes;

public class FornecedorNaoEncontradoPrException extends Exception {
	public FornecedorNaoEncontradoPrException() {
		super("Fornecedor n�o foi encontrado ou n�o est� cadastrado!");

	}
}
