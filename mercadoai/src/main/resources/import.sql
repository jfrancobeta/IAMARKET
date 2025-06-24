INSERT INTO usuarios (id, nombre, email, username, password) VALUES (1, 'John', 'john.doe@example.com', 'ADMIN', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');
INSERT INTO usuarios (id, nombre, email, username, password) VALUES (2, 'Jane', 'jane.smith@example.com', 'janesmith', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');
INSERT INTO usuarios (id, nombre, email, username, password) VALUES (3, 'Carlos', 'carlos.g@example.com', 'carlosg', '$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS');
INSERT INTO usuarios (id, nombre, email, username, password) VALUES (4, 'Laura', 'laura.m@example.com', 'lauram', 'passForLaura');
INSERT INTO usuarios (id, nombre, email, username, password) VALUES (5, 'Michael', 'michael.b@example.com', 'michaelb', 'brownPass123');

INSERT INTO roles (id, nombre) VALUES (1, 'ROLE_USER');
INSERT INTO roles (id, nombre) VALUES (2, 'ROLE_ADMIN');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);  -- John Doe -> ROLE_USER
INSERT INTO users_roles (user_id, role_id) VALUES (1, 2);  -- Jane Smith -> ROLE_USER
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);