package Fornecedor.Exemplo;

import java.util.Scanner;

import Fornecedor.Fornecedor;
import Fornecedor.FornecedorNaoEncontradoException;
import Fornecedor.FornecedorNomeJaCadastradoException;
import Fornecedor.RepositorioFornecedorLista;
import Fornecedor.RepositorioFornecedores;
import Fornecedor.RepositorioFornecedoresArray;
import Fornecedor.ValorInvalidoException;

public class TesteFornecedor {

	public static void main(String[] args) throws FornecedorNomeJaCadastradoException,
			FornecedorNaoEncontradoException {

		Scanner in = new Scanner(System.in);

		// declaração de todas as classes inicializando-as

		Fornecedor marilan = null;
		Fornecedor julia = null;

		RepositorioFornecedores repFornecedor = null;

		FachadaFornecedor FachadaFornecedor = null;
		String op1;
		int i = 1;

		try {
			System.out
					.println("Escolha o tipo de repositório: \n1. Array \n2. Lista"); // retirar
																						// arquivo
			op1 = in.nextLine();

			// (aqui diz que se opção 1 for maior que 1 caractere, ou diferente
			// do numero 1,2 ou 3, dará um erro.)

			if (op1.length() > 1 || !op1.equals("1") && !op1.equals("2")) {
				throw new ValorInvalidoException();
			} else if (op1.equals("1")) {

				// declarar o tamanho do array entre os parenteses.

				repFornecedor = new RepositorioFornecedoresArray(100);

			} else if (op1.equals("2")) {

				repFornecedor = new RepositorioFornecedorLista();

			}

			FachadaFornecedor = new FachadaFornecedor(repFornecedor);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}

		do {
			try {
				if (i == 1) {

					marilan = new Fornecedor("123.456.789", "Marilan",
							"Biscoitos e Massas", "Marilia, São Paulo, SP",
							"Biscoito Maisena", "11 987654321");

					julia = new Fornecedor("123.400.789", "Julia",
							"Biscoitos e Massas", "Marilia, São Paulo, SP",
							"Biscoito Maisena", "11 987654321");

					// aqui ja vai ser o cadastro dos objetos instanciados

					System.out.println(marilan.getCnpj());

					FachadaFornecedor.cadastroFornecedor(marilan);
					FachadaFornecedor.cadastroFornecedor(julia);

					// aqui vai atualizar os dados ja setados anteriormente

				} else if (i == 2) {
					Fornecedor forn1 = marilan; // aqui clona ?
					forn1.setTelefone("81 94459-7855");
					FachadaFornecedor.atualizarFornecedor(forn1);
				} else if (i == 3) {
					Fornecedor forn1 = marilan;
					forn1.setRamoDeAtuacao("Massas");
					FachadaFornecedor.atualizarFornecedor(forn1);
				} else if (i == 8) {
					FachadaFornecedor.removerFornecedor(marilan);
				}

			} finally {
				System.out.println("Deseja continuar? \n1. Sim \n2. Não");
				op1 = in.nextLine();

				if (op1.equals("1")) {
					i++;
				} else {
					System.out.println("Tchau :3");
					i = 11;
				}
			}
		} while (i <= 10);

		System.out.println("Tchau :3");

		in.close();
	}
}
