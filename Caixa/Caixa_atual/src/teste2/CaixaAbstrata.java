package teste2;


public abstract class CaixaAbstrata {
	private String tipo; //se o caixa � preferencial ou n�o
	private String disponibilidade;
	private double situacao; // valor q o caixa inicia 
	private String numeroCaixa;
	private Pessoa pessoa;
	private Produto preco;
	public CaixaAbstrata (String tipo, String disponibilidade, String numeroCaixa) {
	
		this.tipo = tipo;
		this.disponibilidade = disponibilidade;
		this.situacao = 200.0;
		this.numeroCaixa = numeroCaixa;
	}

	public void receberDinheiro (double valor) {
		situacao = situacao + valor;
	}

	public double getSituacao() {
		return this.situacao;
	}

	

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	public String getNumeroCaixa() {
		return numeroCaixa;
	}
	public void setNumeroCaixa(String numeroCaixa) {
		this.numeroCaixa = numeroCaixa;
	}
	
	public String getNome() {
		return this.pessoa.getNome() ;
	}

	

	protected void setSituacao (double situacao) { 
		this.situacao = situacao;
	}

	
	public void troco (double valor) {
		
	}
}