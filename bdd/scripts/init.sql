CREATE USER tomus with PASSWORD 'sumotTOMUS42' CREATEDB;
CREATE DATABASE tomus OWNER tomus;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id UUID NOT NULL,
    mail VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    active BOOLEAN,
    state_id UUID,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS roles;
CREATE TABLE roles (
    id SERIAL NOT NULL,
    role VARCHAR(50),
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS states;
CREATE TABLE states (
    id UUID NOT NULL,
    word VARCHAR(15),
    tries INTEGER,
    user_id UUID,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS states_history;
CREATE TABLE states_history (
    id SERIAL NOT NULL,
    date TIMESTAMP,
    answer VARCHAR(255),
    state_id UUID NOT NULL,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS users_roles;
CREATE TABLE users_roles (
    user_id UUID NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id)
);
ALTER TABLE users
ADD CONSTRAINT FK_users_roles_1 FOREIGN KEY (state_id) REFERENCES states (id);
ALTER TABLE states
ADD CONSTRAINT FK_states_users_1 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE states_history
ADD CONSTRAINT FK_states_history_states_1 FOREIGN KEY (state_id) REFERENCES states (id);
ALTER TABLE users_roles
ADD CONSTRAINT FK_users_roles_1 FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_roles
ADD CONSTRAINT FK_users_roles_2 FOREIGN KEY (role_id) REFERENCES roles (id);