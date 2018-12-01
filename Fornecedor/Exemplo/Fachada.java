package Mercadinho.Exemplo;


//IMPORTS

import br.com.biblioteca.basic.Aluno;
import br.com.biblioteca.basic.Emprestimo;
import br.com.biblioteca.basic.Livro;
import br.com.biblioteca.basic.EspacoEstudo;
import br.com.biblioteca.basic.Fornecedor;
import br.com.biblioteca.basic.Pessoa;
import br.com.biblioteca.exceptions.EmprestimoException;
import br.com.biblioteca.exceptions.EspacoEstudoException;
import br.com.biblioteca.exceptions.LivroException;
import br.com.biblioteca.exceptions.FornecedorException;
import br.com.biblioteca.exceptions.PessoaException;
import br.com.biblioteca.negocio.CadastroEmprestimo;
import br.com.biblioteca.negocio.CadastroEspacoEstudo;
import br.com.biblioteca.negocio.CadastroLivros;
import br.com.biblioteca.negocio.CadastroPessoa;
import br.com.biblioteca.negocio.CadastroFornecedor;

public class Fachada {

	
	//CADASTROS
	
	CadastroEmprestimo cadastroEmprestimo;
	CadastroEspacoEstudo cadastroEspEstudo;
	CadastroLivros cadastroLivro;
	CadastroPessoa cadastroPessoa;
	CadastroFornecedor cadastroFornecedor;
	
	public Fachada(CadastroEmprestimo cadastroEmprestimo,
			CadastroEspacoEstudo cadastroEspEstudo,
			CadastroLivros cadastroLivro, CadastroPessoa cadastroPessoa,
			CadastroFornecedor cadastroFornecedor) {
		this.cadastroEmprestimo = cadastroEmprestimo;
		this.cadastroEspEstudo = cadastroEspEstudo;
		this.cadastroLivro = cadastroLivro;
		this.cadastroPessoa = cadastroPessoa;
		this.cadastroFornecedor = cadastroFornecedor;
	}
	
	
	//GETTERS N' SETTERS
	
	public CadastroEmprestimo getCadastroEmprestimo() {
		return cadastroEmprestimo;
	}

	public void setCadastroEmprestimo(CadastroEmprestimo cadastroEmprestimo) {
		this.cadastroEmprestimo = cadastroEmprestimo;
	}

	public CadastroEspacoEstudo getCadastroEspEstudo() {
		return cadastroEspEstudo;
	}

	public void setCadastroEspEstudo(CadastroEspacoEstudo cadastroEspEstudo) {
		this.cadastroEspEstudo = cadastroEspEstudo;
	}

	public CadastroLivros getCadastroLivro() {
		return cadastroLivro;
	}

	public void setCadastroLivro(CadastroLivros cadastroLivro) {
		this.cadastroLivro = cadastroLivro;
	}	
	
	public CadastroPessoa getCadastroPessoa(){
		return cadastroPessoa;
	}
	
	public void setCadastroPessoa(CadastroPessoa cadastroPessoa){
		this.cadastroPessoa = cadastroPessoa;
	}
	
	
	
	
	//EMPRESTIMO - RAMOM
	
	public void pegarLivroEmprestado(Aluno a, Livro l) throws EmprestimoException {
		cadastroEmprestimo.cadastrar(new Emprestimo(a, l));
	}
	
	public void devolverLivro(Aluno a, Livro l)throws EmprestimoException {
		cadastroEmprestimo.remover(new Emprestimo(a, l));
	}
	
	public void renovarEsp(Aluno a, Livro l) throws EmprestimoException {
		Emprestimo e = new Emprestimo(a, l);
		cadastroEmprestimo.atualizar(e);
	}
	
	public Emprestimo verificar(Emprestimo e) throws EmprestimoException {
		return cadastroEmprestimo.procurar(e.getLivro(),e.getAluno());
	}
	
	
	//ESPACOESTUDO - NETO
	
	public void cadastrarEspEstudo (int id) throws EspacoEstudoException {
		cadastroEspEstudo.cadastrar(new EspacoEstudo(id));
	}
	public void removerEspEstudo (EspacoEstudo esp) throws EspacoEstudoException{
		cadastroEspEstudo.remover(esp);
	}
	public void atualizarEsp (EspacoEstudo esp) throws EspacoEstudoException{
		cadastroEspEstudo.atualizar(esp);
	}
	public EspacoEstudo procurarEspEstudo(int id) throws EspacoEstudoException{
		return cadastroEspEstudo.procurar(id);
	}
	
	public void reservarEspaco(int id, Aluno aluno) throws EspacoEstudoException {
		aluno.reservarEspaco(procurarEspEstudo(id));
	}
	
	//LIVROS - NUNES
		
	public void cadastrarLivro(Livro livro) throws LivroException, FornecedorException {
		Fornecedor f = cadastroFornecedor.procurar(livro.getFornecedor().getCNPJ());
		if (f != null ){
			Livro l = cadastroLivro.procurar(livro.getTitulo());
			if(l != null) {
				l.setquantidade(l.getquantidade() + livro.getquantidade());
			} else {
				cadastroLivro.cadastrar(livro);
			}
		}else{
			cadastroFornecedor.cadastrar(livro.getFornecedor());
			cadastroLivro.cadastrar(livro);
		}

	}
	
	public void removerLivro (Livro livro) throws LivroException {
		cadastroLivro.remover(livro);
	}	
	public void atualizarLivro (Livro livro) throws LivroException{
		cadastroLivro.atualizar(livro);
	}
	public Livro procurarLivro(String titulo) throws LivroException{
		return cadastroLivro.procurar(titulo);
	}
	
	//Fornecedor - NUNES
	
	public void removerFornecedor (Fornecedor fornecedor) throws FornecedorException {
		cadastroFornecedor.remover(fornecedor);
	}	
	public void atualizarFornecedor (Fornecedor fornecedor) throws FornecedorException{
		cadastroFornecedor.atualizar(fornecedor);
	}
	public Fornecedor procurarFornecedor (int cnpj) throws FornecedorException{
		return cadastroFornecedor.procurar(cnpj);
	}
	
	
	
	//PESSOAS - DANIEL
	
	public void cadastrarPessoa(Pessoa pessoa) throws PessoaException {
		cadastroPessoa.cadastrar(pessoa);			
	}
	
	public void removerPessoa(Pessoa pessoa) throws PessoaException {
		cadastroPessoa.remover(pessoa);		
	}
	
	public void atualizarPessoa(Pessoa pessoa) throws PessoaException {
		cadastroPessoa.atualizar(pessoa);
	}
	
	public Pessoa procurarPessoa(Pessoa pessoa) throws PessoaException {
		return cadastroPessoa.procurar(pessoa);		
	}	
	

}






