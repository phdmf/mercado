package estacionamento;

public class VagaSolicitadaNoutroAndarException extends Exception {
	public VagaSolicitadaNoutroAndarException() {
		super("A vaga solicitada est� em outro andar.");
	}
}
