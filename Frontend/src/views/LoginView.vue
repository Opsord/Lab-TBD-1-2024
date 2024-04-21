<template>
    <div class="flex flex-col gap-8 mx-auto my-20 w-1/5">
        <div class="flex flex-col items-center gap-6">
            <img class="w-24 h-24" src="../assets/logo-sistema.png" alt="">
            <h2 class=" text-lg font-bold text-teal-600">¡Es un buen día para ayudar!</h2>
        </div>
        <div class="w-full p-8 bg-gray-50 border rounded-xl shadow-md">
            <h2 class="mb-8 text-center">Por favor, ingresa tus datos</h2>
            <form class="space-y-5">
                <div class="flex flex-col gap-2">
                    <label for="correo" class="text-sm">Correo electrónico</label>
                    <input v-model="correo" type="email" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="usuario@email.com"/>
                </div>
                <div class="flex flex-col gap-2">
                    <label for="contrasena" class="text-sm">Contraseña</label>
                    <input v-model="contrasena" type="password" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="********">
                </div>
                <ButtonPrimary @click="redirectToHome" buttonText="Ingresar"/>
                <div class="flex justify-center gap-2 text-sm">
                    <span>¿Aún no tienes cuenta?</span>
                    <button class="font-bold text-teal-600 hover:underline" @click="redirectToRegister">Registrate</button>
                </div>
            </form>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref } from "vue";
import { store } from "../store";
import axios from 'axios';
import ButtonPrimary from '../components/ButtonPrimary.vue';

const router = useRouter();

const correo = ref("");
const contrasena = ref("");

const redirectToHome = async () => {
    // Verificar datos validos
    // Guardar valores ingresados
    // Try-Catch
    // Llamar backend
    // Comprobar response
    // Guardar autenticacion en store
    // Router push

    console.log("Redirigiendo a /home");
    router.push('/home');
}


const redirectToRegister = () => {
    console.log("Redirigiendo a /register");
    router.push('/register');
}
</script>