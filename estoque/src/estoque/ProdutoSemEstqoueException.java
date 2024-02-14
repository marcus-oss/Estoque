package estoque;

public class ProdutoSemEstqoueException extends ProdutoException {

    private final int estoqueDisponivel;
    private final int estoqueNecessario;

    public ProdutoSemEstqoueException(String message, int estoqueDisponivel, int estoqueNecessario) {
        super(message);
        this.estoqueDisponivel = estoqueDisponivel;
        this.estoqueNecessario = estoqueNecessario;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }

    public int getEstoqueNecessario() {
        return estoqueNecessario;
    }
}
