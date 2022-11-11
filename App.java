import java.util.Scanner;

public class App {
	public static void main(String[] args) throws Exception {
		int op = 0;
		Scanner leia = new Scanner(System.in);

		Transacoes transacoes = new Transacoes();

		System.out.println(" ___   ___        ___        ___  ___               ___               ___  ___   ___  ___             ");
		System.out.println("|   |=|_.'   .'|=|_.'   .'|=|_.' |   | |`.     .'| |   |   .'|   .'|=|_.' |   |=|_.' |   | |`.     .'|");
		System.out.println("`.  |      .'  |      .'  |  ___ |   | |  `. .'  | |   | .'  | .'  |      `.  |      |   | |  `. .'  |");
		System.out.println("  `.|=|`.  |   |      |   |=|_.' |   | |   | |   | |   | |   | |   |        `.|=|`.  |   | |   | |   |");
		System.out.println(" ___  |  `.`.  |  ___ |   |  ___ `.  | |   | |   | |  .' |   | `.  |  ___  ___  |  `.`.  | |   | |   |");
		System.out.println(" `._|=|___|  `.|=|_.' |___|=|_.'   `.|=|___| |___| |.'   |___|   `.|=|_.'  `._|=|___|  `.|=|___| |___|=|_.' 2.0.1\n\n");

		System.out.println("\t--------- SCE-UNICSUL 2.0.1 ---------");

		System.out.println("\nDIGITE A OPÇÃO DESEJADA:");

		do {
			System.out.println("\n1 - NOVA COMPRA | 2 - NOVA VENDA | 3 - ABRIR BANCO DE DADOS | 4 - SAIR");
			op = leia.nextInt();

			switch (op) {
				case 1:
					transacoes = novaCompra(transacoes);
					break;

				case 2:
					novaVenda(transacoes);
					break;

				case 3:
					imprimir(transacoes);
					break;

				case 4:
					System.out.println("\nObrigado por utilizar o sistema SCE!:");
					break;

				default:
					System.out.println("\nOpção inválida tente novamente!");
					break;
			}

		} while (op != 4);

	}

	public static Transacoes novaCompra(Transacoes transacoes) {

		Estoque p1 = new Estoque(0, null, null, null, null, 0, null, null);

		Fabricante f1 = new Fabricante();

		Scanner leia = new Scanner(System.in);

		System.out.println("Nome do produto:");
		p1.setNome(leia.next());

		System.out.println("Preço do produto:");
		p1.setPreco(leia.nextFloat());

		System.out.println("Modelo do produto:");
		p1.setModelo(leia.next());

		System.out.println("Codigo do produto:");
		p1.setCodigo(leia.nextInt());

		System.out.println("Quantidade do produto:");
		p1.setQuantidade(leia.nextInt());

		System.out.println("Departamento do produto:");
		f1.setDepartamento(leia.next());

		System.out.println("Marca do produto:");
		f1.setMarca(leia.next());

		p1.setFabricante(f1);

		transacoes.novaCompra(p1);

		return transacoes;

	}

	public static void imprimir(Transacoes transacoes) {
		transacoes.imprimeEstoque();
	}

	public static void novaVenda(Transacoes transacoes) {

		Scanner leia = new Scanner(System.in);

		System.out.println("Vendedor:");
		String vendedor = leia.next();

		System.out.println("Código:");
		int codigo = leia.nextInt();

		System.out.println("Produto escolhido:");
		System.out.println("\n"+transacoes.imprimeProduto(codigo));

		System.out.println("\nQuantidade:");
		int quantidade = leia.nextInt();

		System.out.println("\nValor total da compra: "+ transacoes.valorTotalCompra(codigo, quantidade));

		System.out.println("\nValor do pagamento: ");
		float valor = leia.nextFloat();

		transacoes.transacao(quantidade, valor, vendedor, codigo);

	}

}
