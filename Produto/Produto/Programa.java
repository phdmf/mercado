package Produto.exemplo;

import java.util.Scanner;

import Mercadinho.Exemplo.Fachada;
import Mercadinho.Sointerfaces.RepositorioProduto;
import Mercadinho.basic.Produto;
import Mercadinho.exception.*;
import Produto.exception.EntradaInvalidaException;
import Produto.repositorio.RepositorioProdutoArray;
import Produto.repositorio.RepositorioProdutoLista;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		Produto produto1 = null;
		Produto produto2 = null;
		
		RepositorioProduto produRep = null;
		FachadaProduto fachada = null;

		String choice = null;
		int contador = 1;
		int start = 4;
		int end = 4;
		
		// Implementar método existir

		int ok = 0;

		System.out.println("Você está entrando no Sistema do Supermercado Pão Doce... \n");
		
		while (start > 1) {
			start = start - 1;
			System.out.print(start + "... ");
			try {
				new Thread().sleep(2000);
			} catch (Exception e) {
				System.out.println("Shit!!");
			}
		}
		
		while (ok == 0) {
			try {
				
				System.out.println("\nBem-vindo ao Sistema do Supermercado Pão Doce!!! "
						+ "\n\nEscolha a forma que deseja armazenar seus dados: "
						+ "\n1. Repositório Array \n2. Repositório Lista \n3. Cancelar e Sair");
				
				choice = in.next();

				if (choice.length() > 1 || (!choice.equals("1") && !choice.equals("2") && !choice.equals("3"))) {
					throw new EntradaInvalidaException();
				} else if (choice.equals("1")) {
					ok++;
					produRep = new RepositorioProdutoArray(contador);
				} else if (choice.equals("2")) {
					ok++;
					produRep = new RepositorioProdutoLista();
				}else if (choice.equals("3")) {
					ok = -1;
					contador = 6;
					System.out.println("Saindo...");
					while (end > 1) {
						end = end - 1;
						System.out.print(end + "... ");
						try {
							new Thread().sleep(2000);
						} catch (Exception e) {
							System.out.println("Shit!!");
						}
					}
					System.out.println("\nBye bye! Até a próxima!");
					
				}

				fachada = new FachadaProduto(produRep);
			} catch (EntradaInvalidaException e) {
				System.out.println(e.getMessage());
			}
		}

		while (contador <= 5) {

			try {
				
				// Mostrando o metodo "CADASTRAR".
				// Duas pessoas diretamente.
				// Um Cliente
				// Um Funcionario
				
				if (contador == 1) {
					produto1 = new Produto ("Oreo", "Comida", 3.60, 000001, fornecedor.getNome);
				    produto2 = new Produto ("Limpol", "Limpeza", 2.10, 000002, fornecedor.getNome);
					
					
					fachada.cadastroProduto(produto1);
					
					fachada.cadastroProduto(produto2); 
					
					
					System.out.println(fachada.imprimirProduto(produto1.getNome()));

					System.out.println(fachada.imprimirProduto(produto2.getNome()));
					  
					
					  
					} 
					
					// Mostrando o metodo "ATUALIZAR". 
				
					else if (contador == 2) {
					  
						System.out.println("\nAtualizando Nome, Tipo e Produto de: " + produto2.getNome() + "\n");
						  
						Produto nProduto = produto2; 
						
						nProduto.setId(000001);
						nProduto.setNome("Biscoito"); 
						nProduto.setTipo("Comida");
						
						fachada.atualizarProduto(nProduto);
						
						System.out.println(fachada.imprimirProduto("nProduto.getId()"));
					  
					} 
					
					// Mostrando o metodo "REMOVER".
					
					else if (contador == 3) { 
						
						String del;
					  
						System.out.println("AVISO!! Você está prestes a apagar uma produto do sistema!");
						
						System.out.println("Excluir todos os dados de: " + produto2.getNome() + "? \n1.Sim  2.Não");
					  
						del = in.next();
						
						if (del.equals("1")) { 
							
							
							//fachada.remover("12345678910"); 
							fachada.removerProduto(produto2.getId()); 
							
							System.out.println("\nDados Excluídos. \n");
							
							System.out.println(fachada.imprimirProduto(produto2.getId())); 
							
						} else {
							
							System.out.println("Você NÃO excluiu os dados referente a: " + produto2.getNome() + "\n");
							System.out.println(fachada.imprimirProduto(produto2.getId())); 
						} 
					}
				
					// Atualizar Funcionário
				
					else if (contador == 4) {
						String atualizar;
						
						if(atualizar.equals("1")) {
						Produto nProduto = (Produto) produto;
						nProduto.setTipo("Comida");
						nProduto.setPreco(12874.99 );
						
						fachada.atualizarProduto(nProduto);
						
						System.out.println(nProduto.getNome() + " acabou de ser atualizado! \n");
						System.out.println(fachada.imprimirPproduto(produto.getId()));
						
						}
						else {
							System.out.println("Atualização cancelada.");
							System.out.println(fachada.imprimirProduto(produto.getId()));
						}
						
					// Atualizar Cliente	
						
					}
				
			} catch (ProdutoJaCadastradoException e) {
				System.out.println(e.getMessage());
			} 
			catch (ProdutoNaoEncontradoException e) {
				System.out.println(e.getMessage());
			} 
			
			finally {
				
				if (ok != -1) {
					System.out.println("Quer continuar? \n1.Sim  2.Não");
				}
				choice = in.next();

				if (choice.equals("1")) {
					contador = contador + 1;
				} else {
					System.out.println("Bye bye! Até a próxima!");
					contador = 6;
				}
			}

		}

	}

}