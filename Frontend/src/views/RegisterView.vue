<template>
    <div class="flex flex-col gap-8 mx-auto my-20 w-4/12">
        <div class="flex justify-center">
            <h2 class=" text-lg font-bold text-teal-600">¿Quieres formar parte de nosotros?</h2>
        </div>
        <div class="w-full p-8 bg-gray-50 border rounded-xl shadow-md">
            <h2 class="mb-8 text-center">Llena el siguiente formulario</h2>
            <form>
                <div class="grid gap-5 grid-cols-2">
                    <div class="flex flex-col gap-2">
                        <label for="nombre" class="text-sm">Nombre</label>
                        <input type="text" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="Nombre usuario">
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="apellido" class="text-sm">Apellido</label>
                        <input type="text" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="Apellido usuario">
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="correo" class="text-sm">Correo electrónico</label>
                        <input type="email" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="usuario@email.com">
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="contrasena" class="text-sm">Contraseña</label>
                        <input type="password" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="********">
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="rut" class="text-sm">RUT</label>
                        <input type="text" class="px-3 py-2 border border-gray-400 rounded text-sm" placeholder="12.345.678-9">
                    </div>
                </div>
                <div class="mb-6">
                    <label for="sexo" class="text-sm">Sexo</label>
                    <input type="radio" name="sexo">
                    <label for="masculino" class="text-sm">Masculino</label>
                    <input type="radio" name="sexo">
                    <label for="femenino" class="text-sm">Femenino</label>
                    <input type="radio" name="sexo">
                    <label for="no-binario" class="text-sm">No binario</label>
                </div>
                <div class="mb-6">
                    <label for="edad" class="text-sm">Edad</label>
                    <select>
                        <option value="">Seleccionar</option>
                        <option value=""></option>
                    </select>
                </div>
                <div class="mb-6">
                    <label for="disponibilidad" class="text-sm">Disponibilidad</label>
                    <input type="radio" name="disponibilidad">
                    <label for="disponibilidad-si" class="text-sm">Sí</label>
                    <input type="radio" name="disponibilidad">
                    <label for="disponibilidad-no" class="text-sm">No</label>
                </div>
                <button class="col-span-2 w-full px-3 py-2 bg-amber-500 text-white font-medium uppercase tracking-widest rounded-full hover:bg-amber-600">
                    Registrarse
                </button>
            </form>
        </div>
    </div>
</template>

<script>
import { useRouter } from "vue-router";
import { ref } from "vue";
import axios from 'axios';

const router = useRouter();
/* 
Formulario Register - Inputs
- rut
- nombre
- apellido
- edad
- sexo
- email
- contrasena
- disponibilidad

+ Asumiendo que solo se pueden registrar voluntarios
*/
</script>