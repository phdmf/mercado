package estacionamento;

public class RepositorioEstacionamentoLista implements RepositorioEstacionamento {

	private Estacionamento estacionamento;
	private RepositorioEstacionamentoLista next;

	public RepositorioEstacionamentoLista() {
		this.estacionamento = null;
		this.next = null;
	}

	public void inserir(Estacionamento estacionamento) {
		if (this.estacionamento == null) {
			this.estacionamento = estacionamento;
			this.next = new RepositorioEstacionamentoLista();
		} else {
			this.next.inserir(estacionamento);
		}
	}

	public void atualizar(Estacionamento estacionamento) throws VagaSolicitadaNaoExisteException {
		if (this.estacionamento != null) {
			if (estacionamento.equals(this.estacionamento)) {
				this.estacionamento = estacionamento;
			} else {
				this.next.atualizar(estacionamento);
			}
		} else {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public void remover(String local) throws VagaSolicitadaNaoExisteException {
		if (this.estacionamento != null) {
			if (local.equals(estacionamento.getNumeroVagas())) {
				this.estacionamento = this.next.estacionamento;
				this.next = this.next.next;
			} else {
				this.next.remover(local);
			}
		} else {
			throw new VagaSolicitadaNaoExisteException();
		}

	}

	public Estacionamento procurar(String numeroVagas) throws VagaSolicitadaNaoExisteException {
		Estacionamento estacionamento = null;
		if (this.estacionamento != null) {
			if (this.estacionamento.getNumeroVagas().equals(numeroVagas)) {
				estacionamento = this.estacionamento;
			} else {
				this.next.procurar(numeroVagas);
			}
		}
		if (estacionamento == null) {
			throw new VagaSolicitadaNaoExisteException();
		}
		return estacionamento;
	}

	public boolean existir(String local) {
		boolean n = true;
		if (local.equals(estacionamento.getNumeroVagas())) {
			n = true;
		} else if (!(local.equals(estacionamento.getNumeroVagas()))) {
			this.next.existir(local);
		} else {
			n = false;
		}
		return n;

	}

}
