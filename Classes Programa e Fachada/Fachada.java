package pessoa;

public class Fachada {

	private CadastroPessoas cadastroPessoa;

	public Fachada(RepositorioPessoas repositorioPessoa) {
		this.cadastroPessoa = new CadastroPessoas(repositorioPessoa);
	}

	public void cadastrarPessoa(Pessoa pessoa)
			throws PessoaJaCadastradaException, PessoaNaoEncontradaException, ValorInvalidoException {
		this.cadastroPessoa.cadastrar(pessoa);
	}

	public void remover(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastroPessoa.remover(cpf);
	}

	public void procurar(String cpf) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastroPessoa.procurar(cpf);
	}

	public void atualizar(Pessoa pessoa) throws PessoaNaoEncontradaException, PessoaJaCadastradaException {
		this.cadastroPessoa.atualizar(pessoa);
	}

}
