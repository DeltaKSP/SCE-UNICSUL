public class Transacoes extends BancoDeDados {

	public void adicionaEstoque(Estoque produto) {
			super.listaEstoque.add(produto);
	}

	public void removeEstoque(int unidades, Estoque produto) {
		produto.setQuantidade(produto.getQuantidade() - unidades);
	}

	public void novaCompra(Estoque produto) {
		this.adicionaEstoque(produto);
		System.out.println("----------------");
		System.out.println("COMPRA REALIZADA");
		System.out.println("Nome do produto: " + produto.getNome());
		System.out.println("Codigo do produto: " + produto.getCodigo());
		System.out.println("----------------");
	}

	public float valorTotalCompra(int codigo, int quantidade){
		return super.getProduto(codigo).getPreco() * quantidade;
	}

	public void novaVenda(int unidades, float valor, String vendedor, Estoque produto) {
		this.removeEstoque(unidades, produto);
		System.out.println("----------------");
		System.out.println("VENDA REALIZADA");
		System.out.println("Nome do produto: " + produto.getNome());
		System.out.println("Valor total da compra: " + valor);
		System.out.println("----------------");
	}

	public void novaVenda(String mensagem) {
		System.out.println("----------------");
		System.out.println("VENDA NÃO AUTORIZADA");
		System.out.println("MOTIVO: " + mensagem);
		System.out.println("----------------");
	}

	public void transacao(int unidades, float valor, String vendedor, int codigo ) {
		if (super.quantidadePorProduto(codigo) > 0 && super.quantidadePorProduto(codigo) >= unidades) {
			Estoque produto = super.getProduto(codigo);
			if (valor >= (produto.getPreco() * unidades)) {
				this.novaVenda(unidades, (produto.getPreco() * unidades), vendedor, super.getProduto(codigo));
			} else {
				this.novaVenda("SALDO INSUFICIENTE");
			}
		}

		else {
			this.novaVenda("SALDO EM ESTOQUE INSUFICIENTE");
		}
	}
}