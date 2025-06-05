package View;

import DAO.ProdutoDAO;
import Model.Produto;

import java.util.List;

public class ProdutoView {
    private ProdutoDAO produtoDAO;

    public ProdutoView() {
        produtoDAO = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) {
        produtoDAO.inserir(produto);
    }

    public String listarProdutos() {
        List<Produto> produtos = produtoDAO.listar();
        StringBuilder sb = new StringBuilder();
        for (Produto produto : produtos) {
            sb.append("ID: ").append(produto.getId())
                    .append(", Nome: ").append(produto.getNome())
                    .append(", Preço: ").append(produto.getPrecoUnitario())
                    .append("\n");
        }
        return sb.toString();
    }
}
