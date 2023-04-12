-- 创建用户表
DROP TABLE IF EXISTS test_user; CREATE TABLE test_user (
id_number INT,
name VARCHAR(20) comment '姓名', age INT comment '年龄',
create_time timestamp comment '创建日期'
);


--准备测试数据，批量插入用户数据（操作耗时较长，约在1小时+）：
-- 构建一个8000000条记录的数据
-- 构建的海量表数据需要有差异性，所以使用存储过程来创建， 拷贝下面代码就可以了，暂时不用理解

-- 产生名字
drop function if exists rand_name; delimiter $$
create function rand_name(n INT, l INT) returns varchar(255)
begin
declare return_str varchar(255) default ''; declare i int default 0;
while i < n do if i=0 then
set return_str = rand_string(l);
insert into test_user values ((start+i) ,rand_name(2, 5),rand_num(120),CURRENT_TIMESTAMP);
until i = max_num end repeat;
commit; end $$ delimiter ;

