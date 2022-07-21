CREATE TABLE ALUNOS (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(200),
    matricula INTEGER,
    turma VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY matricula (matricula)
);
CREATE TABLE CARTAO (
    id INT NOT NULL AUTO_INCREMENT,
    card_number BIGINT,
    limite DECIMAL(19, 2),
    senha VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    cancel_date  TIMESTAMP,
    expired_date TIMESTAMP NOT NULL,
    alunos_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (alunos_id) REFERENCES ALUNOS (id),
    UNIQUE KEY card_number (card_number)
);

CREATE TABLE TRANSACOES (
    id INT NOT NULL AUTO_INCREMENT,
    created_date TIMESTAMP NOT NULL,
    valor decimal(19, 2),
    PRIMARY KEY (id),
    cartao_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (cartao_id) REFERENCES CARTAO (id)
);

-- ALTER TABLE TB_ALUNOS
--     ADD PRIMARY KEY (id);

-- ALTER TABLE TB_CARTAO
--     ADD PRIMARY KEY (id);

-- ALTER TABLE TB_CARTAO
--     ADD CONSTRAINT pk_alunos FOREIGN KEY (alunos_id) REFERENCES TB_ALUNOS (id);

-- ALTER TABLE TB_ALUNOS
-- ADD CONSTRAINT tb_alunos_id_constraint FOREIGN KEY (id) REFERENCES TB_CARTAO(id);

-- ALTER TABLE TB_CARTAO
-- ADD CONSTRAINT tb_cartao_id_constraint FOREIGN KEY (id) REFERENCES TB_ALUNOS(id);