INSERT INTO USER (USER_ID, username, userGivenName, userSurname, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (0, '${user1.username}', '${user1.userGivenName}', '${user1.userSurname}', '${user1.email}', '100000:160634173712f9488f0072e7eda17bbb7b245426b6e50bf3aa1aa1e37ffd5d62:73402032b45e056d7cf7f93829ce39e90ab97bfc1c37a64c52a17839cf2c612b', NULL, true, true, true, true);
INSERT INTO USER (USER_ID, username, userGivenName, userSurname, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (1, '${user2.username}', '${user2.userGivenName}', '${user2.userSurname}', '${user2.email}', '100000:c1fab06d259da77d6e84b5a781a93a1f13d00171d9c6caac9e03dd4fa3790ad0:5e7e6ddd2b33ddb04629c3b75dc798ead5b39d24f4237212bfb98c83a3f1e80f', NULL, true, true, true, true);
INSERT INTO USER (USER_ID, username, userGivenName, userSurname, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (2, '${user3.username}', '${user3.userGivenName}', '${user3.userSurname}', '${user3.email}', '100000:29821fd2f7ee181ac5cee88cfa125800d7fd1b01763f5cc307f95cf5d7b71dd2:3cc3d44645b656436c68d36ce4c38b69b3fcff660c92b80fa9f83b973b1f96dd', NULL, true, true, true, true);
INSERT INTO USER (USER_ID, username, userGivenName, userSurname, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (3, '${user4.username}', '${user4.userGivenName}', '${user4.userSurname}', '${user4.email}', '100000:f502fef3973388fb700a5d08e3523b50cf78929a9c26016c30b1991a37f7708e:ace96b2014529df9aeefb4b2f8c99e2d1caff6a7c3e1e67172d9df3cdc795338', NULL, true, true, true, true);
INSERT INTO USER (USER_ID, username, userGivenName, userSurname, email, password, salt, enabled, accountNonExpired, accountNonLocked, credentialsNonExpired) VALUES (4, '${user5.username}','${user5.userGivenName}', '${user5.userSurname}', '${user5.email}', '100000:29821fd2f7ee181ac5cee88cfa125800d7fd1b01763f5cc307f95cf5d7b71dd2:3cc3d44645b656436c68d36ce4c38b69b3fcff660c92b80fa9f83b973b1f96dd', NULL, true, true, true, true);

INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(0, 'ROLE_ADMIN');
INSERT INTO USER_ROLES (user, role) VALUES(1, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(2, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(3, 'ROLE_USER');
INSERT INTO USER_ROLES (user, role) VALUES(4, 'ROLE_USER');



