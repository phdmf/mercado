package Produto.exception;


public class EntradaInvalidaException extends Exception{
	
	public EntradaInvalidaException() {
	super ("O valor digitado � inv�lido. Escolha 1 para Reposit�rio Array ou 2 para Reposit�rio Lista.");
	}
}