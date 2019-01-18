INSERT INTO user (username, password, email, employee_id) VALUES
  ('pera', 'b8f57d6d6ec0a60dfe2e20182d4615b12e321cad9e2979e0b9f81e0d6eda78ad9b6dcfe53e4e22d1', 'pera@pera', 1);
INSERT INTO user (username, password, email, employee_id)
VALUES ('marko', '52ed4ba2d6dadf0d61f2be04ed1b48e883d53d02279b63df5eef8a75930680cbebf1cd7dd157a29c', 'marko@marko', 1);

INSERT INTO authority (name) VALUES ('ROLE_PROFESSOR');
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_authority (user_id, authority_id) VALUES (1, 1);
# INSERT INTO user_authority (user_id, authority_id) VALUES (1, 2);
INSERT INTO user_authority (user_id, authority_id) VALUES (2, 2);