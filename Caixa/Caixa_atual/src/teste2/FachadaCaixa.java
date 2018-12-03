package teste2;

public class FachadaCaixa {
	
	private CadastroCaixa negocioCaixa;
	
	
	
	public FachadaCaixa(RepositorioCaixa repCaixa) {
				
		this.negocioCaixa = new CadastroCaixa(repCaixa);
	}

	public void cadastroCaixa(CaixaAbstrata caixa) throws CaixaJaCadastradoException {
		this.negocioCaixa.cadastrar(caixa);
	}
	
	public void removerCaixa(CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException{
		 this.negocioCaixa.remover(caixa);
	}
		
	public CaixaAbstrata procurarCaixa(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		return  this.negocioCaixa.procurar(numeroCaixa);
	}
	
	public void atualizarCaixa(CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException {
		 this.negocioCaixa.atualizar(caixa);
	}

		
	}

	
		
	
	

	
	
		
	
	
