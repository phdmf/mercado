package Mercadinho.exception;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException() {
        super ("Produto não encontrado.") ;
    }
}
