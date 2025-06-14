<template>
  <div class="course-query-container">
    <!-- 搜索表单 -->
    <el-form :model="searchForm" inline label-width="80px" class="search-form">
      <el-form-item label="课程名称">
        <el-input v-model="searchForm.cname" placeholder="请输入课程名称" clearable />
      </el-form-item>
      <el-form-item label="教师姓名">
        <el-input v-model="searchForm.tname" placeholder="请输入教师姓名" clearable />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleQuery">查询</el-button>
        <el-button @click="handleReset">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 课程表格 -->
    <el-table :data="courseList" border style="width: 100%" :loading="loading">
      <el-table-column prop="cno" label="课程编号" align="center" />
      <el-table-column prop="cname" label="课程名称" align="center" />
      <el-table-column prop="tname" label="教师姓名" align="center" />
      <el-table-column prop="credit" label="学分" align="center" />
      <el-table-column prop="ctype" label="课程类型" align="center" />
      <el-table-column prop="classroomname" label="教室" align="center" />
      <el-table-column prop="evaluationmode" label="考核方式" align="center" />
    </el-table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';

const searchForm = ref({
  cname: '',
  tname: ''
});
const courseList = ref([]);
const loading = ref(false);

// 获取课程列表（带查询参数）
const getCourseList = async () => {
  loading.value = true;
  try {
    const response = await axios.get('http://localhost:8081/course/condition', {
      params: {
        cname: searchForm.value.cname.trim() || undefined,
        tname: searchForm.value.tname.trim() || undefined
      }
    });
    courseList.value = response.data;
  } catch (error) {
    ElMessage.error('获取课程数据失败');
    console.error(error);
  } finally {
    loading.value = false;
  }
};

// 查询按钮事件
const handleQuery = () => {
  getCourseList();
};

// 重置按钮事件
const handleReset = () => {
  searchForm.value.cname = '';
  searchForm.value.tname = '';
  getCourseList();
};

// 组件加载时获取全部课程
onMounted(() => {
  getCourseList();
});
</script>