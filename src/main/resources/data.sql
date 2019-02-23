insert into test_database.role (role) values ('ADMINISTRATION'),('CONSULTANT'),('MANAGER');
insert into test_database.departments (name) values ('DIGITAL'),('BANKING'),('SALESFORCE');

insert into test_database.user (user_id,first_name,last_name,password,salt,is_active,department_id) values
('t1.email@be-tse.com','Name_1','Lastname_1','Password_1','Salt1',0,1),
('t2.email@be-tse.com','Name_2','Lastname_2','Password_2','Salt2',0,2),
('t3.email@be-tse.com','Name_3','Lastname_3','Password_3','Salt3',0,3),
('t4.email@be-tse.com','Name_4','Lastname_4','Password_4','Salt4',0,2),
('t5.email@be-tse.com','Name_5','Lastname_5','Password_5','Salt5',0,3);

insert into test_database.user_roles (user_id, role_id) values
('t1.email@be-tse.com',1),
('t2.email@be-tse.com',2),
('t2.email@be-tse.com',1),
('t3.email@be-tse.com',1),
('t4.email@be-tse.com',1),
('t4.email@be-tse.com',2),
('t4.email@be-tse.com',3),
('t5.email@be-tse.com',2);

