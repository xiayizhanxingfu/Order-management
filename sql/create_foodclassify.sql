create table if not exists foodclassify
(
	fc_id int auto_increment comment '菜的分类编号'
		constraint `PRIMARY`
			primary key,
	fc_name varchar(32) null comment '菜的分类名称'
)
comment '菜的分类';

