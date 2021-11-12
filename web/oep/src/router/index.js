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
  },
  {
    path: '/class/:className',
    name: 'Class',
    component: () => import('../views/Class.vue'),
    children: [
      {
        path: '',
        component: () => import('../views/classviews/ClassHomepage')
      }
    ]
  }
]

export default routes
