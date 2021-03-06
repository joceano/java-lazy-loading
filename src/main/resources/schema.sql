DROP TABLE IF EXISTS ITEM;
DROP TABLE IF EXISTS PEDIDO;
DROP TABLE IF EXISTS PEDIDO_ITEM;

CREATE TABLE ITEM (
    ID_ITEM INT AUTO_INCREMENT  PRIMARY KEY,
    DESCRICAO VARCHAR(250),
    UNIDADE VARCHAR(250)
);

CREATE TABLE PEDIDO (
    ID_PEDIDO INT AUTO_INCREMENT  PRIMARY KEY,
    DATA_EMISSAO DATE,
    NUMERO VARCHAR(250)
);

CREATE TABLE PEDIDO_ITEM (
    ID_PEDIDO_ITEM INT AUTO_INCREMENT  PRIMARY KEY,
    ID_PEDIDO INT,
    ID_ITEM INT,
    QUANTIDADE DOUBLE,
    VALOR_UNITARIO DOUBLE,
    VALOR_TOTAL DOUBLE
);