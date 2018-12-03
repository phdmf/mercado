package teste2;


public  class CaixaCartao extends CaixaAbstrata {
	private static final double DESCONTO = 0.1;
	public CaixaCartao (String numeroCaixa, String disponibilidade, String tipo) {
	super (numeroCaixa, disponibilidade, tipo);
	}
	
	
	
	public void troco (double valor) {
		double valorDesconto = valor * DESCONTO;
		double valorPago = valor - valorDesconto;
		super.setSituacao (this.getSituacao() - valorPago);
		
	}
}