-- 创建索引，
CREATE INDEX idx_student_sno ON student (Sno);

-- 给中间表 coursestudent 的 Sno 建索引
CREATE INDEX idx_coursestudent_sno ON coursestudent (Sno);
-- 给 Cno 建索引
CREATE INDEX idx_coursestudent_cno ON coursestudent (Cno);