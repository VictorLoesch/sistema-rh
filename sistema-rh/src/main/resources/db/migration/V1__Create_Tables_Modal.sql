CREATE TABLE Usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    imagem TEXT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    senha VARCHAR(255) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    salario DECIMAL(8, 2) NOT NULL,
    CPF VARCHAR(14),
    RG VARCHAR(255) NOT NULL,
    dataNascimento DATE,
    dataContratacao DATE,
    cargo_id BIGINT,
    endereco VARCHAR(250),
    departamento_id BIGINT
);


CREATE TABLE Cargo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE,
    descricao VARCHAR(200)
);

CREATE TABLE Departamento (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    responsavel_id BIGINT,
    FOREIGN KEY (responsavel_id) REFERENCES Usuario(id)
);

ALTER TABLE Usuario
ADD CONSTRAINT FK_Cargo FOREIGN KEY (cargo_id) REFERENCES Cargo(id);

ALTER TABLE Usuario
ADD CONSTRAINT FK_Departamento FOREIGN KEY (departamento_id) REFERENCES Departamento(id);




