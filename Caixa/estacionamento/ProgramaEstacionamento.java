package estacionamento;

import java.util.Scanner;

public class ProgramaEstacionamento {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		Estacionamento estacionamento = null;
		RepositorioEstacionamento repositorioEstacionamento = null;
		Fachada fachada = null;

		String choice = null;
		int contador = 1;

		try {
			System.out.println("Escolha a forma que deseja armazenar os seus dados: \n1. Array \n2. Lista");
			choice = in.next();

			if (choice.length() > 1 || !choice.equals("1") && !choice.equals("2")) {
				throw new VagaSolicitadaNaoExisteException();
			} else if (choice.equals("1")) {
				repositorioEstacionamento = new RepositorioEstacionamentoArray(0);
			} else if (choice.equals("2")) {
				repositorioEstacionamento = new RepositorioEstacionamentoLista();
			}

			fachada = new Fachada(repositorioEstacionamento);
		} catch (VagaSolicitadaNaoExisteException e) {
			System.out.println(e.getMessage());
		}

		do {

			try {
				if (contador == 1) {
					estacionamento = new Estacionamento("50", "Sim", "Normal", "5");
					fachada.cadastrarEstac(estacionamento);
					System.out.println("Numero de Vagas: " + estacionamento.getNumeroVagas());
					System.out.println("Disponiblidade: " + estacionamento.getDisponibilidade());
					System.out.println("Tipo da Vaga: " + estacionamento.getTipoVaga());
					System.out.println("Numero de Andares: " + estacionamento.getNumeroAndares());

				} else {
					System.out.println(estacionamento.getNumeroVagas());
				}
			} catch (VagaSolicitadaNaoExisteException e) {
				System.out.println(e.getMessage());
			} catch (VagaSolicitadaNoutroAndarException e) {
				System.out.println(e.getMessage());
			} catch (VagaSolicitadaOcupadaException e) {
				System.out.println(e.getMessage());
			}

		} while (contador == 0);

	}

}
