-- Adicionando a role ROLE_USER
INSERT INTO roles (name) VALUES ('ROLE_USER');

-- Adicionando a role ROLE_ADMIN
INSERT INTO roles (name) VALUES ('ROLE_ADMIN');

-- Inserir dados de exemplo para a tabela de usuários
INSERT INTO tb_cliente (name, email, username, password, address) VALUES ('Usuário Teste', 'teste@example.com', 'usuario', 'senha123', 'Rua Exemplo, 123');

-- Inserir dados de exemplo para a tabela de produtos
INSERT INTO tb_produto (name, description, price, quantity) VALUES ('Produto 1', 'Descrição do Produto 1', 10.99, 100);
INSERT INTO tb_produto (name, description, price, quantity) VALUES ('Produto 2', 'Descrição do Produto 2', 20.99, 50);
INSERT INTO tb_produto (name, description, price, quantity) VALUES ('Produto 3', 'Descrição do Produto 3', 30.99, 20);
