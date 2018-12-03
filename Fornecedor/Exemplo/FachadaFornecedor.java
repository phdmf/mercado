package Fornecedor.Exemplo;

import Fornecedor.Fornecedor;
import Fornecedor.FornecedorNaoEncontradoException;
import Fornecedor.FornecedorNomeJaCadastradoException;
import Fornecedor.NegocioFornecedor;
import Fornecedor.RepositorioFornecedores;

public class FachadaFornecedor {
	
	private NegocioFornecedor negocioFornecedor;
	
	// colocar erro no repositorio
	
	public FachadaFornecedor(RepositorioFornecedores repForn) {
				
		this.negocioFornecedor = new NegocioFornecedor(repForn);
	}

	public void cadastroFornecedor(Fornecedor fornecedor) throws FornecedorNomeJaCadastradoException {
		this.negocioFornecedor.cadastrar(fornecedor);
	}
	
	public void removerFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		this.negocioFornecedor.remover(fornecedor);
	}
		
	public Fornecedor procurarFornecedor(String cnpj) throws FornecedorNaoEncontradoException {
		return this.negocioFornecedor.procurar(cnpj);
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.negocioFornecedor.atualizar(fornecedor);
	}
	
}
