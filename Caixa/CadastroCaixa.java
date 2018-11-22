package negocio_dados;
import dados.*;
import negocio.*;
import excecoes.*;
import basicas.*;

public class CadastroCaixa {
	private RepositorioCaixa caixa;
	
	public CadastroCaixa(char t) {
		if (t == 'a' || t == 'A') {
			this.caixa = new RepositorioCaixaArray();
		} else {
			this.caixa = new RepositorioCaixaLista();
		}
	}

	public void cadastrar(CaixaAbstrata caixa) throws CaixaJaCadastradoException {
		if (!(caixa.existe(caixa.getNumeroCaixa()))) {
			caixa.inserir(caixa);
		} else {
			throw new CaixaJaCadastradoException();
		}
	}
	
	public CaixaAbstrata procurar(String numeroCaixa) throws NumeroCaixaNaoEncontradaException {
		return caixa.procurar(numeroCaixa);
	}
	public void atualizar (CaixaAbstrata caixa) throws NumeroCaixaNaoEncontradaException {
		caixa.remover(numeroCaixa);
	}	
	
}
