package teste2;

public class NumeroCaixaNaoEncontradaException extends Exception {
	
	public NumeroCaixaNaoEncontradaException() {
		super("Número do caixa não encontrado");
	}

}