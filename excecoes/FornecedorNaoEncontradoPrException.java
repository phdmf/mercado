package Excessoes;

public class FornecedorNaoEncontradoPrException extends Exception {
	public FornecedorNaoEncontradoPrException() {
		super("Fornecedor não foi encontrado ou não está cadastrado!");

	}
}
