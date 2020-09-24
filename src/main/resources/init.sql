CREATE DATABASE angular WITH OWNER postgres;


CREATE SCHEMA IF NOT EXISTS webapp;


CREATE TABLE IF NOT EXISTS "webapp"."role"
(
    ID       BIGSERIAL PRIMARY KEY,
    ROLENAME TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS "webapp"."USER"
(
    USERID          BIGSERIAL   NOT NULL,
    USERNAME        VARCHAR(20) NOT NULL,
    USERLOGIN       VARCHAR(20) NOT NULL,
    USERSURNAME     VARCHAR(20) NOT NULL,
    USERPASSWORD    VARCHAR(70) NOT NULL,
    USEREMAIL       VARCHAR(30) NOT NULL,
    USERDATEOFBIRTH VARCHAR(30) NOT NULL,
    USERSALARY      FLOAT       NOT NULL,
    CONSTRAINT userlogin_unique UNIQUE (USERLOGIN)
    PRIMARY KEY (USERID)
);

CREATE TABLE IF NOT EXISTS "webapp"."user_roles"
(
    user_id int NOT NULL,
    role_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES "webapp"."USER" (USERID) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES "webapp"."role" (ID),
    PRIMARY KEY (user_id, role_id)
);


INSERT INTO "webapp"."USER"
(USERLOGIN, USERPASSWORD, USEREMAIL, USERNAME, USERSURNAME, USERSALARY, USERDATEOFBIRTH)
VALUES ('kat', '$2a$10$Ct/vbaHsIqiuI9lSm4b3KOqWpdwEy.mu4jubmBMsN53QPqFPGveEu', 'cat1717@mail.ru', 'Анна', 'Иванова', 200, '10.10.1999');

INSERT INTO "webapp"."USER"
(USERLOGIN, USERPASSWORD, USEREMAIL, USERNAME, USERSURNAME, USERSALARY, USERDATEOFBIRTH)
VALUES ('leadss', '$2a$10$scOeAKLmzNGM8tbBFNP3I.NmRK73xcq2A40JcgZH9i.QfrG6dZbr6', 'liveliver@gmail.com', 'Максим', 'Вешалкин', 550, '07.09.1990');

INSERT INTO "webapp"."USER"
(USERLOGIN, USERPASSWORD, USEREMAIL, USERNAME, USERSURNAME, USERSALARY, USERDATEOFBIRTH)
VALUES ('great29', '$2a$10$Ul3LYXpCxJCi.ZSSl4cEZOKK7pcMdqpD/9tA.ZEmRJOvtkrtRBrYa', 'football_player@gmail.com', 'Вадим', 'Бабурченков', 320,
        '17.01.1880');

INSERT INTO "webapp"."USER"
(USERLOGIN, USERPASSWORD, USEREMAIL, USERNAME, USERSURNAME, USERSALARY, USERDATEOFBIRTH)
VALUES ('sgoal', '$2a$10$jlHm9NBQ2EUKDbutP8Fyy.W1CUjTMCJK8adHEJGtyyU7SPwPcUPgC', 'smirnovy@gmail.com', 'Василиса', 'Веббер', 400, '15.11.1988');

INSERT INTO "webapp"."USER"
(USERLOGIN, USERPASSWORD, USEREMAIL, USERNAME, USERSURNAME, USERSALARY, USERDATEOFBIRTH)
VALUES ('Sveta', '$2a$10$xXo3o6Crs8.x1HDWYomH3Oq4UdPGxoksqmv4JcbNFlM4EhGwT2x32', 'svetlanka17@gmail.com', 'Светлана', 'Кветко', 100000, '06.04.2000');



INSERT INTO "webapp"."role" (rolename, id)
VALUES ('user', 1);
INSERT INTO "webapp"."role" (rolename)
VALUES ('admin', 2);
INSERT INTO "webapp"."user_roles" (user_id, role_id)
VALUES (1, 1);
INSERT INTO "webapp"."user_roles" (user_id, role_id)
VALUES (2, 1);
INSERT INTO "webapp"."user_roles" (user_id, role_id)
VALUES (3, 1);
INSERT INTO "webapp"."user_roles" (user_id, role_id)
VALUES (4, 1);
INSERT INTO "webapp"."user_roles" (user_id, role_id)
VALUES (5, 2);
-- passwords:
-- $2a$10$xXo3o6Crs8.x1HDWYomH3Oq4UdPGxoksqmv4JcbNFlM4EhGwT2x32 gfhjkm (Sveta)
-- $2a$10$Ct/vbaHsIqiuI9lSm4b3KOqWpdwEy.mu4jubmBMsN53QPqFPGveEu pass (Kat)
-- $2a$10$scOeAKLmzNGM8tbBFNP3I.NmRK73xcq2A40JcgZH9i.QfrG6dZbr6 hello (leadss)
-- $2a$10$Ul3LYXpCxJCi.ZSSl4cEZOKK7pcMdqpD/9tA.ZEmRJOvtkrtRBrYa keklol (great29)
-- $2a$10$jlHm9NBQ2EUKDbutP8Fyy.W1CUjTMCJK8adHEJGtyyU7SPwPcUPgC wengerin (sgoal)