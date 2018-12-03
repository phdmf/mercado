package Produto.Sointerfaces;
import Mercadinho.basic.*;
import Mercadinho.exception.ProdutoJaCadastradoException;
import Mercadinho.exception.ProdutoNaoEncontradoException;
public class NegocioProduto {

private RepositorioProduto produto;
	
	public void cadastrar(Produto produto) throws ProdutoJaCadastradoException {
		if (!(this.produto.existir(produto.getNome()))) {
			this.produto.inserir(produto);
		} else {
			throw new ProdutoJaCadastradoException();
		}
	}
	public Produto procurar(String nome) throws ProdutoNaoEncontradoException {
		if (this.produto.existir(nome)) {
			return produto.procurar(nome);
		} else {
			throw new ProdutoNaoEncontradoException();
		}
			
	}
	public void atualizar (Produto produto) throws ProdutoNaoEncontradoException {
		if (this.produto.existir(produto.getNome())) {
			this.produto.atualizar(produto);
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}	public void excluir(Produto produto) throws ProdutoNaoEncontradoException {

		if (this.produto.existir(produto.getNome())) {
			this.produto.remover(produto.getNome());
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}
	
}
	
	
	
	
