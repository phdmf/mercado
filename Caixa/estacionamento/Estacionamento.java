package estacionamento;

public class Estacionamento {
	private String numeroVagas; // Numero de vagas do estacionamento. Retorna uma String.
	private String disponibilidade; // Disponibilidade da vaga. Retorna uma String dizendo se a vaga solicitada está
									// ou não disponível.
	private String tipoVaga; // Tipo da vaga. Retorna uma String dizendo qual o tipo da vaga, se é normal ou
								// preferencial.
	private String numeroAndares; // Numero de andares do estacionamento.
	// private Funcionario funcionario;
	// private Cliente cliente;

	public Estacionamento(String numeroVagas, String disponibilidade, String tipoVaga, String numeroAndares) {
		this.numeroVagas = numeroVagas;
		this.disponibilidade = disponibilidade;
		this.tipoVaga = tipoVaga;
		this.numeroAndares=numeroAndares;
	}

	public void setNumeroVagas(String numerovagas) {
		this.numeroVagas = numerovagas;

	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public void setTipoVaga(String tipovaga) {
		this.tipoVaga = tipovaga;

	}

	public void setNumeroAndares(String numeroAndares) {
		this.numeroAndares = numeroAndares;
	}

	public String getNumeroVagas() {
		return this.numeroVagas;

	}

	public String getDisponibilidade() {
		return this.disponibilidade;

	}

	public String getTipoVaga() {
		return this.tipoVaga;
	}

	public String getNumeroAndares() {
		return numeroAndares;
	}

}
