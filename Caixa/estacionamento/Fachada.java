package estacionamento;

public class Fachada {

	private CadastroEstacionamento cadastroEstac;

	public Fachada(RepositorioEstacionamento repositorioEstac) {
		this.cadastroEstac = new CadastroEstacionamento(repositorioEstac);

	}

	public void cadastrarEstac(Estacionamento estacionamento) throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {
		this.cadastroEstac.cadastrar(estacionamento);

	}

	public void remover(String numeroVagas) throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {
		this.cadastroEstac.remover(numeroVagas);
	}

	public void procurar(String numeroVagas) throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {
		this.cadastroEstac.procurar(numeroVagas);
	}

	public void atualizar(Estacionamento estacionamento) throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException {
		this.cadastroEstac.atualizar(estacionamento);
	}

}
