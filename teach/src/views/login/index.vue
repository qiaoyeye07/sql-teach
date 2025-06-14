<template>
  <div class="login-container">
    <!-- 新增的顶部区域，可用于显示一些提示或用户名相关简易信息，这里先做示例 -->
    <div class="top-info">
      <p>欢迎来到选课系统</p>
      <!-- 若后续有需求，可在这里结合登录状态展示具体用户名，比如登录后显示等，目前先留空做布局 -->
      <p class="username-placeholder" v-if="!form.username">请输入用户名进行登录</p>
    </div>
    <el-form 
      ref="loginForm" 
      :model="form" 
      :rules="rules" 
      label-width="80px" 
      class="login-form"
    >
      <el-form-item label="用户名" prop="username">
        <el-input 
          v-model="form.username" 
          placeholder="请输入用户名" 
          prefix-icon="el-icon-user"
        />
      </el-form-item>
      <el-form-item label="密码" prop="password">
        <el-input 
          v-model="form.password" 
          type="password" 
          placeholder="请输入密码" 
          prefix-icon="el-icon-lock"
        />
      </el-form-item>
      <el-form-item>
        <el-button 
          type="primary" 
          @click="handleLogin" 
          :loading="loading"
        >
          登录
        </el-button>
      </el-form-item>
    </el-form>
    <!-- 错误提示 -->
    <div class="error" v-if="errorMsg">{{ errorMsg }}</div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue';
import { ElMessage } from 'element-plus';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();
const form = reactive({
  username: '',
  password: ''
});
const rules = reactive({
  username: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
  password: [{ required: true, message: '请输入密码', trigger: 'blur' }]
});
const loading = ref(false);
const errorMsg = ref('');

const handleLogin = async () => {
  loading.value = true;
  errorMsg.value = '';
  
  try {
    // 1. 先调用后端接口，根据用户名查用户信息（含密码）
    const res = await axios.post('http://localhost:8081/login', {
      username: form.username // 仅传用户名
    });
    
    if (res.data.code === 200) {
      const userFromBackend = res.data.user;
      // 2. 前端比对密码
      if (form.password === userFromBackend.password) {
        ElMessage.success('登录成功');
        
        router.push({
          path: '/index', // 路由路径
          query: { username: form.username } // 传递查询参数
        });

      } else {
        errorMsg.value = '密码错误';
      }
    } else {
      errorMsg.value = res.data.message; // 用户名不存在等错误
    }
  } catch (error) {
    errorMsg.value = '网络异常，请重试';
    console.error('登录失败：', error);
  } finally {
    loading.value = false;
  }
};
</script>

<style scoped>
/* 整个登录容器的样式调整 */
.login-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: linear-gradient(120deg, #fdfbfb 0%, #ebedee 100%); /* 新增渐变背景，使页面更美观 */
}

/* 顶部信息区域样式 */
.top-info {
  text-align: center;
  margin-bottom: 20px;
}

.top-info p {
  margin: 5px 0;
  font-size: 16px;
  color: #333;
}

.username-placeholder {
  color: #999;
  font-size: 14px;
}

/* 表单区域样式调整 */
.login-form {
  width: 360px;
  padding: 30px; /* 加大内边距，让表单更舒展 */
  background: #fff;
  border-radius: 10px; /* 增大圆角，视觉更柔和 */
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* 增强阴影效果，突出表单 */
}

/* 错误提示样式优化 */
.error {
  margin-top: 15px;
  color: #f56c6c;
  text-align: center;
  font-size: 14px;
}

/* 按钮样式微调（可根据实际需求进一步调整） */
.el-button--primary {
  width: 100%; /* 让按钮充满表单 item 宽度，更美观 */
}
</style>