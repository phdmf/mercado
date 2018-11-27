package Mercadinho.negocioInterface;


import Excessoes.FornecedorInexistenteConsultaException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNomeJaCadastradoException;
import Fornecedores.fornecedor;

public interface repositorioFornecedores {
	//A interface é que rege as classes dos repositorios; 
	
	public void inserir(Fornecedor fornecedor) throws FornecedorNomeJaCadastradoException; 
	public void atualizar (fornecedor fornecedor) throws FornecedorNaoEncontradoException; 
	public fornecedor procurar (String fornecedor) throws FornecedorNaoEncontradoException;  
	boolean existir (fornecedor fornecedor); 
	public void remover (fornecedor fornecedor) throws FornecedorNaoEncontradoException;
	// o cnpj sera o indice exclusivo (por ser unico) para excluir o fornecedor inteiro

}