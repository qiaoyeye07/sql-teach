-- 插入表中信息表 后续更改上面外码及名字


CREATE TABLE college(
  college_id int PRIMARY KEY,
  college_name VARCHAR(40) UNIQUE
  )COMMENT'学院表，有什么学院';
  
CREATE TABLE classroom(
  classroom_id int PRIMARY KEY,
  classroom_name VARCHAR(56) UNIQUE
  )COMMENT'上课地点表';
  
  

CREATE TABLE student
  (Sno CHAR(9) PRIMARY KEY,
   Sname VARCHAR(20), -- 取值唯一不唯一呢
   sex ENUM('男', '女'),-- 男女
   Sbirthday DATE,
   college_name VARCHAR(40), -- 所属学院
   GPA DECIMAL(3,2) , -- 绩点
    
   FOREIGN KEY (college_name) REFERENCES college(college_name)
   
 )COMMENT'学生信息表';
 
 
 CREATE TABLE course
  (Cno CHAR(8) PRIMARY KEY,-- 课程编码
   Cname CHAR(40), -- 课程名
   Tname VARCHAR(20), -- 任课教师
   Credit TINYINT ,-- 学分
   Ctype ENUM('必修课', '选修课', '公共课') NOT NULL,
   classroom_name VARCHAR(56),-- 上课地点
   evaluation_mode ENUM('考试', '论文', '考查') NOT NULL,
   
  
   FOREIGN KEY (classroom_name) REFERENCES classroom(classroom_name)
   
   )COMMENT'课程信息表';

CREATE TABLE coursestudent(
   Sno CHAR(9),
   Cno CHAR(8),
   
   PRIMARY KEY (Cno, Sno), -- 主键
   
   
   FOREIGN KEY (Sno) REFERENCES student(Sno) ON UPDATE CASCADE ON DELETE CASCADE,
   
   FOREIGN KEY (Cno) REFERENCES course(Cno) ON UPDATE CASCADE ON DELETE CASCADE
   )COMMENT '学生已选课';
   


