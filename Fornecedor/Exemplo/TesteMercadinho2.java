package Mercadinho.Exemplo;


import java.util.Scanner;

import Mercadinho.Sointerfaces.RepositorioCaixa;
import Mercadinho.Sointerfaces.RepositorioFornecedores;
import Mercadinho.Sointerfaces.RepositorioPessoas;
import Mercadinho.Sointerfaces.RepositorioProduto;
import Mercadinho.basic.*;
import Mercadinho.exception.ValorInvalidoException;
import Mercadinho.exception.ValorJaCadastradoException;
import Mercadinho.repositorio.RepositorioCaixaArray;
import Mercadinho.repositorio.RepositorioCaixaLista;
import Mercadinho.repositorio.RepositorioFornecedorLista;
import Mercadinho.repositorio.RepositorioFornecedoresArray;
import Mercadinho.repositorio.RepositorioPessoasArray;
import Mercadinho.repositorio.RepositorioPessoasLista;
import Mercadinho.repositorio.RepositorioProdutoArray;
import Mercadinho.repositorio.RepositorioProdutoLista;

public class TesteMercadinho2 {
	
		public static void main(String[] args) { 

			Scanner in = new Scanner(System.in); 
			
			//declaração de todas as classes inicializando-as 
			
			CaixaAbstrata CaixaCartao = null, CaixaDinheiro = null;
			Fornecedor fornecedor = null;
			Pessoa cliente = null, funcionario = null;
			Produto tipoProduto = null; 

			RepositorioCaixa repCaixa = null;
			RepositorioFornecedores repFornecedor = null;
			RepositorioPessoas repPesssoas = null;
			RepositorioProduto repProdutos = null; 
			
			FachadaMercadinho fachadaMercadinho = null;
			String op1;
			int i = 1;
			
			try {
				System.out.println("Escolha o tipo de repositório: \n1. Array \n2. Lista"); // retirar arquivo
				op1 = in.nextLine();
				
				// (aqui diz que se opção 1 for maior que 1 caractere, ou diferente do numero 1,2 ou 3, dará um erro.) 
				
				if(op1.length() > 1 || !op1.equals("1") && !op1.equals("2")) { 
					throw new ValorInvalidoException();
				} else if(op1.equals("1")) {
					
					//declarar o tamanho do array entre os parenteses. 
					repCaixa = new RepositorioCaixaArray(100);
					repFornecedor = new RepositorioFornecedoresArray(100);
					repPesssoas = new RepositorioPessoasArray(100);
					repProdutos = new RepositorioProdutoArray(100);
					
					
				} else if(op1.equals("2")) {
					repCaixa = new RepositorioCaixaLista();
					repFornecedor = new RepositorioFornecedorLista();
					repPesssoas = new RepositorioPessoasLista();
					repProdutos = new RepositorioProdutoLista();
				} 
				
			fachadaMercadinho = new FachadaMercadinho(repCaixa, repFornecedor, repPesssoas, repProdutos); 
			} catch (ValorInvalidoException e) {
				System.out.println(e.getMessage());
			} catch (RepositorioException e) {
				System.out.println(e.getMessage());
			}
			
			do {
				try {			
						if (i == 1) {
							//aqui vai ser os cadastros dos produtos, todos os atributos
							
							//Dia[] dia = {Dia.SEGUNDAFEIRA, Dia.TERCAFEIRA, Dia.QUINTAFEIRA};
								
							//String endereco = new Endereco("Av. Jorn. Anibal Fernandes", 2220, "CIn", "50740560", "Cidade Universitária", "Recife", Estado.PERNAMBUCO, "Brasil");
														
							cliente = new Cliente("Miriane Silva", "95416325789", "mstn@cin.ufpe.br", "123456", "8185468232", "F");
							funcionario = new Funcionario("Lucas Alves", "54632598712", "lar@cin.ufpe.br", "36259", "8195632792", 'M', dataF, endereco, 800.72, Cargo.GERENTE, 40.0);
															
							Fornecedor marilan = new Fornecedor("123.456.789", "Marilan", "Biscoitos e Massas", "Marilia, São Paulo, SP", "Biscoito Maisena", "11 987654321");

							CaixaCartao = null, 
							CaixaDinheiro = null;
							fornecedor = null;
							tipoProduto = null; 
							
							//aqui ja vai ser o cadastro dos objetos instanciados
							
							System.out.println(cliente.getCpf());
							
							FachadaMercadinho.CadastroPessoas(cliente);
							FachadaMercadinho.CadastroPessoas(funcionario);
							FachadaMercadinho.cadastrarCaixa(CaixaCartao);
							FachadaMercadinho.cadastrarCaixa(CaixaDinheiro);
							FachadaMercadinho.cadastrarFornecedor(Fornecedor);
							FachadaMercadinho.cadastrarProduto(tipoProduto); 
							
							//aqui vai atualizar os dados ja setados anteriormente
						} else if (i == 2) {
							Pessoa cliente1 = cliente.clone(); // aqui clona ? 
							cliente1.setTelefone("81 94459-7855");
							FachadaMercadinho.atualizarPessoa(cliente1);
						} else if (i == 3) {
							Produto fornecedor1 = fornecedor.clone();
							fornecedor1.setramoDeAtuacao("Massas");
							FachadaMercadinho.atualizarProduto(fornecedor1);	
						} else if (i == 4) {
							Servico tipoProduto1 = tipoProduto.clone();
							tipoProduto1.setPreco(3.80);
							FachadaMercadinho.atualizarServico(tipoProduto1);
						} else if (i == 5) {
							Pessoa funcionario1 = funcionario.clone();
							funcionario1.setEndereco(null); 
						} 
						//Cadastrar novamente
						else if(i == 6) {
							FachadaMercadinho.cadastrarPessoa(cliente);
//							FachadaMercadinho.cadastrarProduto(ebook);
//							FachadaMercadinho.cadastrarServico(palestra);
						} 
						
						// aqui já é a parte que procura atributos dos objetos 
						else if(i == 7) {
							System.out.println(FachadaMercadinho.procurarPessoa("124097621").getDesconto());
							System.out.println(FachadaMercadinho.procurarProduto("09875mbiuo").getAutor());
							System.out.println(FachadaMercadinho.procurarServico("123,09876").getVagasOcupadas());
						} 
						
						//Apagar os itens 
						else if(i == 8) {
							fachada.removerPessoa("54632598712");
							fachada.removerProduto("1256327541230");
							fachada.removerServico("125125128");
							fachada.removerPessoa("54632598712");
						} 
						
						// venda dos produtos (codigo e quantidade) 
						else if(i == 9) {
							fachada.comprar("95416325789", "1256327541225", 15);
							fachada.comprar("96574232597", "1256327541227", 7);	
							fachada.comprar("95416325789", "1256327541225", 150);
						} 
						
						// procurar produto por codigo 
						else if(i == 10) {
							System.out.println(fachada.procurarProduto("1256327541225").getTitulo());
							System.out.println(fachada.procurarPessoa("95416325789").getEmail());
							System.out.println(fachada.procurarServico("125125125").getVagas());
						}
				} catch (ValorInvalidoException e) {
					System.out.println(e.getMessage());
				} catch (RepositorioException e) {
					System.out.println(e.getMessage());
				} catch (ValorJaCadastradoException e) {
					System.out.println(e.getMessage());
				} catch (ValorNaoEncontradoException e) {
					System.out.println(e.getMessage());
				} catch (QuantidadeIndisponivelException e) {
					System.out.println(e.getMessage());
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
			} while(i <= 10);
			
			System.out.println("Tchau :3");
			
			in.close();
		}
	}


