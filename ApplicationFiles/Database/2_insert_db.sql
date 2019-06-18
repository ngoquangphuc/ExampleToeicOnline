use toeiconline;

select * from user;

INSERT INTO user(name, password, fullname, createddate, roleid) VALUES('admin', '123456', 'admin',CURRENT_TIMESTAMP, 1);
INSERT INTO user(name, password, fullname, createddate, roleid) VALUES('ngoquangphuc', '123456', 'ngo quang phuc',CURRENT_TIMESTAMP, 2);