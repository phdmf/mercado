package Fornecedor.Exemplo;

import java.util.Scanner;

import Fornecedor.Fornecedor;
import Fornecedor.FornecedorNaoEncontradoException;
import Fornecedor.FornecedorNomeJaCadastradoException;
import Fornecedor.RepositorioFornecedorLista;
import Fornecedor.RepositorioFornecedores;
import Fornecedor.RepositorioFornecedoresArray;
import Fornecedor.ValorInvalidoException;

public class ProgramaFornecedor {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		Fornecedor marilan = null;
		Fornecedor julia = null;

		RepositorioFornecedores repFornecedor = null;

		FachadaFornecedor FachadaFornecedor = null;
		
		String choice = null;
		int contador = 1;
		
		try {
			System.out.println("Escolha a forma que deseja armazenar seus dados: \n1. Array \n2. Lista");
			choice = in.next();
			
			if(choice.length() > 1 || !choice.equals("1") && !choice.equals("2")) {
				throw new ValorInvalidoException();
			}else if (choice.equals("1")) {
				// no meu array eu tinha colocado uma declaração de tamanho. 
				//Aqui eu não vi.Ele vai ser declarado no proprio array? 
				repFornecedor = new RepositorioFornecedoresArray(100);
			}else if (choice.equals("2")) {
				repFornecedor = new RepositorioFornecedorLista();
			}
			
			FachadaFornecedor = new FachadaFornecedor(repFornecedor);
			// pra que serve esse E?
		}catch(ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		do {
			
			try {
				if (contador == 1) {
					
					marilan = new Fornecedor("123.456.789", "Marilan",
							"Biscoitos e Massas", "Marilia, São Paulo, SP",
							"Biscoito Maisena", "11 987654321");

					julia = new Fornecedor("123.400.789", "Julia",
							"Biscoitos e Massas", "Marilia, São Paulo, SP",
							"Biscoito Maisena", "11 987654321");
					
					FachadaFornecedor.cadastroFornecedor(marilan);
					FachadaFornecedor.cadastroFornecedor(julia);
					
					System.out.println("CNPJ: " + marilan.getCnpj()); 
					System.out.println("Nome: " + julia.getNomeFantasia());  
					
				}else {
					System.out.println(julia.getNomeFantasia());
				}
			}catch(FornecedorNaoEncontradoException e) {
				System.out.println(e.getMessage());
			}catch (FornecedorNomeJaCadastradoException e) {
				System.out.println(e.getMessage());
				
				// ta pedindo pra retirar esse erro abaixo
			}catch (ValorInvalidoException e) {
				System.out.println(e.getMessage());
			} 
			// ai quando eu tiro, ele pede pra fazer outra coisa. Buguei :(
			
		}while(contador == 0);
		
	}

}

