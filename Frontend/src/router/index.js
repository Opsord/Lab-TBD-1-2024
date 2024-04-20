import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import LoginView from '@/views/LoginView.vue';
import CrearEmergenciaView from '../views/CrearEmergenciaView.vue'
import VerEmergenciaView from '../views/VerEmergenciaView.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: HomeView
    },
    {
      path: '/',
      name: 'login',
      component: LoginView
    },
    {

      path: '/crearEmergencia',
      name: 'Crear Emergencia',
      component: CrearEmergenciaView,

    },
    {
      path: '/verEmergencia',
      name: 'Ver emergencia',
      component: VerEmergenciaView,
    }
  ]
})

export default router
