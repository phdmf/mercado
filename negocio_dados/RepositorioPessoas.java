package negocio_dados;

import basicas.Pessoa;
import excecoes.PessoaNaoEncontradaException;

public interface RepositorioPessoas {
	
	public void inserir(Pessoa pessoa);
	public void atualizar (Pessoa pessoa) throws PessoaNaoEncontradaException;
	public void remover (String cpf) throws PessoaNaoEncontradaException;
	public Pessoa procurar (String cpf) throws PessoaNaoEncontradaException;
	public boolean existe(String cpf);

}
