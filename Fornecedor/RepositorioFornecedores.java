package Fornecedor;

public interface RepositorioFornecedores {
	// A interface é que rege as classes dos repositorios;

	public void inserir(Fornecedor fornecedor) throws FornecedorNomeJaCadastradoException;

	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException;

	public Fornecedor procurar(String fornecedor) throws FornecedorNaoEncontradoException;

	boolean existir(Fornecedor fornecedor);

	public void remover(Fornecedor fornecedor) throws FornecedorNaoEncontradoException;
	// o cnpj sera o indice exclusivo (por ser unico) para excluir o fornecedor
	// inteiro

}