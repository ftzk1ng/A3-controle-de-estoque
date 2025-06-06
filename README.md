BANCO DE DADOS - NECESSÁRIO CRIAR LOCALMENTE 

CREATE DATABASE IF NOT EXISTS db_estoque;

USE db_estoque;

DROP TABLE IF EXISTS tb_produtos;
CREATE TABLE tb_produtos (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    preco_unitario DECIMAL(10, 2),
    unidade VARCHAR(50),
    quantidade_estoque INTEGER,
    quantidade_minima INTEGER,
    quantidade_maxima INTEGER,
    categoria VARCHAR(50),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS tb_categorias;
CREATE TABLE tb_categorias (
    id INTEGER NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100),
    tamanho ENUM('Pequeno', 'Médio', 'Grande'),
    embalagem ENUM('Lata', 'Vidro', 'Plástico'),
    PRIMARY KEY(id)
);
