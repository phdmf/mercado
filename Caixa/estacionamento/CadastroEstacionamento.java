package estacionamento;

public class CadastroEstacionamento {

	private RepositorioEstacionamento repositorioEstacionamento;

	// MÉTODOS
	public CadastroEstacionamento(RepositorioEstacionamento repositorioEstacionamento) {
		this.repositorioEstacionamento = repositorioEstacionamento;
	}

	public void cadastrar(Estacionamento estacionamento) throws VagaSolicitadaNaoExisteException,
			VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {

		if (this.repositorioEstacionamento.procurar(estacionamento.getNumeroVagas()) == null) {
			this.repositorioEstacionamento.inserir(estacionamento);
		} else {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public void atualizar(Estacionamento estacionamento) throws VagaSolicitadaNaoExisteException,
			VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {

		if (this.repositorioEstacionamento.procurar(estacionamento.getNumeroVagas()) != null) {
			this.repositorioEstacionamento.atualizar(estacionamento);
		} else {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public void remover(String numeroVagas) throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException,
			VagaSolicitadaOcupadaException {

		if (this.repositorioEstacionamento.procurar(numeroVagas) != null) {
			this.repositorioEstacionamento.remover(numeroVagas);
		} else {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public Estacionamento procurar(String numeroVagas) throws VagaSolicitadaNaoExisteException,
			VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {

		Estacionamento estacionamento = this.repositorioEstacionamento.procurar(numeroVagas);
		if (estacionamento == null) {
			throw new VagaSolicitadaNaoExisteException();
		} else {
			return estacionamento;
		}
	}
}