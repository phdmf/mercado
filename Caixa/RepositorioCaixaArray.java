package teste2;


public class RepositorioCaixaArray implements RepositorioCaixa {
	
	private CaixaAbstrata[] caixaAbs;
	private int indice;

	public RepositorioCaixaArray() {
		caixaAbs = new CaixaAbstrata[30];
		indice = 0;
	}
	
	public void inserir (CaixaAbstrata caixa) {
		caixaAbs[indice] = caixa;
		indice++;
	}
	
	public void atualizar (CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException{
		boolean t = false;
		for (int i = 0; i < indice; i++) {
			if (caixaAbs[i].getNumeroCaixa().equals(caixa.getNumeroCaixa())) {
				caixaAbs[i] = caixa;
				t = true;
			}
		}
		if (!t) {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}
	
	public void remover(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		boolean t = false;
		for (int i = 0; i < indice; i++) {
			if (caixaAbs[i].getNumeroCaixa().equals(numeroCaixa)) {
				t = true;
				caixaAbs[i] = null;
				int j = i;
				for (i = j; i<indice; i++) {
					if (i != indice -1) {
						caixaAbs[i] = caixaAbs[i + 1];
					} else {
						caixaAbs[i] = null;
					}
				}
			}
		}
		if(!t) {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}
	
	public CaixaAbstrata procurar(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		CaixaAbstrata c = null;
		
		for (int i = 0; i<indice; i++) {
			if (caixaAbs[i].getNumeroCaixa().equals(numeroCaixa)) {
				c = caixaAbs[i];
			}
		}
		if (c == null) {
			throw new NumeroCaixaNaoEncontradaException();
		} else {
			return c;
		}
	}
	
	public boolean existe(String numeroCaixa) {
		boolean n = false;
		for (int i = 0; i<indice; i++) {
			if (caixaAbs[i].getNumeroCaixa().equals(numeroCaixa)) {
				n = true;
			} else {
				n = false;
			}
		}
		return n;
	

	}
	
}