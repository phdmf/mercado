package Produto.basic;

import Mercadinho.basic.Fornecedor;

public class Produto {
    private String nome ;
    private String tipo ;
    private double preco ;
    private int id ;
   private Fornecedor fornecedor;
   
    public Produto(String nome, String tipo, double preco, int id, Fornecedor fornecedor) {
        this.nome = nome ;
        this.tipo = tipo ;
        this.preco = preco ;
        this.id = id ;
        this.fornecedor = fornecedor;
      //  this.Mercado = Mercado ;
    }
   
    public String getNome() {
        return this.nome ;
    }
   
    public void setNome(String nome) {
        this.nome = nome ;
    }
   
    public String getTipo() {
        return this.tipo ;
    }
   
    public void setTipo(String tipo) {
        this.tipo = tipo ;
    }
   
    public double getPreco() {
        return this.preco ;
    }
   
    public void setPreco(double preco) {
        this.preco = preco ;
    }
   
   
    public int getId() {
        return this.id ;
    }
   
    public void setId(int id) {
        this.id = id ;
    }

	
	
   
}