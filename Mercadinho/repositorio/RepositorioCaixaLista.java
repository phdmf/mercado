package Mercadinho.repositorio;

public class RepositorioCaixaLista implements RepositorioCaixa {
	private CaixaAbstrata caixa;
	private RepositorioCaixaLista next;

	public RepositorioCaixaLista() {
		this.caixa = null;
		this.next = next;
	}

	public void inserir(CaixaAbstrata caixa) {
		if (this.caixa == null) {
			this.caixa = caixa;
			this.next = new RepositorioCaixaLista();
		} else {
			this.next.inserir(caixa);
		}

	}

	public void remover(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		if (this.caixa != null) {
			if (this.caixa.getNumeroCaixa().equals(numeroCaixa)) {
				this.caixa = this.next.caixa;
				this.next = this.next.next;
			} else {
				this.next.remover(numeroCaixa);
			}

		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}

	public CaixaAbstrata procurar(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		CaixaAbstrata c = null;
		if (this.caixa != null) {
			if (this.caixa.getNumeroCaixa().equals(numeroCaixa)) {
				c = this.caixa;
			} else {
				this.next.procurar(numeroCaixa);
			}
		}
		if (c != null) {
			return c;
		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}

	}

	public void atualizar(CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException {
		if (this.caixa != null) {
			if (caixa.equals(this.caixa)) {
				this.caixa = caixa;
			} else {
				this.next.atualizar(caixa);
			}
		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}

	public boolean existe(String numeroCaixa) {
		boolean n = true;
		if (numeroCaixa.equals(caixa.getNumeroCaixa())) {
			n = true;
		} else if (!(numeroCaixa.equals(caixa.getNumeroCaixa()))) {
			this.next.existe(numeroCaixa);
		} else {
			n = false;
		}
		return n;
	}

}