package estacionamento;

public class VagaSolicitadaNoutroAndarException extends Exception {
	public VagaSolicitadaNoutroAndarException() {
		super("A vaga solicitada está em outro andar.");
	}
}
