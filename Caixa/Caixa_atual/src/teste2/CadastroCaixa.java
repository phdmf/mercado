package teste2;

public class CadastroCaixa {

	private RepositorioCaixa repCaixa; 	

	public CadastroCaixa(RepositorioCaixa repCaixa) {
		super();
		
		this.repCaixa = repCaixa;
	}

	public void cadastrar(CaixaAbstrata caixa) throws CaixaJaCadastradoException {
		if (!(this.repCaixa.existir(caixa.getNumeroCaixa()))) {
			this.repCaixa.inserir(caixa);
		} else {
			throw new CaixaJaCadastradoException();
		}
	}

	public CaixaAbstrata procurar(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		if (this.repCaixa.existir(numeroCaixa)) {
			return repCaixa.procurar(numeroCaixa);
		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}

	}

	public void atualizar(CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException {
		if (this.repCaixa.existir(caixa.getNumeroCaixa())) {
			this.repCaixa.atualizar(caixa);
		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}
	
	
	public void remover(CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException {
		
		if(this.repCaixa.existir(caixa.getNumeroCaixa())) {
			
			this.repCaixa.remover(caixa.getNumeroCaixa());
		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}
	

}

