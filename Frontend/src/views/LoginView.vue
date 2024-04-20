<template>
    <div class="flex flex-col justify-center items-center gap-8 w-2/4 m-auto">
        <div class="flex flex-col justify-center items-center gap-6">
            <img class="w-24 h-24" src="../assets/logo-sistema.png" alt="">
            <h2 class=" text-lg font-bold text-teal-600">¡Es un buen día para ayudar!</h2>
        </div>
        <div class="p-8 bg-gray-50 border rounded-xl shadow-md">
            <h2 class="mb-8 text-center">Por favor, ingresa tus datos</h2>
            <form>
                <div class="">
                    <label for="correo">Correo electrónico</label>
                    <input v-model="correo" type="email"/>
                </div>
                <div class="form-group">
                    <label for="contrasena">Contraseña</label>
                    <input v-model="contrasena" type="password" />
                </div>
                <button class="button">
                    Ingresar
                </button>
                <div class="">
                    <span>Aún no tienes cuenta? </span>
                    <a href="">Registrate aquí</a>
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