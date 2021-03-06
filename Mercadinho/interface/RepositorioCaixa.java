package Mercadinho.Sointerfaces;

import Mercadinho.basic.CaixaAbstrata;
import Mercadinho.exception.NumeroCaixaNaoEncontradaException;

public interface RepositorioCaixa {
	
	void inserir(CaixaAbstrata caixa);
	
	void atualizar(CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException;
	
	void remover(String numeroCaixa) throws NumeroCaixaNaoEncontradaException;
	
	CaixaAbstrata procurar(String numeroCaixa) throws NumeroCaixaNaoEncontradaException;
	
	boolean existe(String numeroCaixa);

}
