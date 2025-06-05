package View;

import DAO.CategoriaDAO;
import Model.Categoria;

import java.util.List;

public class CategoriaView {
    private CategoriaDAO categoriaDAO;

    public CategoriaView() {
        categoriaDAO = new CategoriaDAO();
    }

    public void cadastrarCategoria(Categoria categoria) {
        categoriaDAO.inserir(categoria);
    }

    public String listarCategorias() {
        List<Categoria> categorias = categoriaDAO.listar();
        StringBuilder sb = new StringBuilder();
        for (Categoria categoria : categorias) {
            sb.append("ID: ").append(categoria.getId())
                    .append(", Nome: ").append(categoria.getNome())
                    .append("\n");
        }
        return sb.toString();
    }
}
