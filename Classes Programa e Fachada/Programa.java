package pessoa;

import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		Pessoa pessoa = null;
		RepositorioPessoas personRep = null;
		Fachada fachada = null;
		
		String choice = null;
		int contador = 1;
		
		try {
			System.out.println("Escolha a forma que deseja armazenar seus dados: \n1. Array \n2. Lista");
			choice = in.next();
			
			if(choice.length() > 1 || !choice.equals("1") && !choice.equals("2")) {
				throw new ValorInvalidoException();
			}else if (choice.equals("1")) {
				personRep = new RepositorioPessoasArray();
			}else if (choice.equals("2")) {
				personRep = new RepositorioPessoasLista();
			}
			
			fachada = new Fachada(personRep);
		}catch(ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		// Eu testei com todos os atributos, mas tô enviando só com dois pq foi o último teste. =) Na classe de vcs apaguem esse comentário a Administração agradece
		// Tem um erro no código que eu deixei pra vcs procurarem só pra fazer se vcs tão sabendo do assunto. =)
		// HAHAHAHAHAHAH
		do {
			
			try {
				if (contador == 1) {
					pessoa = new Pessoa("11122233344", "Ana Beatriz Neves", "20.11.1997", "Queen's Street", "(081)987983700");
					fachada.cadastrarPessoa(pessoa);
					System.out.println("CPF: " + pessoa.getCpf());
					System.out.println("Nome: " + pessoa.getNome());
					
				}else {
					System.out.println(pessoa.getNome());
				}
			}catch(PessoaJaCadastradaException e) {
				System.out.println(e.getMessage());
			}catch (PessoaNaoEncontradaException e) {
				System.out.println(e.getMessage());
			}catch (ValorInvalidoException e) {
				System.out.println(e.getMessage());
			}
			
		}while(contador == 0);
		// É brincadeira tá gente? Tem erro nenhum kkkkk... Mas apaguem esses comentários. A administração agra 
		//dece
	}

}
