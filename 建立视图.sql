CREATE VIEW `user` AS
SELECT
    s.Sno AS username,
    s.spassword AS `password`
  
FROM student s
ORDER BY 
    s.Sno ASC; -- 按学号升序排序