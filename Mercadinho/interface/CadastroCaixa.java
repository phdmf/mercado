package Mercadinho.negocioInterface;


public class CadastroCaixa {
	private RepositorioCaixa caixa;
	
	public CadastroCaixa(char t) {
		if (t == 'a' || t == 'A') {
			this.caixa = new RepositorioCaixaArray();
		} else {
			this.caixa = new RepositorioCaixaLista();
		}
	}

	public void cadastrar(CaixaAbstrata caixa) throws CaixaJaCadastradoException {
		if (!(this.caixa.existe(caixa.getNumeroCaixa()))) {
			this.caixa.inserir(caixa);
		} else {
			throw new CaixaJaCadastradoException();
		}
	}
	
	public CaixaAbstrata procurar(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		return caixa.procurar(numeroCaixa);
	}
	public void atualizar (CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException {
		this.caixa.remover(caixa.getNumeroCaixa());
	}	
	
}