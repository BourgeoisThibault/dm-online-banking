INSERT INTO `users` (`id`, `address`, `birth`, `first_name`, `last_name`, `phone`) VALUES (1, '26 rue Chateaubriand', '1993-07-06', 'Thibault', 'BOURGEOIS', '0629516898');
INSERT INTO `users` (`id`, `address`, `birth`, `first_name`, `last_name`, `phone`) VALUES (2, '10 route de Chabanais', '1960-03-26', 'Jean-Pierre', 'BOURGEOIS', '0612345678');
INSERT INTO `type_account` (`type`, `min_age`) VALUES ('Compte courant', 999);
INSERT INTO `type_account` (`type`, `min_age`) VALUES ('Livret A', 999);
INSERT INTO `type_account` (`type`, `min_age`) VALUES ('Livret jeune', 25);
INSERT INTO `account` (`id`, `solde`, `account_type_entity_type`, `user_entity_id`) VALUES (1, 123.123, 'Compte courant', 1);
INSERT INTO `account` (`id`, `solde`, `account_type_entity_type`, `user_entity_id`) VALUES (2, 8000, 'Livret A', 1);
INSERT INTO `account` (`id`, `solde`, `account_type_entity_type`, `user_entity_id`) VALUES (3, 12.1, 'Compte courant', 2);