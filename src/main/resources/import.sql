INSERT INTO tb_usuario(nome, email, telefone, data_nasc, endereco, password) VALUES ('Joao Miguel', 'joaom@gmal.com', '999999998','2000-07-05', 'Rua Laranjeiras, 284', '$2a$10$LegVmZxeQSTmnq9zJmh.LeKU9zY4NWI5twa7cOQxe0yGEiwt1.7d6');
INSERT INTO tb_usuario(nome, email, telefone, data_nasc, endereco, password) VALUES ('Maria Carla', 'mariac@gmal.com', '999999997','1999-08-21', 'Rua Amaral, 573', '$2a$10$LegVmZxeQSTmnq9zJmh.LeKU9zY4NWI5twa7cOQxe0yGEiwt1.7d6');
INSERT INTO tb_usuario(nome, email, telefone, data_nasc, endereco, password) VALUES ('Bruna Dutra', 'brunac@gmal.com', '999999996','2001-09-26', 'Av. Tomate, 05', '$2a$10$LegVmZxeQSTmnq9zJmh.LeKU9zY4NWI5twa7cOQxe0yGEiwt1.7d6');
INSERT INTO tb_usuario(nome, email, telefone, data_nasc, endereco, password) VALUES ('Leonardo Cabral', 'leonardo@gmal.com', '999999995','2003-04-21', 'Av. Brasil, 300', '$2a$10$LegVmZxeQSTmnq9zJmh.LeKU9zY4NWI5twa7cOQxe0yGEiwt1.7d6');
INSERT INTO tb_usuario(nome, email, telefone, data_nasc, endereco, password) VALUES ('Lara Croft', 'lara@gmal.com', '999999991','1987-08-13', 'Rua das Tulipas, 84', '$2a$10$LegVmZxeQSTmnq9zJmh.LeKU9zY4NWI5twa7cOQxe0yGEiwt1.7d6');

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (1, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (2, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (3, 2);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (3, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (4, 1);
INSERT INTO tb_usuario_role (usuario_id, role_id) VALUES (5, 1);

INSERT INTO tb_automovel(numero_placa, cor, ano, tipo_combustivel, numero_portas, marca, status) VALUES ('AJF2H52', 'azul', '2023', 'flex', 4, 'TOYOTA', 1);
INSERT INTO tb_automovel(numero_placa, cor, ano, tipo_combustivel, numero_portas, marca, status) VALUES ('BDM6C47', 'prata', '2024', 'flex', 4, 'FIAT', 1);
INSERT INTO tb_automovel(numero_placa, cor, ano, tipo_combustivel, numero_portas, marca, status) VALUES ('GTR8C96', 'branco', '2022', 'gasolina', 2, 'FORD', 1);
INSERT INTO tb_automovel(numero_placa, cor, ano, tipo_combustivel, numero_portas, marca, status) VALUES ('UCV5P28', 'preto', '2023', 'flex', 4, 'CITROEN', 1);
INSERT INTO tb_automovel(numero_placa, cor, ano, tipo_combustivel, numero_portas, marca, status) VALUES ('TFQ8H61', 'vermelho', '2022', 'gasolina', 4, 'CHEVROLET', 0);
INSERT INTO tb_automovel(numero_placa, cor, ano, tipo_combustivel, numero_portas, marca, status) VALUES ('UPQ3J45', 'prata', '2020', 'diesel', 4, 'HONDA', 0);

INSERT INTO tb_locacao(data_locacao, data_devolucao, valor_locacao, usuario_id, automovel_id) VALUES ('2024-01-03', '2024-01-03', 1500.0, 1, 3);
INSERT INTO tb_locacao(data_locacao, data_devolucao, valor_locacao, usuario_id, automovel_id) VALUES ('2023-12-30', '2024-02-15', 3000.0, 2, 1);
INSERT INTO tb_locacao(data_locacao, data_devolucao, valor_locacao, usuario_id, automovel_id) VALUES ('2023-10-02', '2023-11-15', 2580.0, 3, 4);
INSERT INTO tb_locacao(data_locacao, data_devolucao, valor_locacao, usuario_id, automovel_id) VALUES ('2024-01-02', '2024-02-07', 1500.0, 4, 2);

