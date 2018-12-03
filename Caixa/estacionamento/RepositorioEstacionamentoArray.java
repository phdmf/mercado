package estacionamento;

public abstract class RepositorioEstacionamentoArray implements RepositorioEstacionamento {
	private Estacionamento[] estacionamento;
	private int indice;

	public RepositorioEstacionamentoArray() {
		estacionamento = new Estacionamento[50];
		indice = 0;
	}

	public void inserir(Estacionamento numeroVagas) {
		if (indice < 100) {
			this.estacionamento[indice] = numeroVagas;
			indice++;
		} else {

		}
	}

	public Estacionamento procurar(String numeroVagas) throws VagaSolicitadaNaoExisteException {
		Estacionamento est = null;

		for (int i = 0; i < indice; i++) {
			if (estacionamento[i].getNumeroVagas().equals(numeroVagas)) {
				est = estacionamento[i];
			}
		}
		if (estacionamento != null) {
			return est;
		} else {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public void atualizar(Estacionamento numeroVagas) throws VagaSolicitadaNaoExisteException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (estacionamento[i].getNumeroVagas().equals(numeroVagas.getNumeroVagas())) {
				estacionamento[i] = numeroVagas;
				achou = true;
			}
		}
		if (!achou) {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public void remover(Estacionamento numeroVagas) throws VagaSolicitadaNaoExisteException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (estacionamento[i].getNumeroVagas().equals(numeroVagas.getNumeroVagas())) {
				indice--;
				estacionamento[i] = estacionamento[indice];
				estacionamento[indice] = null;
				achou = true;
			}
		}
		if (!achou) {
			throw new VagaSolicitadaNaoExisteException();
		}
	}

	public boolean existe(Estacionamento numeroVagas) {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (estacionamento[i].getNumeroVagas().equals(numeroVagas.getNumeroVagas())) {
				achou = true;
			}
		}
		return achou;
	}

}
