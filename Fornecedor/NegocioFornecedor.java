package Fornecedor;

// colocar erro "n�o encontrado nesse repositorio"

public class NegocioFornecedor {

	private RepositorioFornecedores repForn;

	// Metodo que inicia os atributos da classe negocio de fornecedor

	public NegocioFornecedor(RepositorioFornecedores repForn) {
		this.repForn = repForn;
	}

	// Metodo que cadastra pessoas no reposit�rio de pessoas

	public void cadastrar(Fornecedor fornecedor) throws FornecedorNomeJaCadastradoException, FornecedorNaoEncontradoException {
	// deixei esse 2o erro porque o metodo ficou reclamando, mas vou retirar
		if (this.repForn.procurar(fornecedor.getCnpj()) == null) {
			// this.validar(fornecedor); // o que seria esse metodo validar?
			this.repForn.inserir(fornecedor);
		} else {
			throw new FornecedorNomeJaCadastradoException();
		}
	}
	
	/**
	 * M�todo que atualiza uma pessoa presente no reposit�rio de pessoas
	 * @param pessoa Pessoa - pessoa com os dados atualizados.
	 * @throws RepositorioException exce�ao para tratamento de erros no repositorio.
	 * @throws ValorInvalidoException exce��o para tramaneto de valores invalidos.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	
	public void atualizar(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		//aqui ele vai procurar um cnpj no repositorio igual ao da variavel
		//se tiver, ele atualiza tudo. 
		if(this.repForn.procurar(fornecedor.getCnpj()) != null){
			//ta faltando coisa aqui, ne? 
			//era para ele pegar o antigo e colocar o novo nao? 
			this.repForn.atualizar(fornecedor);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}
	
	
	
	
	/**
	 * M�todo que procura por um fornecedor no repositorio de pessoas segundo um cnpj e o retorna.
	 * Cnpj String - cnpj da pessoa a ser removida.
	 *  Pessoa - Pessoa com o respectivo CPF.
	 * @throws RepositorioException exce��o para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException{
		// nesse caso ele faz uma varredura no repositorio, sem a necessidade
		// de um "caso nao ache cnpj nesse objeto, va para o proximo" ?
		Fornecedor fornecedor = this.repForn.procurar(cnpj);
		if(fornecedor == null){
			throw new FornecedorNaoEncontradoException();
		} else {
			return fornecedor;
		}
	}
	
	
	/**
	 * Metodo que remove uma pessoa do repositorio de pessoas.
	 Cnpj String - cnpj da pessoa a ser removida.
	 * @throws RepositorioException exce��o para tratamento de erros no repositorio.
	 * @throws ValorNaoEncontradoException exce��o para tratamento de valores n�o encontrados.
	 */
	
	public void remover(Fornecedor fornecedor) throws FornecedorNaoEncontradoException {
		//aqui como eu identificaria o cnpj? Nesse caso ele considera so os casos
		//do fornecedor ser exatamente igual para remover? 
		if(this.repForn.existir(fornecedor)) {
			//if (repForn.equals(fornecedor.getCnpj()))
			this.repForn.remover(fornecedor);
		} else {
			throw new FornecedorNaoEncontradoException();
		}
	}

	 
	
}


