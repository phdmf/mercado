package Produto.Sointerfaces;

import Mercadinho.basic.Produto;
import Mercadinho.exception.ProdutoNaoEncontradoException;

public interface RepositorioProduto {

	void inserir(Produto produto);

	Produto procurar(String tipo) throws ProdutoNaoEncontradoException;

	void atualizar(Produto produto) throws ProdutoNaoEncontradoException;

	void remover(String tipo) throws ProdutoNaoEncontradoException;

	boolean existir(String tipo);

	int temQuantos(String produto, int quantidade);
}