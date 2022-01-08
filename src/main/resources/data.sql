INSERT INTO `level` (`id_level`, `dame_attack`, `defense`, `fee`, `max_health`, `max_mana`) VALUES
('1', 10, 10, 1000, 1000, 1000),
('2', 20, 20, 2000, 2000, 2000),
('3', 30, 30, 3000, 3000, 3000),
('4', 40, 40, 4000, 4000, 4000),
('5', 50, 50, 5000, 5000, 5000),
('6', 60, 60, 6000, 6000, 6000),
('7', 70, 70, 7000, 7000, 7000);

INSERT INTO `enemy` (`id`, `dame_attack`, `description`, `health`, `max_health`) VALUES
('1', 100, 'mo ta 1', 1000, 1000),
('10', 250, 'Con Ong ma quai', 200, 200),
('11', 250, 'Con Ong ma quai', 500, 500),
('12', 10, 'Con Ong ma quai', 200, 200),
('13', 50, 'Kien nay can rat dau', 1000, 1000),
('14', 50, 'Khung long sieu to khong lo', 1000, 1000),
('15', 200, 'Con Ong ma quai', 500, 500),
('16', 300, 'Kien nay can rat dau', 1000, 1000),
('17', 300, 'cao cao ac quy', 200, 200),
('18', 300, 'Kien nay can rat dau', 500, 500),
('19', 25, 'Kien nay can rat dau', 500, 500),
('2', 250, 'Kien nay can rat dau', 200, 200),
('20', 200, 'Con Ong ma quai', 500, 500),
('21', 100, 'cao cao ac quy', 500, 500),
('22', 25, 'Khung long sieu to khong lo', 500, 500),
('23', 25, 'Kien nay can rat dau', 200, 200),
('24', 300, 'Khung long sieu to khong lo', 500, 500),
('25', 10, 'cao cao ac quy', 200, 200),
('26', 250, 'Khung long sieu to khong lo', 200, 200),
('27', 200, 'Con Ong ma quai', 500, 500),
('28', 50, 'Kien nay can rat dau', 1000, 1000),
('29', 10, 'cao cao ac quy', 500, 500),
('3', 25, 'Kien nay can rat dau', 500, 500),
('30', 100, 'cao cao ac quy', 1000, 1000),
('31', 25, 'Khung long sieu to khong lo', 1000, 1000),
('32', 25, 'Con Ong ma quai', 200, 200),
('33', 300, 'Khung long sieu to khong lo', 200, 200),
('34', 200, 'Kien nay can rat dau', 1000, 1000),
('35', 25, 'Con Ong ma quai', 200, 200),
('36', 250, 'Con Ong ma quai', 200, 200),
('37', 300, 'cao cao ac quy', 200, 200),
('38', 50, 'Con Ong ma quai', 1000, 1000),
('39', 50, 'Con Ong ma quai', 500, 500),
('4', 10, 'Con Ong ma quai', 500, 500),
('40', 250, 'Khung long sieu to khong lo', 1000, 1000),
('41', 10, 'Khung long sieu to khong lo', 500, 500),
('42', 250, 'Khung long sieu to khong lo', 500, 500),
('43', 10, 'Con Ong ma quai', 200, 200),
('44', 10, 'cao cao ac quy', 1000, 1000),
('45', 25, 'Khung long sieu to khong lo', 200, 200),
('5', 300, 'Con Ong ma quai', 200, 200),
('6', 100, 'cao cao ac quy', 200, 200),
('7', 50, 'Con Ong ma quai', 200, 200),
('8', 100, 'Con Ong ma quai', 1000, 1000),
('9', 50, 'Con Ong ma quai', 500, 500);

INSERT INTO `weapon` (`id`, `dame`, `description`, `name`, `price`) VALUES
('arrowlv1', 10, 'Arrow Level 1 + 10 attack dame', 'Arrow Level 1', 500),
('axelv1', 10, 'Axe + 10 dame', 'Axe lv1', 500),
('cung1', 10, 'Archery lv1 +10 attack dame for player', 'Archery lv1', 500),
('cung2', 20, 'Archery lv2 +20 attack dame for player', 'Archery lv2', 1000),
('cung3', 30, 'Archery lv3 +30 attack dame for player', 'Archery lv3', 1500),
('cung4', 40, 'Archery lv4 +40 attack dame for player', 'Archery lv4', 2000),
('cung5', 50, 'Archery lv5 +50 attack dame for player', 'Archery lv5', 2500),
('cung6', 60, 'Archery lv6 +60 attack dame for player', 'Archery lv6', 3000),
('cung7', 70, 'Archery lv7 +70 attack dame for player', 'Archery lv7', 3500),
('kiem1', 10, 'Sword lv1 +10 attack dame', 'Sword lv1', 500),
('kiem2', 20, 'Sword lv2 +20 attack dame', 'Sword lv2', 1000),
('kiem3', 30, 'Sword lv3 +30 attack dame', 'Sword lv3', 1500),
('kiem4', 40, 'Sword lv4 +40 attack dame', 'Sword lv4', 2000),
('kiem5', 50, 'Sword lv5 +50 attack dame', 'Sword lv5', 2500),
('kiem6', 60, 'Sword lv6 +60 attack dame', 'Sword lv6', 3000),
('kiem7', 70, 'Sword lv7 +70 attack dame', 'Sword lv7', 3500),
('swordlv1', 10, 'Sword Lv1  + 10 attack dame', 'Sword Lv1', 500);

INSERT INTO `skill` (`id`, `description`, `mana`, `name`) VALUES
('attack1', 'Player can attack skill 1', 20, 'Attack 1'),
('attack2', 'Player can attack skill 2', 20, 'Attack 2'),
('attack3', 'Player can attack skill 3', 20, 'Attack 3'),
('block', 'Player can block skill', 20, 'Block'),
('jump', 'Player can jump and double jump', 10, 'Jump'),
('rolling', 'Player can rolling', 15, 'Rolling');

INSERT INTO `mp` (`id`, `description`, `name`, `price`, `ratemp`) VALUES
('mpbig', 'MP Big + 120 MP cho player', 'MP Big', 100, 120),
('mpmini', 'MP Mini + 50 MP cho player', 'MP Mini', 50, 50);

INSERT INTO `hp` (`id`, `description`, `name`, `price`, `ratehp`) VALUES
('hpbig', 'HP Mini +150 hp cho player', 'HP Big', 100, 120),
('hpmini', 'HP Mini +50 hp cho player', 'HP Mini', 50, 50);