package negocio;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorInexistenteConsultaException;
import Excessoes.FornecedorInexistenteRemoveException;
import Excessoes.FornecedorNaoEncontradoAtException;
import Excessoes.FornecedorNaoEncontradoPrException;
import Excessoes.FornecedorNomeJaCadastradoException;
import Fornecedores.fornecedor;

public interface repositorioFornecedores {
	
	public void inserir(fornecedor fornecedor) throws FornecedorNomeJaCadastradoException; 
	public void atualizar (fornecedor fornecedor) throws FornecedorNaoEncontradoAtException; 
	public fornecedor procurar (String cnpj) throws FornecedorNaoEncontradoPrException;  
	boolean existe (String cnpj) throws FornecedorInexistenteConsultaException; 
	public void remover (String cnpj) throws FornecedorDadosIncompletosException, FornecedorInexistenteRemoveException;
	// o cnpj sera o indice exclusivo (por ser unico) para excluir o fornecedor inteiro

}
