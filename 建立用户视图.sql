CREATE VIEW `user` AS
SELECT
    s.Sno AS username,
    s.spassword AS `password`
  
FROM student s
ORDER BY 
    s.Sno ASC; -- 按学号升序排序
    
    
START TRANSACTION;
CREATE VIEW student_view AS
SELECT 
    s.Sno AS StudentID,
    s.Sname AS StudentName,
    s.sex AS Gender,
    s.Sbirthday AS BirthDate,
    s.college_name AS CollegeName,
    s.GPA AS GPA
FROM 
    student s
ORDER BY 
    s.Sno ASC; -- 按学号升序排序

ROLLBACK;

CREATE VIEW studentcourse_view AS
SELECT 
    cs.Sno,  -- 学号，来自 coursestudent 表
    c.*      -- 课程所有列，来自 course 表
FROM 
    coursestudent cs
-- 通过课程编号 Cno 关联课程表
JOIN 
    course c ON cs.Cno = c.Cno
ORDER BY 
    cs.Sno ASC; -- 按学号升序排序
    
  
CREATE VIEW unselectedcourses_view AS
SELECT 
    s.Sno, -- 学生学号
    c.* -- 课程名称
FROM 
    student s
CROSS JOIN 
    course c -- 先做笛卡尔积，得到所有学生与所有课程的可能组合
WHERE 
    NOT EXISTS ( -- 过滤掉已选课的组合
        SELECT 1 
        FROM coursestudent cs 
        WHERE cs.Sno = s.Sno AND cs.Cno = c.Cno
    );
    
    