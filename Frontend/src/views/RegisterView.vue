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
                        <label for="sexo" class="text-sm">Rol</label>
                        <select class="px-3 py-2 border border-gray-400 rounded text-sm">
                            <option value="">Rol</option>
                            <option value="">Coordinador</option>
                            <option value="">Voluntario</option>    
                        </select>
                    </div>
                    <div></div>
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
                    <div class="flex justify-between">
                        <div class="flex flex-col gap-2">
                            <label for="edad" class="text-sm">Edad</label>
                            <select class="w-32 px-3 py-2 border border-gray-400 rounded text-sm">
                                <option value="">Edad</option>
                                <option value=""></option>
                            </select>
                        </div>
                        <div class="flex flex-col gap-2">
                            <label for="sexo" class="text-sm">Sexo</label>
                            <select class="w-32 px-3 py-2 border border-gray-400 rounded text-sm">
                                <option value="">Sexo</option>
                                <option value="">Masculino</option>
                                <option value="">Femenino</option>
                                <option value="">No binario</option>
                            </select>
                        </div>
                    </div>
                    <div class="flex items-end gap-6 my-1">
                        <label for="disponibilidad" class="text-sm">¿Estás disponible?</label>
                        <div class="flex items-center space-x-2">
                            <input type="radio" name="disponibilidad">
                            <label for="disponibilidad-si" class="text-sm">Sí</label>
                        </div>
                        <div class="flex items-center space-x-2">   
                            <input type="radio" name="disponibilidad">
                            <label for="disponibilidad-no" class="text-sm">No</label>
                        </div>
                    </div>
                    <div class="col-span-2 flex justify-center">
                        <button class="w-fit px-8 py-2 bg-amber-500 text-white font-medium uppercase tracking-widest rounded-full hover:bg-amber-600">
                        Registrarse
                        </button>
                    </div>
                </div>
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