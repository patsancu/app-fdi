INSERT INTO USER (id, username, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (0, 'admin', 'admin@localhost.local', '100000:160634173712f9488f0072e7eda17bbb7b245426b6e50bf3aa1aa1e37ffd5d62:73402032b45e056d7cf7f93829ce39e90ab97bfc1c37a64c52a17839cf2c612b', NULL, true, true, true, true);
INSERT INTO USER (id, username, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (1, 'user', 'user@localhost.local', '100000:c1fab06d259da77d6e84b5a781a93a1f13d00171d9c6caac9e03dd4fa3790ad0:5e7e6ddd2b33ddb04629c3b75dc798ead5b39d24f4237212bfb98c83a3f1e80f', NULL, true, true, true, true);

INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_ADMIN');
INSERT INTO USER_ROLES (user, role) VALUES(1, 'ROLE_USER');



