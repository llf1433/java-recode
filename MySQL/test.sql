-- 商品名称、商品价格、商品库存、商品描述
create table commodity(
    name varchar(10), -- 商品名
    price int,      -- 价格
    inventory int,  -- 库存
    `description` text  -- 描述
    );

-- Table:teacher
-- Field:name、age、身高、体重、性别、学历、生日、身份证号
create table teacher(
    name varchar(5), -- 姓名
    age int,         -- 年龄
    height double,   -- 身高
    `weight` double,   -- 体重
    gender varchar(2), -- 性别
    degree varchar(10), -- 学历
    birthday datetime, -- 生日
    id_number varchar(18) -- 身份证号
);

-- Table:图书表
-- Field:图书名称，图书作者、图书价格、图书分类
CREATE TABLE book(
    bookname VARCHAR(20), -- 书名 
    author VARCHAR(10), -- 作者
    price INT, -- 价格
    `type` VARCHAR(2) -- 图书分类
);


