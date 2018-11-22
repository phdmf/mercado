package negocio;

import Fornecedores.fornecedor;

public interface repositorioFornecedores {
	
	public void inserir(fornecedor fornecedor); // criar os casos de erros para habilitar os PNEExceptions. 
	public void atualizar (fornecedor fornecedor); //throws PNEException;
	public void remover (String cnpj); // throws PNEException; // o cnpj sera o indice exclusivo (por ser unico) para excluir o fornecedor inteiro
	public fornecedor procurar (String cnpj); // throws PNEException;

}
