SET NAMES utf8mb4;


-- 建库
CREATE DATABASE IF NOT EXISTS kiwi default charset utf8 COLLATE utf8_general_ci;

-- 切换数据库
use kiwi;


SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
    `usercname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '中文名',
    `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
    `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;

CREATE TABLE `permission`
(
    `id`       int(11)                                         NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
    `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述表',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '权限表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role`
(
    `id`       int(11)                                       NOT NULL AUTO_INCREMENT,
    `name`        varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
    `description` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色表'
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------

DROP TABLE IF EXISTS `role_permission`;

CREATE TABLE `role_permission`
(
    `id`       int(11)                                            NOT NULL AUTO_INCREMENT,
    `role_id`       int(11) NULL DEFAULT NULL,
    `permission_id` int(11) NULL DEFAULT NULL,
    INDEX `role_permission_uid_fk` (`role_id`) USING BTREE,
    INDEX `role_permission_pid_fk` (`permission_id`) USING BTREE,
    CONSTRAINT `role_permission_pid_fk` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `role_permission_uid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci
  ROW_FORMAT = Dynamic;



-- ----------------------------
-- Table structure for user_role
-- ----------------------------

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NULL DEFAULT NULL,
    `role_id` int(11) NULL DEFAULT NULL,
    INDEX `user_role_uid_fk` (`user_id`) USING BTREE,
    INDEX `user_role_rid_fk` (`role_id`) USING BTREE,
    CONSTRAINT `user_role_rid_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `user_role_uid_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户角色表'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

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



-- 继承权限关系表
DROP  TABLE IF EXISTS `role_relation`;

CREATE TABLE  `role_relation` (
 `id` int(11) NOT NULL AUTO_INCREMENT  COMMENT '自增主键',
 `parent_role_id` int(11) NULL DEFAULT NULL COMMENT '父角色id',
 `child_role_id` int(11) NULL DEFAULT NULL COMMENT '子角色id',
 `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
 `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色关系表'
  ROW_FORMAT = Dynamic;






DROP TABLE IF EXISTS `doc`;

CREATE TABLE `doc`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NULL DEFAULT NULL,
    `doc_name` varchar(255) NULL DEFAULT NULL,
    INDEX `user_role_uid_fk` (`user_id`) USING BTREE,
    `doc_uuid` varchar(255) NOT NULL  COMMENT '文档uuid' ,
    `version_uuid` varchar(255)  NULL  COMMENT '文档的当前版本uuid' ,
    `create_time` timestamp not NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp not NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '文档表'
  ROW_FORMAT = Dynamic;


DROP TABLE IF EXISTS `note`;

CREATE TABLE `note`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `create_user_id` int(11) NULL DEFAULT NULL COMMENT  '创建用户',
    `note_name` varchar(255) NULL DEFAULT NULL COMMENT  '库名称',
    INDEX `user_role_uid_fk` (`create_user_id`) USING BTREE,
    `note_uuid` varchar(255) NOT NULL  COMMENT '库uuid' ,
    `create_time` timestamp not NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp not NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '文档库表明'
  ROW_FORMAT = Dynamic;

insert into  note ( create_user_id,note_name,note_uuid ) values
    (1,'测试文档库','xxxxxxxxxxxuuuuuuuuu');



-- 库用户关联表

DROP TABLE IF EXISTS `note_user`;

CREATE TABLE `note_user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `note_id` int(11) NULL DEFAULT NULL,
    `user_id` int(11) NULL DEFAULT NULL,
    INDEX `user_note_rid_fk` (`note_id`) USING BTREE,
    INDEX `user_note_uid_fk` (`user_id`) USING BTREE,
    CONSTRAINT `user_user_uid_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `user_noet_rid_fk` FOREIGN KEY (`note_id`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '文档库库用户关联表'
  ROW_FORMAT = Dynamic;

insert into  note_user (note_id,user_id) values
(1,1);


CREATE TABLE `note_doc`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `note_id` int(11) NULL DEFAULT NULL,
    `doc_id` int(11) NULL DEFAULT NULL,
    INDEX `doc_note_rid_fk` (`note_id`) USING BTREE,
    INDEX `doc_note_uid_fk` (`doc_id`) USING BTREE,
    CONSTRAINT `note_doc_nid_fk` FOREIGN KEY (`note_id`) REFERENCES `note` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `note_doc_uid_fk` FOREIGN KEY (`doc_id`) REFERENCES `doc` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '文档库库用户关联表'
  ROW_FORMAT = Dynamic;

insert into  note_doc (note_id,doc_id) values
(1,1),(1,2),(1,3);
insert into note_doc (note_id,doc_id) values
(2,4);


