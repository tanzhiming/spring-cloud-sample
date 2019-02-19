-- 用户表
INSERT INTO user (id, username, password, enabled, account_non_expired, credentials_non_expired, account_non_locked, name, mobile, created_time, updated_time, created_by, updated_by)
VALUES
  (1, 'admin', '$2a$10$VWmU3hRVAK5NNz6eWbUn0.smOmNKru1vTegwHuUdNk/zTF8mSLbpi', 1, 1, 1, 1, '超级管理员', '', now(), now(), 'system', 'system'),
  (2, 'tzm01', '$2a$10$VWmU3hRVAK5NNz6eWbUn0.smOmNKru1vTegwHuUdNk/zTF8mSLbpi', 1, 1, 1, 1, 'tanzhiming', '13428929804', now(), now(), 'system', 'system');

-- 角色
INSERT INTO role (id, code, name, description, created_time, updated_time, created_by, updated_by)
VALUES (1, 'ADMIN', '超级管理员', '超级管理员', now(), now(), 'system', 'system'),
  (2, 'FIN', '财务', '财务', now(), now(), 'system', 'system'),
  (3, 'IT', 'IT', 'IT角色', now(), now(), 'system', 'system');

-- 资源
INSERT INTO resource (id, name, code, type, url, method, description, created_time, updated_time, created_by, updated_by)
VALUES (1, '新增', 'user_manager:btn_add', 'button', '/user', 'POST', '新增用户功能', now(), now(), 'system', 'system'),
  (2, '编辑', 'user_manager:btn_edit', 'button', '/user', 'PUT', '编辑用户功能', now(), now(), 'system', 'system'),
  (3, '删除', 'user_manager:btn_del', 'button', '/user/{id}', 'DELETE', '删除用户功能', now(), now(), 'system', 'system'),
  (4, '查看', 'user_manager:view', 'url', '/user/{id}', 'GET', '查询用户功能', now(), now(), 'system', 'system');

-- 用户角色
INSERT INTO user_role (id, user_id, role_id, created_time, updated_time, created_by, updated_by)
VALUES (1, 1, 1, now(), now(), 'system', 'system'),
  (2, 2, 1, now(), now(), 'system', 'system'),
  (3, 2, 3, now(), now(), 'system', 'system');

-- 角色资源
INSERT INTO role_resource (id, role_id, resource_id, created_time, updated_time, created_by, updated_by)
VALUES (1, 1, 1, now(), now(), 'system', 'system'),
  (2, 1, 2, now(), now(), 'system', 'system'),
  (3, 1, 3, now(), now(), 'system', 'system'),
  (4, 1, 4, now(), now(), 'system', 'system'),
  (5, 2, 4, now(), now(), 'system', 'system'),
  (6, 3, 1, now(), now(), 'system', 'system'),
  (7, 3, 2, now(), now(), 'system', 'system'),
  (8, 3, 3, now(), now(), 'system', 'system'),
  (9, 3, 4, now(), now(), 'system', 'system');