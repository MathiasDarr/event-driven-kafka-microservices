import Vue from 'vue'
import Router from 'vue-router'

import Login from './components/Login'
import Register from './components/Register'
import Confirm from './components/Confirm'
// import Landing from './components/Landing'



Vue.use(Router)

export default new Router({
  mode:'history',
  base: process.env.BASE_URL,
  routes: [

    {
      path: '/',
      component: Login
    },
    {
      path:'/login',
      component: Login
    },

    {
      path:'/register',
      name:'register',
      component: Register
    },

    {
      path:'/confirm',
      name:'confirm',
      component: Confirm
    },

  ]
})
