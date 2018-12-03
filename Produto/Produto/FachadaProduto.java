package Produto.exemplo;

import Mercadinho.Sointerfaces.NegocioProduto;
import Mercadinho.Sointerfaces.RepositorioProduto;
import Mercadinho.basic.Produto;
import Mercadinho.exception.ProdutoJaCadastradoException;
import Mercadinho.exception.ProdutoNaoEncontradoException;

public class FachadaProduto {
	
private NegocioProduto negocioProduto;
	
	
	
	public FachadaProduto (RepositorioProduto produto) {
				
		this.negocioProduto = new NegocioProduto();
	}

	public void cadastroProduto(Produto produto) throws ProdutoJaCadastradoException {
		this.negocioProduto.cadastrar(produto);
	}
	
	public void removerProduto(Produto produto) throws ProdutoNaoEncontradoException{
		this.negocioProduto.excluir(produto);
	}
		
	public Produto procurarProduto(String id) throws ProdutoNaoEncontradoException {
		return this.negocioProduto.procurar(id);
	}
	
	public void atualizarProduto(Produto produto) throws ProdutoNaoEncontradoException {
		this.negocioProduto.atualizar(produto);
	}
public String imprimirProduto(String id) throws ProdutoNaoEncontradoException, ProdutoJaCadastradoException {
		
		
		Produto produto = this.negocioProduto.procurar(id);

		String print = "Nome: " + produto.getNome() 
				+ "\nID: " + produto.getId()
				+ "\nTipo: " + produto.getTipo()
				+ "\nPreço: " + produto.getPreco() ;
																								
		return print;

	}
}
