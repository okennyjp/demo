connect 'jdbc:derby:C:/derby-10.14.2.0/dat/test;user=admin;password=admin';

MAXIMUMDISPLAYWIDTH 15;

--DROP TABLE users if needed

show tables in admin;

CREATE TABLE users (
    id INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    login_id VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    user_name VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX ui_users_01 ON users (
    login_id
);

show tables in admin;
describe users;

commit;
