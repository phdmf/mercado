package Produto.repositorio;

import Mercadinho.Sointerfaces.RepositorioProduto;
import Mercadinho.basic.Produto;
import Mercadinho.exception.ProdutoNaoEncontradoException;

public class RepositorioProdutoLista implements RepositorioProduto {
	private Produto produto;
	private RepositorioProdutoLista next;

	public RepositorioProdutoLista() {
		this.produto = null;
		this.next = null;
	}

	public void inserir(Produto produto) {
		if (this.produto == null) {
			this.produto = produto;
			this.next = new RepositorioProdutoLista();
		} else {
			this.next.inserir(produto);
		}
	}

	public void remover(String nome) throws ProdutoNaoEncontradoException {
		if (this.produto != null) {
			if (this.produto.getTipo().equals(nome)) {
				this.produto = this.next.produto;
				this.next = this.next.next;
			} else {
				this.next.remover(nome);
			}
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public Produto procurar(String nome) throws ProdutoNaoEncontradoException {
		Produto p = null;
		if (this.produto != null) {
			if (this.produto.getTipo().equals(nome)) {
				p = this.produto;
			} else {
				this.next.procurar(nome);
			}
		}
		if (p != null) {
			return p;
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public void atualizar(Produto produto) throws ProdutoNaoEncontradoException {
		if (this.produto != null) {
			if (this.produto.getTipo().equals(produto.getTipo())) {
				this.produto = produto;
			} else {
				this.next.atualizar(produto);
			}
		} else {
			throw new ProdutoNaoEncontradoException();
		}
	}

	public boolean existir(String nome) {
		boolean achou = false;
		if (this.produto != null) {
			if (this.produto.getTipo().equals(nome)) {
				achou = true;
			} else {
				this.next.existir(nome);
			}
		}
		return achou;
	}

	public int temQuantos(String produto, int quantidade) { // procura quantos produtos X, tem na lista
		if (this.produto.equals(produto)) {
			quantidade++;
		}
		if (this.next != null) {
			return this.next.temQuantos(produto, quantidade);
		}
		return quantidade;
	}
}
