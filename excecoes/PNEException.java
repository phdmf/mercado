package excecoes;

public class PNEException extends Exception{
	
	public PNEException() {
		super ("Não existe pessoa que corresponde ao CPF informado.");
	}

}
