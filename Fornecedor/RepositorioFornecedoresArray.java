package Fornecedor;

public class RepositorioFornecedoresArray implements RepositorioFornecedores {

	private Fornecedor[] fornecedores;
	private int indice;

	public RepositorioFornecedoresArray(int tam) {
		fornecedores = new Fornecedor[tam];
		indice = 0;
	}

	public void inserir(Fornecedor forn) throws FornecedorNomeJaCadastradoException { // ta apresentando erro
		if (!existir(forn)) {
			fornecedores[indice] = forn;
			indice = indice + 1;
		} else {
			throw new FornecedorNomeJaCadastradoException();
		}
	}

	public void atualizar(Fornecedor forn) throws FornecedorNaoEncontradoException {
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

	public Fornecedor procurar(String cnpj) throws FornecedorNaoEncontradoException { // assinatura do metodo
		for (int i = 0; i < indice; i++) {
			if (this.fornecedores[i].getCnpj().equals(cnpj)) {
				return this.fornecedores[i];
			}
		}
		throw new FornecedorNaoEncontradoException(); // n entendi
	}

	public void remover(Fornecedor forn) throws FornecedorNaoEncontradoException {
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

	public boolean existir(Fornecedor forn) {
		boolean achou = false;
		for (int i = 0; i < indice; i++) {
			if (fornecedores[i].getCnpj().equals(forn.getCnpj())) {
				achou = true;
			}
		}
		return achou;
	}

	private int getIndice(Fornecedor forn) { // ta ok essa logica. OK
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
	 * 
	 * //colocar um alarme aqui de que, se dentro de 30 dia forem feitos 30
	 * solicitações, // após isso gerar um alarme de que não temos mais produtos,
	 * aguardar proximo mes. Nesse caso, o estoque array receberia 30 posições?
	 * 
	 * No main colocaria quando fosse fazer o pedido, um if: ainda tem estoque? -
	 * Não. SOlicitar ao fornecedor? - sim (vai pegar o cpf do funcionario)
	 *
	 * (teria que delimitar quantidade de mes?) if (solicitarForn <= 30) {
	 * System.out.println(estqueFornecedorInicio(cpf funcionario)); solicitarForn++;
	 * } else { System.out.println(estqueFornecedorFim(cpf funcionario)); }
	 * 
	 * 
	 * public String estqueFornecedorInicio(fornecedor forn) { String aviso =
	 * forn.getNome() + " Ainda temos produtos para fornecer."; return aviso; }
	 * 
	 * public String estqueFornecedorFim(fornecedor forn) { String aviso =
	 * forn.getNome() +
	 * " infelizmente os produtos acabaram. Favor fazer nova solicitação próximo mês."
	 * ; return aviso; }
	 * 
	 * 
	 */

}

class DinamicArray {
	private int indice;
	private int size;
	private int array[];
	
	public DinamicArray() {
		this.indice = 0;
		this.size = 10;
		this.array = new int[size];
	}
	
	public void insert(int valor) {
		if (this.indice == this.size) {
			doubleSize();
		}
		
		array[this.indice] = valor;
		indice++;
	}
	
	public void remove(int val) {
		for (int i = 0; i < this.indice; i++) {
			if (this.array[i] == val) {
				for (int j = i; j < this.indice - 1; j++) {
					this.array[j] = this.array[j + 1];
				}
				this.indice--;
				i = this.indice;
			}
		}
	}
	
	public void doubleSize() {
		this.size = (this.size * 2) + 1;
		int auxiliar[] = new int[this.size];
		
		for (int i = 0; i < this.indice; i++) {
			auxiliar[i] = this.array[i];
		}
		
		this.array = auxiliar;
	}
}