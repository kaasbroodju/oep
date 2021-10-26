import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/grades',
    name: 'Grades',
    component: () => import('../views/Grades.vue')
  },
  {
    path: '/classes',
    name: 'Classes',
    component: () => import('../views/Classes.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
