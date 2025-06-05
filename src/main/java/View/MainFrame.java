package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Categoria;
import Model.Produto;

public class MainFrame extends JFrame {
    private ProdutoView produtoView;
    private CategoriaView categoriaView;

    public MainFrame() {
        produtoView = new ProdutoView();
        categoriaView = new CategoriaView();

        setTitle("Controle de Estoque");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Aba de Produtos
        JPanel produtoPanel = new JPanel();
        produtoPanel.setLayout(new BorderLayout());

        JTextArea produtoTextArea = new JTextArea();
        produtoTextArea.setEditable(false);
        produtoPanel.add(new JScrollPane(produtoTextArea), BorderLayout.CENTER);

        JPanel produtoForm = new JPanel();
        produtoForm.setLayout(new GridLayout(7, 1));

        JTextField nomeField = new JTextField();
        JTextField precoField = new JTextField();
        JTextField unidadeField = new JTextField();
        JTextField quantidadeEstoqueField = new JTextField();
        JTextField quantidadeMinimaField = new JTextField();
        JTextField quantidadeMaximaField = new JTextField();
        JTextField categoriaField = new JTextField();

        produtoForm.add(new JLabel("Nome:"));
        produtoForm.add(nomeField);
        produtoForm.add(new JLabel("Preço Unitário:"));
        produtoForm.add(precoField);
        produtoForm.add(new JLabel("Unidade:"));
        produtoForm.add(unidadeField);
        produtoForm.add(new JLabel("Quantidade em Estoque:"));
        produtoForm.add(quantidadeEstoqueField);
        produtoForm.add(new JLabel("Quantidade Mínima:"));
        produtoForm.add(quantidadeMinimaField);
        produtoForm.add(new JLabel("Quantidade Máxima:"));
        produtoForm.add(quantidadeMaximaField);
        produtoForm.add(new JLabel("Categoria:"));
        produtoForm.add(categoriaField);

        JButton cadastrarProdutoButton = new JButton("Cadastrar Produto");
        cadastrarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Produto produto = new Produto();
                produto.setNome(nomeField.getText());
                produto.setPrecoUnitario(Double.parseDouble(precoField.getText()));
                produto.setUnidade(unidadeField.getText());
                produto.setQuantidadeEstoque(Integer.parseInt(quantidadeEstoqueField.getText()));
                produto.setQuantidadeMinima(Integer.parseInt(quantidadeMinimaField.getText()));
                produto.setQuantidadeMaxima(Integer.parseInt(quantidadeMaximaField.getText()));
                produto.setCategoria(categoriaField.getText());
                produtoView.cadastrarProduto(produto);
                produtoTextArea.setText(produtoView.listarProdutos());
                clearProdutoFields(nomeField, precoField, unidadeField, quantidadeEstoqueField, quantidadeMinimaField, quantidadeMaximaField, categoriaField);
            }
        });

        produtoPanel.add(produtoForm, BorderLayout.NORTH);
        produtoPanel.add(cadastrarProdutoButton, BorderLayout.SOUTH);
        tabbedPane.addTab("Produtos", produtoPanel);

        // Aba de Categorias
        JPanel categoriaPanel = new JPanel();
        categoriaPanel.setLayout(new BorderLayout());

        JTextArea categoriaTextArea = new JTextArea();
        categoriaTextArea.setEditable(false);
        categoriaPanel.add(new JScrollPane(categoriaTextArea), BorderLayout.CENTER);

        JPanel categoriaForm = new JPanel();
        categoriaForm.setLayout(new GridLayout(4, 1));

        JTextField nomeCategoriaField = new JTextField();
        JTextField tamanhoField = new JTextField();
        JTextField embalagemField = new JTextField();

        categoriaForm.add(new JLabel("Nome:"));
        categoriaForm.add(nomeCategoriaField);
        categoriaForm.add(new JLabel("Tamanho:"));
        categoriaForm.add(tamanhoField);
        categoriaForm.add(new JLabel("Embalagem:"));
        categoriaForm.add(embalagemField);

        JButton cadastrarCategoriaButton = new JButton("Cadastrar Categoria");
        cadastrarCategoriaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Categoria categoria = new Categoria();
                categoria.setNome(nomeCategoriaField.getText());
                categoria.setTamanho(tamanhoField.getText());
                categoria.setEmbalagem(embalagemField.getText());
                categoriaView.cadastrarCategoria(categoria);
                categoriaTextArea.setText(categoriaView.listarCategorias());
                clearCategoriaFields(nomeCategoriaField, tamanhoField, embalagemField);
            }
        });

        categoriaPanel.add(categoriaForm, BorderLayout.NORTH);
        categoriaPanel.add(cadastrarCategoriaButton, BorderLayout.SOUTH);
        tabbedPane.addTab("Categorias", categoriaPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    private void clearProdutoFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    private void clearCategoriaFields(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
