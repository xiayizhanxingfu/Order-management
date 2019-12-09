create table if not exists orderform
(
	order_id int auto_increment comment '订单id'
		constraint `PRIMARY`
			primary key,
	users_id int null comment '用户外键',
	food_id int null comment '食物外键',
	size int default 0 not null comment '数量',
	status int default 0 not null comment '订单状态,0:未付款,1:付款,2未上菜,3:交易完成',
	location varchar(32) default '无' not null comment '客户付款后位置',
	constraint orderform_food_food_id_fk
		foreign key (food_id) references food (food_id),
	constraint orderform_users_user_account_fk
		foreign key (users_id) references users (users_id)
)
comment '用户订单信息';

