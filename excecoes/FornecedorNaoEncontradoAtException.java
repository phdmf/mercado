package Excessoes;

public class FornecedorNaoEncontradoAtException extends Exception {
	public FornecedorNaoEncontradoAtException() {
		super("Fornecedor não foi encontrado ou não está cadastrado!");

	}

}
