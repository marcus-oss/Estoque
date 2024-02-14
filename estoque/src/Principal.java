import estoque.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Produto produto = new Produto("Mi band");
        produto.adicionar(12);
        produto.ativar();


        Comprar(produto);

//        System.out.printf("Estoque: %d%n", produto.getQuantidadeEstoque());

    }

    private static void Comprar(Produto produto) {
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();


                efetuarBaixaEstoque(produto, quantidade);
                System.out.println("Compra realizada com sucesso");
                break;

            } catch (BaixaEstoqueException e) {
//                e.printStackTrace(System.out);
                e.printStackTrace();
                System.out.println("Erro na compra tente novamente " + e.getCause().getMessage());

            }

        } while (true);
    }

    private static void efetuarBaixaEstoque(Produto produto, int quantidade) throws BaixaEstoqueException {
        try {
            produto.retirarEstoque(quantidade);
            System.out.printf("%d unidades retiradas no estoque. Estoque atual: %d%n",
                    quantidade, produto.getQuantidadeEstoque());

        } catch (IllegalArgumentException | ProdutoException e) {
            throw new BaixaEstoqueException("Não pode realizar baixa no estoque ", e);

        }

    }

}