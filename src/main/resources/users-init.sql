INSERT INTO USER (id, username, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (0, 'admin', 'admin@localhost.local', 'admin1234', NULL, true, true, true, true);
INSERT INTO USER (id, username, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (1, 'user', 'user@localhost.local', 'user1234', NULL, true, true, true, true);

INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_ADMIN');
INSERT INTO USER_ROLES (user, role) VALUES(1, 'ROLE_USER');