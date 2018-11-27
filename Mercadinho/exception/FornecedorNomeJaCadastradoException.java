package Mercadinho.exception;

public class FornecedorNomeJaCadastradoException extends Exception {
	public FornecedorNomeJaCadastradoException() {
		super("Este usuário já está cadastrado!");

	}
}
