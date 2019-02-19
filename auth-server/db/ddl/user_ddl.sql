-- 用户表
DROP TABLE IF EXISTS user;
CREATE TABLE user
(
  id                      BIGINT  NOT NULL AUTO_INCREMENT,
  username                VARCHAR(100) NOT NULL,
  password                VARCHAR(100) NOT NULL,
  name                    VARCHAR(200),
  mobile                  VARCHAR(20),
  enabled                 TINYINT(1),
  account_non_expired     TINYINT(1),
  credentials_non_expired TINYINT(1),
  account_non_locked      TINYINT(1),
  created_time            TIMESTAMP    NOT NULL DEFAULT now(),
  updated_time            TIMESTAMP    NOT NULL DEFAULT now(),
  created_by              VARCHAR(100) NOT NULL,
  updated_by              VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- 角色表
DROP TABLE IF EXISTS role;
CREATE TABLE role
(
  id           BIGINT  NOT NULL AUTO_INCREMENT,
  code         VARCHAR(100) NOT NULL,
  name         VARCHAR(200),
  description   VARCHAR(500),
  created_time TIMESTAMP    NOT NULL DEFAULT now(),
  updated_time TIMESTAMP    NOT NULL DEFAULT now(),
  created_by   VARCHAR(100) NOT NULL,
  updated_by   VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- 资源表
DROP TABLE IF EXISTS resource;
CREATE TABLE resource
(
  id           BIGINT  NOT NULL AUTO_INCREMENT,
  code         VARCHAR(100),
  type         VARCHAR(100),
  name         VARCHAR(200),
  url          VARCHAR(200),
  method       VARCHAR(20),
  description  VARCHAR(500),
  created_time TIMESTAMP    NOT NULL DEFAULT now(),
  updated_time TIMESTAMP    NOT NULL DEFAULT now(),
  created_by   VARCHAR(100) NOT NULL,
  updated_by   VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- 用户角色关联
DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role
(
  id           BIGINT  NOT NULL AUTO_INCREMENT,
  user_id      INT          NOT NULL,
  role_id      INT          NOT NULL,
  created_time TIMESTAMP    NOT NULL DEFAULT now(),
  updated_time TIMESTAMP    NOT NULL DEFAULT now(),
  created_by   VARCHAR(100) NOT NULL,
  updated_by   VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
);

-- 角色资源
DROP TABLE IF EXISTS role_resource;
CREATE TABLE role_resource
(
  id           SERIAL PRIMARY KEY,
  resource_id  INT          NOT NULL,
  role_id      INT          NOT NULL,
  created_time TIMESTAMP    NOT NULL DEFAULT now(),
  updated_time TIMESTAMP    NOT NULL DEFAULT now(),
  created_by   VARCHAR(100) NOT NULL,
  updated_by   VARCHAR(100) NOT NULL
);