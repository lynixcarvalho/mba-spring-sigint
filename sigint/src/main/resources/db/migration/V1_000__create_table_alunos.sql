CREATE TABLE TB_ALUNOS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200),
    matricula INTEGER,
    turma VARCHAR(200),
    created_date TIMESTAMP NOT NULL,
    modified_date TIMESTAMP
);