insert into USERS_DB.role (role) values ('ADMINISTRATION');
insert into USERS_DB.role (role) values ('CONSULTANT');
insert into USERS_DB.role (role) values ('MANAGER');
insert into USERS_DB.departments (name) values ('BANKING');
insert into USERS_DB.departments (name) values ('DIGITAL');
insert into USERS_DB.departments (name) values ('SALESFORCE');

insert into USERS_DB.user (email_login,first_name,last_name,password,is_active,department_id) values ('t1.email@be-tse.com','Name_1','Lastname_1','$2a$10$lHiEEhL10JJujT/PRi43FuN.HUaG0GZCt2kNhz/hBYlGhSuJsFWAK',1,1);
insert into USERS_DB.user (email_login,first_name,last_name,password,is_active,department_id) values ('t2.email@be-tse.com','Name_2','Lastname_2','$2a$10$GD/Ax3Gvnh6tqC4/52RqA.O/VV1bgRH7kl63VYrI8PYtbooLgg46u',1,2);
insert into USERS_DB.user (email_login,first_name,last_name,password,is_active,department_id) values ('t3.email@be-tse.com','Name_3','Lastname_3','$2a$10$RkjMycQQ8hHWtnfTGoDiVOLRy39aOjjxPu2RKSWxYwnPlp0uuoBdi',0,3);
insert into USERS_DB.user (email_login,first_name,last_name,password,is_active,department_id) values ('t4.email@be-tse.com','Name_4','Lastname_4','$2a$10$pKNTjkD8vH3QOsYHoifHjeanzVF6IX7jNJmEkFJ/wK2xL3FIz93Qe',0,2);
insert into USERS_DB.user (email_login,first_name,last_name,password,is_active,department_id) values ('t5.email@be-tse.com','Name_5','Lastname_5','$2a$10$tkqc27vdx.GkDR1r8JImp.8eUMSTtD1Mv/GZkqbly4r3ZaObLXdt6',0,3);

insert into USERS_DB.user_roles (user_id, role_id) values (1,2);
insert into USERS_DB.user_roles (user_id, role_id) values (2,2);
insert into USERS_DB.user_roles (user_id, role_id) values (3,2);
insert into USERS_DB.user_roles (user_id, role_id) values (4,2);
insert into USERS_DB.user_roles (user_id, role_id) values (4,1);
insert into USERS_DB.user_roles (user_id, role_id) values (4,3);
