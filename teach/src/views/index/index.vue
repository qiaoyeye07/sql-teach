<template>
  <div class="course-side-border">
    <!-- 左侧边框区域 -->
    <div class="left-border">
      <!-- 选课程按钮 -->
      <el-button 
        type="primary" 
        round 
        @click="handleSelectedClick"
        class="course-button"
      >
        全部课程
      </el-button>

      <!-- 选课程按钮 -->
      <el-button 
        type="default" 
        round 
        @click="handleUnselectedClick"
        class="course-button"
      >
        已选课程
      </el-button>

      <!-- 选课程按钮 -->
      <el-button 
        type="default" 
        round 
        @click="handleUncourseClick"
        class="course-button"
      >
        未选课程
      </el-button>

    </div>

    <!-- 右侧空白区域 -->
    <div class="right-content">
      <!-- 此处可放置其他网页内容，当前预留空白 -->
       
      <div class="empty-placeholder">
        <p>点击左侧按钮切换页面</p>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRoute ,useRouter} from 'vue-router';
import { computed } from 'vue';
//import router from '@/router';

const route = useRoute();
const router = useRouter();
const username = computed(() => route.query.username); // 获取当前页面的用户名

console.log('当前用户名：', username.value); // 控制台输出

// 按钮点击事件处理（可根据需求自定义逻辑）
const handleSelectedClick = () => {
  console.log("跳转到选课程页面");
  router.push('/course1')
  // 此处可添加路由跳转逻辑（例如：useRouter().push('/selected-courses')）
}

const handleUnselectedClick = () => {
  console.log("跳转到已选课程页面");
  router.push({
    path:'/course2',
    name: 'course2', // 路由名称
    query: { username: username.value } // 传递用户名到下一页
  });
  // 此处可添加路由跳转逻辑（例如：useRouter().push('/unselected-courses')）
}

const handleUncourseClick = ()=>{

  console.log("跳转到未选课程页面");
  router.push({
    path:'/course3',
    name: 'course3', // 路由名称
    query: { username: username.value } // 传递用户名到下一页
  });
}
</script>



<style scoped>
.course-side-border {
  display: flex;
  min-height: 100vh;
}

.left-border {
  width: 200px;
  padding: 20px;
  border-right: 1px solid #e4e7ed; /* 左侧边框线 */
  display: flex;
  flex-direction: column;
  align-items: center;
  background-color: #f8f9fa; /* 浅灰色背景 */
}

.course-button {
  width: 140px;
  height: 50px;
  margin: 10px 0;
  font-size: 16px;
  transition: all 0.3s ease; /* 点击动画 */
}

.course-button:hover {
  transform: translateY(-2px);
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
}

.right-content {
  flex: 1;
  padding: 30px;
  background-color: #ffffff; /* 白色背景 */
}

.empty-placeholder {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  color: #666;
  font-size: 18px;
}
</style>