--1.创建用户表
DROP TABLE IF EXISTS C_USER;
CREATE TABLE C_USER  (
   ID       int(10) NOT NULL AUTO_INCREMENT,
   USERNAME varchar(100) NULL COMMENT '用户名',
   PASSWORD varchar(100) NULL COMMENT '密码',
   PHONE    varchar(50)  NULL COMMENT '电话号码',
   NAME     varchar(255) NULL COMMENT '真实姓名',
   ADDRESS  varchar(255) NULL COMMENT '住址',
   SEX      int(1)       NULL COMMENT '性别',
   DEPT_ID  int(10)      NULL COMMENT '所属部门Id',
   PRIMARY  KEY (ID) USING BTREE,
   UNIQUE   INDEX username(username) USING BTREE
) ;



--2.创建部门表

DROP TABLE IF EXISTS C_DEPT;
CREATE TABLE C_DEPT  (
   ID               int(10)      NOT NULL AUTO_INCREMENT COMMENT '部门id 主键',
   NAME             varchar(255) NULL COMMENT '部门名称',
   CODE             varchar(255) NULL COMMENT '部门编码 (唯一)',
   PARENT_CODE      varchar(255) NULL COMMENT '父部门编码',
   CREATE_DATE      datetime(0)  NULL COMMENT '创建时间 date类型 ',
   LAST_UPDATE_DATE datetime(0)  NULL COMMENT '最后一次修改时间',
   PRIMARY          KEY (ID) USING BTREE,
   UNIQUE           INDEX code(code) USING BTREE
) ;