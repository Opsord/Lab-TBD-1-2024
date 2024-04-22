import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import RegisterView from '../views/RegisterView.vue';
import CrearEmergenciaView from '../views/CrearEmergenciaView.vue'
import VerEmergenciaView from '../views/VerEmergenciaView.vue';
import VerEmergenciaFinalizadaView from '../views/VerEmergenciaFinalizadaView.vue';

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
      path: '/register',
      name: 'register',
      component: RegisterView
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
    },
    {
      path: '/emergenciaFinalizadas',
      name: 'Ver emergencia finalizadas',
      component: VerEmergenciaFinalizadaView,
    }
  ]
})

export default router
