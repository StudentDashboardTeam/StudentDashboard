CREATE DATABASE IF NOT EXISTS student_dashboard_db;


USE student_dashboard_db;


DROP TABLE IF EXISTS `events`;


DROP TABLE IF EXISTS `student`;


DROP TABLE IF EXISTS `hear_about_us`;


DROP TABLE IF EXISTS `payment_options`;


DROP TABLE IF EXISTS `cohort`;


DROP TABLE IF EXISTS `event`;


DROP TABLE IF EXISTS `users`;


CREATE TABLE `hear_about_us`
(
 `id`               INT unsigned NOT NULL AUTO_INCREMENT ,
 `twitter_facebook` BIT(1) ,
 `youtube`          BIT(1) ,
 `muse`             BIT(1) ,
 `billboard`        BIT(1) ,
 `tv`               BIT(1) ,
 `radio`            BIT(1) ,
 `news`             BIT(1) ,
 `web`              BIT(1) ,
 `geekdom`          BIT(1) ,
 `friend_family`    BIT(1) ,
 `employer`         BIT(1) ,
 `student`          BIT(1) ,
 `job_school_fair`  BIT(1) ,
 `other`            BIT(1) ,

PRIMARY KEY (`id`)
);


CREATE TABLE `payment_options`
(
 `id`          INT unsigned NOT NULL AUTO_INCREMENT ,
 `self`        BIT(1) ,
 `va_benefits` BIT(1) ,
 `loan`        BIT(1) ,
 `scholarship`       BIT(1) ,
 `other`       BIT(1) ,

PRIMARY KEY (`id`)
);


CREATE TABLE `cohort`
(
 `id`         INT unsigned NOT NULL AUTO_INCREMENT ,
 `name`       VARCHAR(45) NOT NULL ,
 `start_date` DATE NOT NULL ,
 `end_date`   DATE NOT NULL ,
 `type`       ENUM('WEB','DATA') NOT NULL ,

PRIMARY KEY (`id`)
);

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
 `id`                 INT unsigned NOT NULL AUTO_INCREMENT ,
 `hear_about_us`      INT unsigned NOT NULL ,
 `payment_options`    INT unsigned NOT NULL ,
 `cohort_id`          INT unsigned ,
 `first_name`         VARCHAR(45) NOT NULL ,
 `last_name`          VARCHAR(45) NOT NULL ,
 `email`              VARCHAR(45) NOT NULL ,
 `phone`              VARCHAR(15) NOT NULL ,
 `allow_sms`          BIT(1) NOT NULL ,
 `street_address`     VARCHAR(50) NOT NULL ,
 `city_of_residence`  VARCHAR(50) NOT NULL ,
 `zip_code`           VARCHAR(10) NOT NULL ,
 `age`                TINYINT(1) NOT NULL ,
 `referrer`           VARCHAR(45) NOT NULL ,
 `gender`             ENUM('FEMALE','MALE','OTHER') NOT NULL ,
 `free_schedule`      BIT(1) NOT NULL ,
 `resume_file`        VARCHAR(45) ,
 `gi_bill`            BIT(1) NOT NULL ,
 `billboards`         ENUM('YES','NO','DON''T REMEMBER') ,
 `best_describes_you` ENUM('I AM A TRANSITIONING VETERAN OR ACTIVE MILITARY.','I CURRENTLY WORK IN THE SERVICE INDUSTRY AND LOOKING FOR A CAREER CHANGE.','I HAVE BEEN IN THE SAME CAREER FOR OVER 5 YEARS AND LOOKING FOR A CAREER CHANGE.','I AM A RECENT COLLEGE GRADUATE.','I AM A RECENT HIGH SCHOOL GRADUATE AND LOOKING FOR ALTERNATIVE OPTIONS TO A COLLEGE/UNIVERSITY.') NOT NULL ,
 `description_other`  VARCHAR(500) ,
 `why`                VARCHAR(1000) NOT NULL ,
 `questions`          VARCHAR(1000) ,

PRIMARY KEY (`id`),
KEY `COHORT_ID` (`cohort_id`),
CONSTRAINT `COHORT_STUDENT` FOREIGN KEY `COHORT_ID` (`cohort_id`) REFERENCES `cohort` (`id`),
KEY `PAYMENT_OPTIONS` (`payment_options`),
CONSTRAINT `PAYMENT_OPTIONS_STUDENT` FOREIGN KEY `PAYMENT_OPTIONS` (`payment_options`) REFERENCES `payment_options` (`id`),
KEY `HEAR_ABOUT_US` (`hear_about_us`),
CONSTRAINT `HEAR_STUDENT` FOREIGN KEY `HEAR_ABOUT_US` (`hear_about_us`) REFERENCES `hear_about_us` (`id`)
);

CREATE TABLE `events`
(
 `type`         INT unsigned NOT NULL ,
 `administerer` INT unsigned NOT NULL ,
 `student`      INT unsigned NOT NULL ,
 `date`         DATETIME NOT NULL ,
 `notes`        TEXT ,
 `score`        INT ,

KEY `STUDENT` (`student`),
CONSTRAINT `STUDENT_EVENTS` FOREIGN KEY `STUDENT` (`student`) REFERENCES `student` (`id`),
KEY `ADMINISTERER` (`administerer`),
CONSTRAINT `USERS_EVENTS` FOREIGN KEY `ADMINISTERER` (`administerer`) REFERENCES `users` (`id`),
KEY `TYPE` (`type`),
CONSTRAINT `EVENT_EVENTS` FOREIGN KEY `TYPE` (`type`) REFERENCES `event` (`id`)
);