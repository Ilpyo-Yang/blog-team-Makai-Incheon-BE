-- user 기본값
insert into user (nickname, password, role)
values ('레이머', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'ROLE_USER');
insert into user (uuid, nickname, password, role)
values ('Rosie', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'ROLE_USER');
insert into user (nickname, password, role)
values ('영민', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'ROLE_USER');

-- tag 기본값
insert into tag (tag) values ('블로그');