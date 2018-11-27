package teste2;

public class SaldoInsuficienteException extends Exception {
	private int situacao;
	private String numeroCaixa;
	public SaldoInsuficienteException (int situacao, String numeroCaixa) {
		super ("Valor insuficiente para o troco!");
		this.situacao = situacao;
		this.numeroCaixa = numeroCaixa;
	}
	public double getSituacao() {
		return situacao;
	}
}