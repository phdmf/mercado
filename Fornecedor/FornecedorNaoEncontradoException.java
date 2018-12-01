package Fornecedor;

public class FornecedorNaoEncontradoException extends Exception {
	public FornecedorNaoEncontradoException() {
		super("Fornecedor não foi encontrado ou não está cadastrado!");

	}
}
