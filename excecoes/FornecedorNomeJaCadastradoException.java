package Excessoes;

public class FornecedorNomeJaCadastradoException extends Exception {
	public FornecedorNomeJaCadastradoException() {
		super("Este usu�rio j� est� cadastrado!");

	}
}
