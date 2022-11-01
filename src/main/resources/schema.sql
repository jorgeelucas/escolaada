-- SHOW TABLES;
INSERT INTO disciplina(nome, descricao) VALUES ('Português', 'acentuação e ortografia');
INSERT INTO disciplina(nome, descricao) VALUES ('Matemática', 'Calculo de funções');
INSERT INTO disciplina(nome, descricao) VALUES ('Biologia', 'Cromossomos');
INSERT INTO disciplina(nome, descricao) VALUES ('Geografia', 'Globalização e Países Emergentes');
INSERT INTO disciplina(nome, descricao) VALUES ('História Americana', 'Revolução Americana');
INSERT INTO disciplina(nome, descricao) VALUES ('História Francesa', 'Revolução Francesa');
INSERT INTO disciplina(nome, descricao) VALUES ('História Renascimento', 'Renascimento');
INSERT INTO disciplina(nome, descricao) VALUES ('Literatura', 'Realismo e Naturalismo');
INSERT INTO disciplina(nome, descricao) VALUES ('Química', 'Compostos Orgânicos: Sais Orgânicos, Ésteres, Éteres e Haletos Orgânicos');
INSERT INTO disciplina(nome, descricao) VALUES ('Bioquímica', 'carboidratos, açúcares, glúcides e glicídios');


INSERT INTO aluno(nome) VALUES ('Lorena Lima');
INSERT INTO aluno(nome) VALUES ('Joaquim Melo');
INSERT INTO aluno(nome) VALUES ('Luna Barros');
INSERT INTO aluno(nome) VALUES ('Marcela Caldeira');
INSERT INTO aluno(nome) VALUES ('Heitor Almeida');
INSERT INTO aluno(nome) VALUES ('Vinicius Nunes');
INSERT INTO aluno(nome) VALUES ('Ana Vitória Fogaça');
INSERT INTO aluno(nome) VALUES ('Isis Farias');
INSERT INTO aluno(nome) VALUES ('Rebeca Carvalho');
INSERT INTO aluno(nome) VALUES ('Guilherme Correia');
INSERT INTO aluno(nome) VALUES ('Sr. Vinicius Aragão');
INSERT INTO aluno(nome) VALUES ('Srta. Ana Clara Porto');
INSERT INTO aluno(nome) VALUES ('Alana da Cunha');
INSERT INTO aluno(nome) VALUES ('Ian Teixeira');
INSERT INTO aluno(nome) VALUES ('Pedro Henrique da Mata');
INSERT INTO aluno(nome) VALUES ('Antônio Farias');
INSERT INTO aluno(nome) VALUES ('Thiago Porto');
INSERT INTO aluno(nome) VALUES ('Luiz Miguel Campos');
INSERT INTO aluno(nome) VALUES ('Ian Viana');
INSERT INTO aluno(nome) VALUES ('Beatriz Rodrigues');


-- relacionamentos
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (1, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (1, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (1, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (1, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (1, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (2, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (2, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (3, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (3, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (3, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (3, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (3, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 6);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (4, 7);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (5, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (5, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (5, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (6, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (6, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (6, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (6, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (7, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (8, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (8, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 6);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 7);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (9, 8);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (10, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (12, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (12, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (12, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (12, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (14, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (14, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (15, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (15, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (15, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (15, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (15, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (16, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (16, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (16, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (16, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (16, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (17, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (17, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (17, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (17, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (17, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 5);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 6);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (18, 7);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (19, 1);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (19, 2);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (19, 3);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (19, 4);
INSERT INTO aluno_disciplina(aluno_id, disciplina_id) VALUES (19, 5);