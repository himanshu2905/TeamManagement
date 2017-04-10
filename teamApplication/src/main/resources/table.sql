create database teamdb;

CREATE TABLE `teams` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `rating` int(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

create table users(
	username varchar(100) not null primary key,
    password varchar(100) not null,
    enabled boolean not null
);


create table authorities(
	username varchar(100) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users
    foreign key(username) references users(username)
);

create unique index idx_username on authorities(username, authority);

insert into users values('jim','secret', true);

insert into authorities values('jim','ROLE_USER');

insert into users values('tom','secret1', true);

insert into authorities values('tom','ROLE_USER');
insert into authorities values('tom','ROLE_ADMIN');

update users set password='$2a$10$0nv0poBLVbPAaVMzdv.x7.ahLlGorRhSmWImeYlPrEUrrvJZtAz4O' where username='jim';

update users set password='$2a$10$7t35w2WcvDcQjdAsJD.dHeXzlwsSIn4joojFYjhGlnTf5iC/1Usie' where username='tom';




