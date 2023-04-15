INSERT INTO borrow_info (id, book_id, student_id, start_time, end_time)
VALUES (
    null,
    (SELECT id FROM book WHERE name = '诗经'),
    (SELECT id FROM student WHERE name = '貂蝉'),
    '2019-09-25 17:50',
    '2019-10-25 17:50'
);

-- 相同
INSERT INTO borrow_info VALUES(
null,
(SELECT id FROM book WHERE name = '诗经'), 
(SELECT id FROM student WHERE name = '貂蝉'),
'2019-09-25 17:50',
'2019-10-25 17:50'
);


SELECT * FROM book 
WHERE category_id =
(SELECT id from category WHERE name = '计算机');

update book set price = 61.20
where name = '深入理解Java虚拟机';

delete from borrow_info where id = (
    select m.id from (
        select max(id) id from borrow_info 
    ) m
);



