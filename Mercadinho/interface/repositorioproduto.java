package Mercadinho.negocioInterface;
import basicas.*;
import excecoes.*;
 
public interface RepositorioProduto {
    void inserir(Produto produto) ;
    Produto procurar(String tipo) throws ProdutoNaoEncontradoException ;
    void atualizar(Produto produto) throws ProdutoNaoEncontradoException ;
    void remover(String tipo) throws ProdutoNaoEncontradoException ;
    boolean existe(String tipo) ;
    int temQuantos(String produto, int quantidade);
}