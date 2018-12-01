package Fornecedor.Exemplo;

import Fornecedor.Fornecedor;
import Fornecedor.FornecedorNaoEncontradoException;
import Fornecedor.FornecedorNomeJaCadastradoException;
import Fornecedor.NegocioFornecedor;
import Fornecedor.RepositorioFornecedores;

public class FachadaFornecedor {
	
	private NegocioFornecedor cadastroFornecedor;
	
	// colocar erro no repositorio
	
	public FachadaFornecedor(RepositorioFornecedores repForn) {
		super();
		
		this.cadastroFornecedor = new NegocioFornecedor(repForn);
	}

	// metodo para chamar o metodo cadastrar

	public void cadastroFornecedor(Fornecedor fornecedor) throws FornecedorNomeJaCadastradoException, FornecedorNaoEncontradoException {
		this.cadastroFornecedor.cadastrar(fornecedor);
	}
	
	// @throws RepositorioException exceção para tratamento de erros no repositorio.
	 	
	public void removerFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException{
		this.cadastroFornecedor.remover(fornecedor);
	}
		
	public Fornecedor procurarFornecedor(String cnpj) throws FornecedorNaoEncontradoException {
		return this.cadastroFornecedor.procurar(cnpj);
	}
	
	public void atualizarFornecedor(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		this.cadastroFornecedor.atualizar(fornecedor);
	}
	
	/**
	 * Metodo que realiza a compra de um produto, indicando a quantidade, por uma pessoa cadastrada. 
	 * @param CPF String - cpf do comprador
	 * @param ISBN String - ISBN do produto a ser comprado.
	 * @param quant int - quantidade de produtos a serem adqueridos.
	 * @throws RepositorioException exceçao para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exceção para tratamento de valores não encontrados.
	 * @throws ValorInvalidoException exceção para tratamento de valores invalidos.
	 * @throws QuantidadeIndisponivelException excecao para tratamento de quantidade indisponivel.
	 
	
	public void comprar(String CPF, String ISBN, int quant) throws  FornecedorNaoEncontradoException{
		Pessoa pessoa = this.nPessoa.procurar(CPF);
		Produto produto = this.nProduto.procurar(ISBN);
		if(quant > 0){
			if(produto.getDisponibilidade() >= quant){
				pessoa.adquerirProduto(produto, quant);
				produto.setDisponibilidade(quant);
				this.nPessoa.atualizar(pessoa);
				this.nProduto.atualizar(produto);
			} else {
				throw new QuantidadeIndisponivelException(produto.getDisponibilidade());
			}
		} else {
			throw new ValorInvalidoException("quantidade! É necessario adquerir ao menos 1");
		}
		
		*/
	}

	
		
	
	
