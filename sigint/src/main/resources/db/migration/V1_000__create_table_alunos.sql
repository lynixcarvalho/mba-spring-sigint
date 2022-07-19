CREATE TABLE TB_ALUNOS (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200),
    matricula INTEGER,
    turma VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP,
    PRIMARY KEY(id)
);
CREATE TABLE TB_CARTAO (
    id INT NOT NULL AUTO_INCREMENT,
    card_number BIGINT,
    limite decimal(19, 2),
    senha VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    PRIMARY KEY(id)
);
CREATE TABLE TB_TRANSACOES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    created_date TIMESTAMP NOT NULL,
    valor decimal(19, 2)
);

-- ALTER TABLE TB_ALUNOS
-- ADD CONSTRAINT tb_alunos_id_constraint FOREIGN KEY (id) REFERENCES TB_CARTAO(id);

-- ALTER TABLE TB_CARTAO
-- ADD CONSTRAINT tb_cartao_id_constraint FOREIGN KEY (id) REFERENCES TB_ALUNOS(id);