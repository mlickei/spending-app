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