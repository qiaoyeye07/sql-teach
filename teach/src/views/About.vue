<template>
  <div class="course-selected-container">
    <h2 class="page-title">已选课程</h2>
    <el-table 
      :data="selectedCourses" 
      border 
      style="width: 100%" 
      :loading="loading"
    >
      <el-table-column prop="cno" label="课程编号" align="center" />
      <el-table-column prop="cname" label="课程名称" align="center" />
      <el-table-column prop="tname" label="教师姓名" align="center" />
      <el-table-column prop="credit" label="学分" align="center" />
      <el-table-column prop="ctype" label="课程类型" align="center" />
      <el-table-column prop="classroomname" label="教室" align="center" />
      <el-table-column prop="evaluationmode" label="考核方式" align="center" />
      <el-table-column label="操作" align="center">
        <template #default="scope">
          <el-button type="danger" @click="handleDropCourse(scope.row)">退课</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import { ElMessage } from 'element-plus';
import { useRoute } from 'vue-router';
import { computed } from 'vue';

const route = useRoute();
// 获取路由传递的用户名（Sno）
const username = computed(() => route.query.username); 
console.log('当前用户名：', username.value); 

const selectedCourses = ref([]);
const loading = ref(false);

// 获取已选课程列表（通过当前用户 Sno）
const getSelectedCourses = async () => {
  loading.value = true;
  try {
    const Sno = username.value; 
    const response = await axios.get('http://localhost:8081/student/courses', {
      params: { Sno } 
    });
    selectedCourses.value = response.data;
  } catch (error) {
    ElMessage.error('获取已选课程失败');
    console.error(error);
  } finally {
    loading.value = false;
  }
};

// 点击退课按钮的事件
const handleDropCourse = async (row) => {
  try {
    const Sno = username.value; 
    const Cno = row.cno; 
    await axios.post('http://localhost:8081/dropCourse', {
      Sno,
      Cno
    });
    ElMessage.success('退课成功');
    // 退课成功后，重新获取已选课程列表（更新界面）
    await getSelectedCourses(); 
  } catch (error) {
    ElMessage.error('退课失败，请重试');
    console.error(error);
  }
};

onMounted(() => {
  getSelectedCourses();
});
</script>

<style scoped>
.course-selected-container {
  padding: 20px;
}
.page-title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 16px;
}
</style>