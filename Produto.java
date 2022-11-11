abstract class Produto {

	private String nome;
	private float preco;
	private String modelo;
	private Fabricante fabricante;

	public Produto(String entrada, String saida, String nome, float preco, String modelo, Fabricante fabricante) {
		this.nome = nome;
		this.preco = preco;
		this.modelo = modelo;
		this.fabricante = fabricante;
	}

	public String getNome() {
		return nome;
	}

	public float getPreco() {
		return preco;
	}

	public String getModelo() {
		return modelo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

}
