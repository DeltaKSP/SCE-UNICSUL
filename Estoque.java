public class Estoque extends Produto {

	private int codigo;
	private String categoria;
	private int quantidade;

	public Estoque(int codigo, String categoria, String entrada, String saida, String nome, float preco, String modelo,
			Fabricante fabricante) {
		super(entrada, saida, nome, preco, modelo, fabricante);
		this.codigo = codigo;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

}
