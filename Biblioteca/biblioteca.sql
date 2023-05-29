CREATE DATABASE biblioteca;

USE biblioteca;

CREATE TABLE livros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    editora VARCHAR(100),
    ano_publicacao INT(4),
    num_paginas INT(8),
    genero VARCHAR(50)
);
CREATE TABLE usuário (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    user VARCHAR(100),
    pass VARCHAR(100)
);