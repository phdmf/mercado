package estacionamento;

public class VagaSolicitadaNaoExisteException extends Exception {
	public VagaSolicitadaNaoExisteException() {
		super("A vaga solicitada n�o existe.");
	}
}
