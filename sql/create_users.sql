create table if not exists users
(
	users_id int auto_increment comment '用户编号'
		constraint `PRIMARY`
			primary key,
	user_name varchar(32) not null comment '用户名',
	user_account varchar(32) not null comment '用户账号',
	user_pwd varchar(32) not null comment '用户密码',
	user_identity int null comment '用户身份',
	constraint users_user_account_uindex
		unique (user_account)
)
comment '用户表';

