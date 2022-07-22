CREATE TABLE alunos (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200),
    matricula INTEGER,
    turma VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY matricula (matricula)
);
CREATE TABLE cartao (
    id INT NOT NULL AUTO_INCREMENT,
    card_number BIGINT,
    limite DECIMAL(19, 2),
    senha VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    cancel_date  TIMESTAMP,
    expired_date TIMESTAMP NOT NULL,
    alunos_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (alunos_id) REFERENCES alunos (id),
    UNIQUE KEY card_number (card_number)
);

CREATE TABLE transacoes (
    id INT NOT NULL AUTO_INCREMENT,
    created_date TIMESTAMP NOT NULL,
    valor decimal(19, 2),
    cartao_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (cartao_id) REFERENCES cartao (id)
);