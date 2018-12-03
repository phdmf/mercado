package estacionamento;

public interface RepositorioEstacionamento {

	public void inserir(Estacionamento numeroVagas);

	public void atualizar(Estacionamento numeroVagas)
			throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException;

	public void remover(String local)
			throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException;

	public Estacionamento procurar(String local)
			throws VagaSolicitadaNaoExisteException, VagaSolicitadaNoutroAndarException, VagaSolicitadaOcupadaException;

	boolean existir(String local);
	
}
