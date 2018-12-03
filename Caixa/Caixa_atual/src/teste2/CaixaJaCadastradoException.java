package teste2;

public class CaixaJaCadastradoException extends Exception {
	public CaixaJaCadastradoException() {
		super("Caixa já cadastrado");
	}
}