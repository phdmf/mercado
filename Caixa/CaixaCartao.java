package teste2;


public  class CaixaCartao extends CaixaAbstrata {
	private static final double desconto = 0.1;
	public CaixaCartao (String numeroCaixa, String disponibilidade, String tipo) {
	super (numeroCaixa, disponibilidade, tipo);
	}
	
	public void desconto (double valor) {
		double valorDesconto = valor * desconto;
		double valorPagar = valor - valorDesconto;
		super.setSituacao (this.getSituacao() - valorPagar);
	}

	
	public void troco(double valor) {
		this.setSituacao(this.getSituacao() - valor);
		
	}
}