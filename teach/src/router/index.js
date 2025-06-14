import {createRouter,createWebHashHistory} from "vue-router"

const router=createRouter({
  history:createWebHashHistory(),
  routes:[
    {
      path:"/",
      component:() => import("@/views/login/index.vue")//登陆界面
    },

    {
      path:"/index",//访问此路径 出现的页面
      component:() => import("@/views/index/index.vue"),

      
    },

    {
        path:"/course1",name:'course1',
        component:() => import("@/views/course1.vue")//全部课程页面
    },
    
    {
        path:"/course2",name:'course2',
        component:() => import("@/views/About.vue")//已选课程页面
    },
    
    {
        path:"/course3",name:'course3',
        component:() => import("@/views/uncourse.vue")//已选课程页面
    }

  ]

})

export default router;