CREATE TABLE alunos (
    matricula INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(200),
    turma VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP,
    PRIMARY KEY (matricula)
);
CREATE TABLE cartao (
    cartao BIGINT NOT NULL,
    limite DECIMAL(19, 2),
    senha VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    cancel_date  TIMESTAMP,
    expired_date TIMESTAMP NOT NULL,
    alunos_id INT,
    PRIMARY KEY (cartao),
    FOREIGN KEY (alunos_id) REFERENCES alunos (matricula)
);

CREATE TABLE transacoes (
    id INT NOT NULL AUTO_INCREMENT,
    created_date TIMESTAMP NOT NULL,
    valor decimal(19, 2),
    cartao_id BIGINT,
    PRIMARY KEY (id),
    FOREIGN KEY (cartao_id) REFERENCES cartao (cartao)
);
