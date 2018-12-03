package teste2;


public class CaixaDinheiro extends CaixaAbstrata {
	public CaixaDinheiro (String numeroCaixa, String disponibilidade, String tipo) {
		super (numeroCaixa, disponibilidade, tipo);
	}
	
	
	public void troco (double valor) {
		this.setSituacao(this.getSituacao() - valor);
	}
	
}
