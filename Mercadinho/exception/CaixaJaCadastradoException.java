package Mercadinho.exception;

public class CaixaJaCadastradoException extends Exception {
	public CaixaJaCadastradoException() {
		super("Caixa já cadastrado");
	}
}