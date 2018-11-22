package dados;

import basicas.*;
import excecoes.*;
import negocio.*;


public class RepositorioProdutoArray implements RepositorioProduto {
	private Produto[] produtos ;
	private int indice ;
	
	public RepositorioProdutoArray(int tam) {
		produtos = new Produto[tam] ;
		indice=0;
	}
	
	public void inserir(Produto produto) {
		produtos[indice] = produto ;
		indice++ ;
	}
	
	public void remover(String tipo) throws ProdutoNaoEncontradoException {
		boolean achou = false ;
		for (int i=0;i<indice;i++) {
			if (produtos[i].getTipo().equals(tipo)) {
				achou = true ;
				produtos[i] = null ;
				int j = i ;
				for (i=j;i<indice;i++) {
					if (i != indice-1) {
						produtos[i] = produtos[i+1] ;
					}
					else {
						produtos[i] = null ;
						indice-- ;
					}
				}
			}
		}
		if (!achou) {
			throw new ProdutoNaoEncontradoException() ;
		}
	}
	
	public Produto procurar(String tipo) throws ProdutoNaoEncontradoException {
		Produto p = null ;
		for (int i=0;i<indice;i++) {
			if (produtos[i].getTipo().equals(tipo)) {
				p = produtos[i] ;
			}
		}
		if (p == null) {
			throw new ProdutoNaoEncontradoException() ;
		}
		else {
			return p ;
		}
	}
	
	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		boolean achou = false ;
		for (int i=0;i<indice;i++) {
			if (produtos[i].getTipo().equals(produto.getTipo())) {
				produtos[i] = produto ;
				achou = true ;
			}
		}
		if (!achou) {
			throw new ProdutoNaoEncontradoException() ;
		}
	}
	
	public boolean existe(String tipo) {
		boolean achou = false ;
		for (int i=0;i<indice;i++) {
			if (produtos[i].getTipo().equals(tipo)) {
				achou = true ;
			}
		}
		return achou ;
	}
	
	
		
	}
