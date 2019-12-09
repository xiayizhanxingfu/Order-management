create table if not exists task
(
	task_id int auto_increment comment '任务编号'
		constraint `PRIMARY`
			primary key,
	status int default 0 not null comment '任务状态,0:未领取,1:正在做,2:完成',
	functionary varchar(32) default '无' null comment '任务负责人员',
	food_id int not null comment '食物编号',
	size int default 1 not null comment '数量',
	users_id int null comment '用户编号',
	order_id int null comment '客户的订单编号',
	constraint task_food_food_id_fk
		foreign key (food_id) references food (food_id),
	constraint task_orderform_order_id_fk
		foreign key (order_id) references orderform (order_id),
	constraint task_users_users_id_fk
		foreign key (users_id) references users (users_id)
)
comment '任务';

