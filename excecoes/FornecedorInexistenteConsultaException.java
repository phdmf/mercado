package Excessoes;

public class FornecedorInexistenteConsultaException extends Exception {
	public FornecedorInexistenteConsultaException() {
		super("Fornecedor n�o foi encontrado ou n�o est� cadastrado!");

	}

}
