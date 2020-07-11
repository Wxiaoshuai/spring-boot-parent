import Vue from 'vue'
import Router from 'vue-router'
import DefaultRoute from './default_route'
import UserRoute from '../views/user/route'
import HomeRoute from '../views/home/route'
import {getCookie} from "../util/CookieUtil";

Vue.use(Router)

const baseRoutes = []
let MyRoutes = baseRoutes.concat(DefaultRoute, UserRoute, HomeRoute)


const router = new Router({
  mode: 'history',  //h5模式，地址栏不用加 #
  routes: MyRoutes,
  isShowMenu: true
})

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  if (getCookie('login') || to.name == 'Login') {
    next()
  } else {
    next('/login')
  }
})

export default router
