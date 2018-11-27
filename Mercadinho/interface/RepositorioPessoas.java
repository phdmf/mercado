package Mercadinho.negocioInterface;

import basicas.Pessoa;
import excecoes.PNEException;

public interface RepositorioPessoas {
	
	public void inserir(Pessoa pessoa);
	public void atualizar (Pessoa pessoa) throws PNEException;
	public void remover (String cpf) throws PNEException;
	public Pessoa procurar (String cpf) throws PNEException;
	//public boolean existe(String numero);

}
