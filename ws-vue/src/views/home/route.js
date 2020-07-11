export default [
  {
    path: '/homepage',
    name: 'Homepage',
    component: () => import('./homepage.vue')
  },
  {
    path: '/testView',
    name: 'testView',
    component: () => import('./test.vue')
  }
]
