package Mercadinho.exception;

public class FornecedorInexistenteConsultaException extends Exception {
	public FornecedorInexistenteConsultaException() {
		super("Fornecedor não foi encontrado ou não está cadastrado!");

	}

}
