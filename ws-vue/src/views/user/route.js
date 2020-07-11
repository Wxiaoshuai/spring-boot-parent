export default [
  {
    path: '/login',
    name: 'Login',
    meta: {
      hideMenu: true
    },
    component: () => import('./Login.vue')
  },
  {
    path: '/userManagement',
    name: 'userManagement',
    component: () => import('./UserManagement.vue')
  },
  {
    path: '/createUser',
    name: 'createUser',
    component: () => import('./CreateUser')
  }
]
