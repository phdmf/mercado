package Fornecedores;

public class fornecedor {
	
	private String cnpj; 
	private String nomeFantasia; 
	private String ramoDeAtuacao;  
	private String endereco;
	private String tipoDeProduto; 
	private String telefone; 
	
	
	public fornecedor(String cnpj, String nomeFantasia, String ramoDeAtuacao, String endereco, String tipoDeProduto,
			String telefone) {
		super();
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
		this.ramoDeAtuacao = ramoDeAtuacao;
		this.endereco = endereco;
		this.tipoDeProduto = tipoDeProduto;
		this.telefone = telefone;
	} 


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getRamoDeAtuacao() {
		return ramoDeAtuacao;
	}


	public void setRamoDeAtuacao(String ramoDeAtuacao) {
		this.ramoDeAtuacao = ramoDeAtuacao;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getTipoDeProduto() {
		return tipoDeProduto;
	}


	public void setTipoDeProduto(String tipoDeProduto) {
		this.tipoDeProduto = tipoDeProduto;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
		
	
	

}
