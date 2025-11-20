-- V1_criar_tabela_evento.sql

CREATE TYPE tipo_evento AS ENUM (
    'WORKSHOP',
    'PALESTRA',
    'MUSICA',
    'SEMINARIO'
);

CREATE TABLE tb_evento (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    identificador VARCHAR(255) NOT NULL UNIQUE,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    local_evento VARCHAR(255) NOT NULL,
    capacidade INTEGER NOT NULL,
    organizador VARCHAR(255) NOT NULL,
    tipoEvento tipo_evento NOT NULL

);