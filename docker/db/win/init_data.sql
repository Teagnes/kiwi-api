use kiwi;
insert into  user (username,usercname,password) values
('u_admin','测试管理员','123456'),
('u_normal','测试用户','123456')
;

INSERT INTO role (name,description) values
('R_ADMIN','管理员'),
('R_USER','一般用户');

insert into user_role(user_id,role_id) values
(1,1);

insert into permission (name, description )values
('p_user','用户管理权限'),
('p_role','角色管理权限'),
('p_permission','权限管理权限')
;

insert into role_permission (role_id,permission_id) values
(1,1),(1,2),(1,3);

;

insert into  note ( create_user_id,note_name,note_uuid ) values
(1,'测试文档库','xxxxxxxxxxxuuuuuuuuu');

insert into  note_user (note_id,user_id) values
(1,1);
