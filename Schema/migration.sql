
DROP TABLE IF EXISTS `student_info`;


DROP TABLE IF EXISTS `events`;


DROP TABLE IF EXISTS `event`;


DROP TABLE IF EXISTS `users`;


DROP TABLE IF EXISTS `student`;


CREATE TABLE `event`
(
  `id`   INT unsigned NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`id`)
);



CREATE TABLE `users`
(
  `id`       INT unsigned NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `email`    VARCHAR(45) NOT NULL ,
  `password` VARCHAR(98) NOT NULL ,

  PRIMARY KEY (`id`)
);



CREATE TABLE `student`
(
  `id`         INT unsigned NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(45) NOT NULL ,
  `last_name`  VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`id`)
);



CREATE TABLE `student_info`
(
  `student_id`        INT unsigned NOT NULL ,
  `email`             VARCHAR(45) NOT NULL ,
  `phone`             VARCHAR(45) NOT NULL ,
  `allow_texts`       BIT(1) NOT NULL ,
  `street_address`    VARCHAR(100) NOT NULL ,
  `city_of_residence` VARCHAR(45) NOT NULL ,
  `zip_code`          VARCHAR(9) NOT NULL ,
  `age`               TINYINT(1) NOT NULL ,
  `referrer`          VARCHAR(45) ,
  `gender`            ENUM('MALE','FEMALE','OTHER') NOT NULL ,

  KEY `STUDENT` (`student_id`),
  CONSTRAINT `STUDENT_STUDENT_INFO` FOREIGN KEY `STUDENT` (`student_id`) REFERENCES `student` (`id`)
);



CREATE TABLE `events`
(
  `type`       INT unsigned NOT NULL ,
  `administer` INT unsigned NOT NULL ,
  `student`    INT unsigned NOT NULL ,
  `date`       DATETIME NOT NULL ,
  `notes`      TEXT ,
  `score`      INT ,

  KEY `STUDENT` (`student`),
  CONSTRAINT `STUDENT_EVENTS` FOREIGN KEY `STUDENT` (`student`) REFERENCES `student` (`id`),
  KEY `ADMINISTER` (`administer`),
  CONSTRAINT `USERS_EVENTS` FOREIGN KEY `ADMINISTER` (`administer`) REFERENCES `users` (`id`),
  KEY `TYPE` (`type`),
  CONSTRAINT `EVENT_EVENTS` FOREIGN KEY `TYPE` (`type`) REFERENCES `event` (`id`)
);





