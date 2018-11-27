package Mercadinho.repositorio;
import basicas.*;
import negocio.*;
import negocio_dados.*;

public abstract class RepositorioCaixasLista implements RepositorioCaixa {
	private CaixaAbstrata caixa;
	private RepositorioCaixaLista next;
	
	public RepositorioCaixaLista() {
		this.caixa = null;
		this.next = next;
	}
	
	public void inserir (CaixaAbstrata caixa) {
		if (this.caixa == null) {
			this.caixa = caixa;
			this.next = new RepositorioCaixaLista();
		} else {
			this.next.inserir(caixa);
		}
		
	}

	public void remover (String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		if (this.caixa != null) {
			if (this.caixa.getNumeroCaixa().equals(numeroCaixa)) {
				this.caixa = this.next.produto;
				this.next = this.next.next;
			} else {
				this.next.remover(numeroCaixa);
			}
			
		} else {
			throw new NumeroCaixaNaoEncontradaException();
		}
	}
	
	public Caixa procurar (String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		Caixa c = null;
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
	
	public void atualizar (Caixa caixa) throws NumeroCaixaNaoEncontradaException {
		if (this.caixa != null) {
			if (caixa.equals(this.caixa)) {
				this.caixa = caixa;
			} else {
				this.next.atulizar(caixa);
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
