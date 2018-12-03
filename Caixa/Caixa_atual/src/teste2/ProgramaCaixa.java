package teste2;
import java.util.Scanner;



public class ProgramaCaixa {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws CaixaJaCadastradoException, NumeroCaixaNaoEncontradaException  {

		Scanner in = new Scanner(System.in);

		

		CaixaAbstrata caixa01 = null;
		CaixaAbstrata caixa02 = null;

		RepositorioCaixa repCaixa = null;

		FachadaCaixa fachadaCaixa = null;
		String op1;
		int i = 1;

		try {
			System.out.println("Escolha o tipo de repositório: \n1. Array \n2. Lista");
			op1 = in.nextLine();

			

			if (op1.length() > 1 || !op1.equals("1") && !op1.equals("2")) {
				throw new ValorInvalidoException();
			} else if (op1.equals("1")) {

				
				repCaixa = new RepositorioCaixaArray(30);

			} else if (op1.equals("2")) {

				repCaixa = new RepositorioCaixaLista();
			}

			fachadaCaixa = new FachadaCaixa(repCaixa);
		} catch (ValorInvalidoException e) {
			System.out.println(e.getMessage());//
		}

		do {
			try {
				if (i == 1) {

					caixa01 = new CaixaDinheiro("Preferencial", "Disponivel", "01");

					caixa02 = new CaixaDinheiro("Preferencial", "Disponivel", "02");


					System.out.println(caixa01.getNumeroCaixa());

					fachadaCaixa.cadastroCaixa(caixa01);
					fachadaCaixa.cadastroCaixa(caixa02);


				} else if (i == 2) {
					CaixaAbstrata caixa1 = caixa01; 
					caixa1.setTipo("Comum");
					fachadaCaixa.atualizarCaixa(caixa1);
					System.out.println(caixa01.getTipo());
				} else if (i == 3) {
					CaixaAbstrata caixa1 = caixa01;
					caixa1.setDisponibilidade("Indisponivel");
					fachadaCaixa.atualizarCaixa(caixa1); 
					System.out.println(caixa01.getDisponibilidade());
				} else if (i == 4) {
					fachadaCaixa.removerCaixa(caixa01);
					
				} else if (i == 5) {
					
					
					try {
					fachadaCaixa.procurarCaixa(caixa01.getNumeroCaixa());  
					
							System.out.println("Ainda no repositorio");
					} catch (NumeroCaixaNaoEncontradaException e) {
						System.out.println("removido com sucesso");
					}
					
				}

			} finally {
				System.out.println("Deseja continuar? \n1. Sim \n2. Não");
				op1 = in.nextLine();

				if (op1.equals("1")) {
					i++;
				} else {
					System.out.println("Tchau :3");
					i = 6;
				}
			}
		} while (i <= 5);

		System.out.println("Fim do programa. Tchau :3");

		in.close();
	}
}
