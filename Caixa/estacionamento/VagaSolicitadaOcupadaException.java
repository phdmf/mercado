package estacionamento;

public class VagaSolicitadaOcupadaException extends Exception {
	public VagaSolicitadaOcupadaException() {
		super("A vaga solicitada está ocupada.");
	}
}
