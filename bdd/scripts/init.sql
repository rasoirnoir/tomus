CREATE USER tomus with PASSWORD 'sumotTOMUS42' CREATEDB;
CREATE DATABASE tomus OWNER tomus;
\connect tomus;
CREATE SCHEMA tomus AUTHORIZATION tomus;
DROP TABLE IF EXISTS tomus.users;
CREATE TABLE tomus.users (
    id UUID NOT NULL,
    mail VARCHAR(255),
    username VARCHAR(255),
    password VARCHAR(255),
    active BOOLEAN,
    state_id UUID,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS tomus.roles;
CREATE TABLE tomus.roles (
    id SERIAL NOT NULL,
    role VARCHAR(50),
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS tomus.states;
CREATE TABLE tomus.states (
    id UUID NOT NULL,
    word VARCHAR(15),
    tries INTEGER,
    user_id UUID,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS tomus.states_history;
CREATE TABLE tomus.states_history (
    id SERIAL NOT NULL,
    date TIMESTAMP,
    answer VARCHAR(255),
    state_id UUID NOT NULL,
    PRIMARY KEY (id)
);
DROP TABLE IF EXISTS tomus.users_roles;
CREATE TABLE tomus.users_roles (
    user_id UUID NOT NULL,
    role_id INTEGER NOT NULL,
    PRIMARY KEY (user_id, role_id)
);
ALTER TABLE tomus.users
ADD CONSTRAINT FK_users_roles_1 FOREIGN KEY (state_id) REFERENCES tomus.states (id);
ALTER TABLE tomus.states
ADD CONSTRAINT FK_states_users_1 FOREIGN KEY (user_id) REFERENCES tomus.users (id);
ALTER TABLE tomus.states_history
ADD CONSTRAINT FK_states_history_states_1 FOREIGN KEY (state_id) REFERENCES tomus.states (id);
ALTER TABLE tomus.users_roles
ADD CONSTRAINT FK_users_roles_1 FOREIGN KEY (user_id) REFERENCES tomus.users (id);
ALTER TABLE tomus.users_roles
ADD CONSTRAINT FK_users_roles_2 FOREIGN KEY (role_id) REFERENCES tomus.roles (id);
-- INSERTS
INSERT INTO tomus.roles (role)
VALUES('PLAYER');
INSERT INTO tomus.roles (role)
VALUES('ADMIN');