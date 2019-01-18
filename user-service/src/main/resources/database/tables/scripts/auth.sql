DROP TABLE IF EXISTS user_authority;
DROP TABLE IF EXISTS authority;
DROP TABLE IF EXISTS user_authority;
DROP TABLE IF EXISTS oauth_access_token;
DROP TABLE IF EXISTS oauth_refresh_token;
DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id               BIGINT           NOT NULL    AUTO_INCREMENT,
  username         VARCHAR(50)      NOT NULL,
  password         VARCHAR(500),
  email            VARCHAR (100)    NOT NULL,
  employee_id      BIGINT           NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE authority (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE user_authority (
  user_id  BIGINT NOT NULL,
  authority_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (authority_id) REFERENCES authority (id),
  PRIMARY KEY (user_id, authority_id)
);

CREATE TABLE oauth_access_token (
  token_id          VARCHAR(256) NOT NULL PRIMARY KEY,
  token             BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name         VARCHAR(256) DEFAULT NULL,
  client_id         VARCHAR(256) DEFAULT NULL,
  authentication    BLOB,
  refresh_token     VARCHAR(256) DEFAULT NULL
);

CREATE TABLE oauth_refresh_token (
  token_id       VARCHAR(256) NOT NULL PRIMARY KEY,
  token          BLOB,
  authentication BLOB
);