create table if not exists food
(
	food_id int auto_increment comment '菜表编号'
		constraint `PRIMARY`
			primary key,
	food_name varchar(32) null comment '菜名',
	food_url varchar(1024) null comment '菜的图片',
	food_price float null comment '菜的价格',
	food_dprice float null comment '菜的折扣价',
	food_isChara int default 0 null comment '是否特色',
	food_classify int null comment '菜的分类',
	constraint food_ibfk_1
		foreign key (food_classify) references foodclassify (fc_id)
)
comment '菜表';

create index food_classify
	on food (food_classify);

