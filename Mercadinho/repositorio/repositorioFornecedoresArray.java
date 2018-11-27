package Mercadinho.repositorio;

import Excessoes.FornecedorDadosIncompletosException;
import Excessoes.FornecedorInexistenteConsultaException;
import Excessoes.FornecedorNaoEncontradoException;
import Excessoes.FornecedorNomeJaCadastradoException;
import negocio.repositorioFornecedores;

public class repositorioFornecedoresArray implements repositorioFornecedores {

	private fornecedor[] fornecedores;
	private int indice;

	public repositorioFornecedoresArray(int tam) {
		fornecedores = new fornecedor[tam];
		indice = 0;
	}

	public void inserir(fornecedor forn) throws FornecedorNomeJaCadastradoException { // ta apresentando erro
		if (!existir(forn)) {
			fornecedores[indice] = forn;
			indice = indice + 1;
		} else {
			throw new FornecedorNomeJaCadastradoException();
		}
	}

	// Classes com Letra maiuscula ***************

	public void atualizar(fornecedor forn) throws FornecedorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
				fornecedores[i] = forn;
				achou = true;
			}
		}
		if (!achou) {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException { // assinatura do metodo
		for (int i = 0; i < indice; i++) {
			if (this.fornecedores[i].getCnpj().equals(cnpj)) {
				return this.fornecedores[i];
			}
		}
		throw new FornecedorNaoEncontradoException(); // n entendi
	}

	public void remover(fornecedor forn) throws FornecedorNaoEncontradoException {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
				achou = true;
				fornecedores[i] = null;
				int j = i;
				for (i = j; i < indice; i++) {
					if (i != indice - 1) {
						fornecedores[i] = fornecedores[i + 1];
					} else {
						fornecedores[i] = null;
						indice--;
					}
				}
			}
		}
		if (!achou) {
			throw new FornecedorNaoEncontradoException();
		}
	}

	public boolean existir(fornecedor forn) {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
				achou = true;
			}
		}
		return achou;
	}

	private int getIndice(fornecedor forn) { // ta ok essa logica. OK
		String n;
		boolean achou = false;
		int i = 0;
		while ((!achou) && (i < this.indice)) {
			n = fornecedores[i].getCnpj();
			if (n.equals(forn.getCnpj())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i; 
	}
	
	/*
	
	//colocar um alarme aqui de que, se dentro de 30 dia forem feitos 30 solicitações,
	// após isso gerar um alarme de que não temos mais produtos, aguardar proximo mes. 
	 * Nesse caso, o estoque array receberia 30 posições? 
	 * 
	 * No main colocaria quando fosse fazer o pedido, um if: 
	 * ainda tem estoque? - Não.
	 *SOlicitar ao fornecedor? - sim 
	 *(vai pegar o cpf do funcionario)
	 *
	 *(teria que delimitar quantidade de mes?)
	 *if (solicitarForn <= 30) {
	 *System.out.println(estqueFornecedorInicio(cpf funcionario));
	 *solicitarForn++;
	 *} else {
	 *System.out.println(estqueFornecedorFim(cpf funcionario));
	 *}
	
	
		public String estqueFornecedorInicio(fornecedor forn) {
		String aviso = forn.getNome() + " Ainda temos produtos para fornecer.";
		return aviso;
	}

	public String estqueFornecedorFim(fornecedor forn) {
		String aviso = forn.getNome() + " infelizmente os produtos acabaram. Favor fazer nova solicitação próximo mês.";
		return aviso;
	}
	
	
	
	
	
	
	*/
	
}
