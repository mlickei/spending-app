CREATE TABLE IF NOT EXISTS user (
    user_id int(10) NOT NULL AUTO_INCREMENT,
    user_name varchar(20) NOT NULL,
    password varchar(256) NOT NULL,
    salt varchar(256) NOT NULL,
    email varchar(25) NOT NULL,
    filepath varchar(256) DEFAULT NULL,
    PRIMARY KEY (user_id),
    UNIQUE KEY (user_name)
);

CREATE TABLE IF NOT EXISTS category (
    id int(10) NOT NULL AUTO_INCREMENT,
    name varchar(256) NOT NULL,
    description varchar(256),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS transaction (
    id int(10) NOT NULL AUTO_INCREMENT,
    category int(10) NOT NULL,
    amount FLOAT(15,2) NOT NULL,
    name varchar(256) NOT NULL,
    description varchar(256),
    datetime TIMESTAMP NOT NULL,
    create_time TIMESTAMP NOT NULL,
    user int(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (category) REFERENCES category(id),
    FOREIGN KEY (user) REFERENCES user(user_id)
)