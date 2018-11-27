package br.com.biblioteca.principal;

import br.com.biblioteca.basic.*;
import br.com.biblioteca.exceptions.*;
import br.com.biblioteca.interfaces.*;
import br.com.biblioteca.negocio.*;
import br.com.biblioteca.repositorios.*;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RepositorioEmprestimosArray repositorioEmprestimo = new RepositorioEmprestimosArray(10);
		RepositorioEspacosEstudoArray repositorioEspEstudo = new RepositorioEspacosEstudoArray(10);
		RepositorioFornecedorArray repositorioFornecedor;
		RepositorioLivroArray repositorioLivro;
		RepositorioPessoasArray repositorioPessoa;
		
		
		CadastroEmprestimo cadastroEmprestimo = new CadastroEmprestimo(repositorioEmprestimo);
		CadastroEspacoEstudo cadastroEspEstudo;
		CadastroLivros cadastroLivro;
		CadastroPessoa cadastroPessoa;
		CadastroFornecedor cadastroFornecedor;
		
		Fachada fachada = new Fachada(cadastroEmprestimo,cadastroEspEstudo,
				cadastroLivro, cadastroPessoa,cadastroFornecedor);
	}

}
