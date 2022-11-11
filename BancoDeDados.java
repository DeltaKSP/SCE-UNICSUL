import java.util.ArrayList;

abstract public class BancoDeDados {

	protected ArrayList<Estoque> listaEstoque = new ArrayList<>();

	public void imprimeEstoque() {

		if (this.getQuantidade().size() == 0) {
			System.out.println("\n----------------ESTOQUE VAZIO----------------");
		}

		for (int i = 0; i < this.getQuantidade().size(); i++) {

			System.out.println(
					"\n----------------" + "\nProduto: " + this.listaEstoque.get(i).getModelo() + "\nFabricante: "
							+ this.listaEstoque.get(i).getFabricante().getMarca() + "\nCódigo: "
							+ this.listaEstoque.get(i).getCodigo()  + "\nQuantidade: "
							+ this.listaEstoque.get(i).getQuantidade() + "\n----------------");

		}
	}

	public String imprimeProduto(int codigo) {
		return "Nome: " + this.getProduto(codigo).getModelo() + ", preço: " + this.getProduto(codigo).getPreco()
				+ ", fabricante: "
				+ this.getProduto(codigo).getFabricante().getMarca() + ", qtd em estoque: "
				+ this.getProduto(codigo).getQuantidade();
	}

	public Estoque getProduto(int codigo) {
		int index = -1;
		for (Estoque i : listaEstoque) {
			if (i.getCodigo() == codigo) {
				index = listaEstoque.indexOf(i);
			}
		}
		return listaEstoque.get(index);
	}

	abstract public void adicionaEstoque(Estoque produto);

	abstract public void removeEstoque(int unidades, Estoque produto);

	public int quantidadePorProduto(int codigo) {
		int tamanho = 0;
		for (Estoque i : listaEstoque) {
			if (i.getCodigo() == codigo) {
			 return i.getQuantidade();
			}
		}
		return tamanho;
	}

	public ArrayList<Estoque> getQuantidade() {
		return listaEstoque;
	}

	public void setQuantidade(ArrayList<Estoque> quantidade) {
		this.listaEstoque = quantidade;
	}

}