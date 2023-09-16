
INSERT INTO role (name,description) values
('USER','一般用户') ,('USER_OP','操作用户'),('ADMIN','管理员');


insert into  user (username,usercname,password) values
('u_normal','测试一般用户','123456'),
('u_admin','测试管理员','123456');

insert into user_role(user_id,role_id) values
(1,1);

insert into permission (name, description )values
('permission:info','权限:用户详细权限');

insert into role_permission (role_id,permission_id) values
(1,1);

insert into  note ( create_user_id,note_name,note_uuid ) values
(1,'测试文档库','xxxxxxxxxxxuuuuuuuuu');

insert into  note_user (note_id,user_id) values
(1,1);

insert into  note_doc (note_id,doc_id) values
(1,1),(1,2),(1,3);

insert into note_doc (note_id,doc_id) values
(2,4);

