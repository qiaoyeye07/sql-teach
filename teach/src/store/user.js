// src/store/user.js
import { defineStore } from 'pinia';

export const useUserStore = defineStore('user', {
  state: () => ({
    username: '', // 存储用户名
  }),
  actions: {
    // 设置用户名（登录成功时调用）
    setUsername(name) {
      this.username = name;
    },
  },
});