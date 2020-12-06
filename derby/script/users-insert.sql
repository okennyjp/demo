connect 'jdbc:derby:C:/derby-10.14.2.0/dat/test;user=admin;password=admin';

MAXIMUMDISPLAYWIDTH 15;

select * from users;

INSERT INTO users VALUES
(DEFAULT, 'sj', 'berkay', 'sercan');
INSERT INTO users VALUES
(DEFAULT, 'br', 'ugur', 'oljay');

select * from users;

commit;
