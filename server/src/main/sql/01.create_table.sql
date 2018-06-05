# mysql 5.1
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'user name',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT 'user password',
  `nick_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'nick name',
  `gender` tinyint(1) DEFAULT '0' COMMENT 'male:0, female:1',
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `vaild` tinyint(1) NOT NULL DEFAULT '1' COMMENT '1 : vaild, 0 : invaild',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

