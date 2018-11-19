package dados;

import basicas.Pessoa;
import excecoes.PNEException;
import negocio.RepositorioPessoas;

public class RepositorioPessoasArray implements RepositorioPessoas {
	
	private Pessoa[] pessoas;
	private int indice;
	
	public RepositorioPessoasArray(int tam) {
		pessoas = new Pessoa[tam];
		indice = 0;
	}
	
	public void inserir(Pessoa pessoa) {
		pessoas[indice] = pessoa;
		indice = indice + 1;
	}
	
	public Pessoa procurar (String cpf) throws PNEException {
		Pessoa p = null;
		int i = this.getIndice(cpf);
		
		if (i == this.indice) {
			throw new PNEException();
		}else {
			p = this.pessoas[i];
		}
		return p;
	}
	
	public void remover(String cpf) throws PNEException{
		int i = this.getIndice(cpf);
		if (i == this.indice) {
			throw new PNEException();
		}else {
			this.indice = this.indice - 1;
			this.pessoas[i] = this.pessoas[this.indice];
			this.pessoas[this.indice] = null;
		}
	}
	
	public void atualizar(Pessoa pessoa) throws PNEException{
		int i = this.getIndice(pessoa.getCpf());
		if(i == this.indice) {
			throw new PNEException();
		}else {
			this.pessoas[i] = pessoa;
		}
	}
	
	private int getIndice(String cpf) {
		String c;
		boolean find = false;
		int i = 0;
		while ((!find) && (i < this.indice)) {
			c = pessoas[i].getCpf();
			if(c.equals(cpf)) {
				find = true;
			}
			else {
				i = i + 1;
			}
		}
		return i;
	}
	

}
