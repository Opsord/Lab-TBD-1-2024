<template>
    <div class="flex flex-col justify-center items-center gap-8 m-auto w-1/5">
        <div class="flex flex-col justify-center items-center gap-6">
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
                <button class="w-full px-3 py-2 bg-amber-500 text-white font-medium uppercase tracking-widest rounded-full hover:bg-amber-600">
                    Ingresar
                </button>
                <div class="flex justify-center gap-2 text-sm">
                    <span>¿Aún no tienes cuenta?</span>
                    <a href="" class="font-bold text-teal-600 hover:underline">Registrate</a>
                </div>
            </form>
        </div>
    </div>
</template>

<script>
import { useRouter } from "vue-router";
import { ref } from "vue";
import { store } from "../store";
import axios from 'axios';

const router = useRouter();

const correo = ref("");
const contrasena = ref("");

</script>

<style>
</style>