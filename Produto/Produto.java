

public class Produto {
    private String nome ;
    private String tipo ;
    private double preco ;
    private double id ;
    private Mercado mercado ;
   
    public Produto(String nome, String tipo, double preco, double id, Mercado mercado) {
        this.nome = nome ;
        this.tipo = tipo ;
        this.preco = preco ;
        this.id = id ;
        this.Mercado = Mercado ;
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
   
   
    public double getId() {
        return this.id ;
    }
   
    public void setId(double id) {
        this.id = id ;
    }
   
    public int getEstoque() {
        return this.mercado.getEstoque() ;
    }
       
    public String getMercado() {
        return this.mercado.getLocal() ;
    }
   
}