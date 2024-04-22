<template>
    <div class="flex flex-col gap-8 mx-auto my-16 w-4/12">
        <div class="flex justify-center">
            <h2 class=" text-lg font-bold text-teal-600">¿Quieres formar parte de nosotros?</h2>
        </div>
        <div class="w-full p-8 bg-gray-50 border rounded-xl shadow-md">
            <h2 class="mb-8 text-center">Llena el siguiente formulario</h2>
            <form>
                <div class="grid gap-5 grid-cols-2">
                    <div class="flex flex-col gap-2">
                        <label for="rol" class="text-sm">Rol</label>
                        <select v-model="rol" class="px-3 py-2 border border-gray-400 rounded text-sm" required>
                            <option value="">Rol</option>
                            <option value="Coordinador">Coordinador</option>
                            <option value="Voluntario">Voluntario</option>
                        </select>
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="edad" class="text-sm">Institucion<span class="text-blue-700 ml-2">*
                                Coordinador</span></label>
                        <select v-model="institucion" class="px-3 py-2 border border-gray-400 rounded text-sm" required>
                            <option value="">Institucion</option>s
                            <option v-for="institucion in instituciones" :key="institucion.idInstitucion"
                                :value="institucion.idInstitucion">{{ institucion.nombreInstitucion }}</option>
                        </select>
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="nombre" class="text-sm">Nombre</label>
                        <Input v-model="nombre" type="text" placeholder="Nombre usuario" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="apellido" class="text-sm">Apellido</label>
                        <Input v-model="apellido" type="text" placeholder="Apellido usuario" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="email" class="text-sm">Correo electrónico</label>
                        <Input v-model="email" type="email" placeholder="usuario@email.com" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="contrasena" class="text-sm">Contraseña</label>
                        <Input v-model="contrasena" type="password" placeholder="********" />
                    </div>
                    <div class="flex flex-col gap-2">
                        <label for="rut" class="text-sm">RUT</label>
                        <Input v-model="rut" type="text" placeholder="12.345.678-9" />
                    </div>
                    <div class="flex flex-col justify-between">
                        <div class="flex flex-col gap-2">
                            <label for="edad" class="text-sm">Edad</label>
                            <select v-model="edad" class="w-32 px-3 py-2 border border-gray-400 rounded text-sm"
                                required>
                                <option value="">Edad</option>
                                <option v-for="edad in edades" :key="edad" :value="edad">{{ edad }}</option>
                            </select>
                        </div>
                        <div class="flex flex-col gap-2">
                            <label for="sexo" class="text-sm">Sexo</label>
                            <select v-model="sexo" class="w-32 px-3 py-2 border border-gray-400 rounded text-sm"
                                required>
                                <option value="">Sexo</option>
                                <option :value="true">Masculino</option>
                                <option :value="false">Femenino</option>
                            </select>
                        </div>
                    </div>
                    <div class="flex items-end gap-4 my-1 flex-wrap">
                        <label for="disponibilidad" class="w-full text-sm">¿Estás disponible?<span
                                class="text-blue-700"> * Voluntario</span></label>
                        <div class="flex items-center space-x-2">
                            <input v-model="disponibilidad" type="radio" name="disponibilidad" :value="true" required>
                            <label for="disponibilidadsi" class="text-sm">Sí</label>
                        </div>
                        <div class="flex items-center space-x-2">
                            <input v-model="disponibilidad" type="radio" name="disponibilidad" :value="false" required>
                            <label for="disponibilidadno" class="text-sm">No</label>
                        </div>
                    </div>
                    <ButtonPrimary @click="registerUser" buttonText="Registrarse" />
                </div>
            </form>
        </div>
    </div>
</template>

<script setup>
import { useRouter } from "vue-router";
import { ref, onMounted } from "vue";
import axios from 'axios';
import ButtonPrimary from '../components/ButtonPrimary.vue';
import Input from "../components/Input.vue";

const router = useRouter();

const rol = ref("");
const nombre = ref("");
const apellido = ref("");
const email = ref("");
const contrasena = ref("");
const rut = ref("");
const edad = ref("");
const sexo = ref("");
const disponibilidad = ref("");
const institucion = ref("");

const instituciones = ref([]);

const getInstituciones = async () => {
    try {
        const response = await axios.get('http://localhost:8090/institucion/todo');
        instituciones.value = response.data;
    } catch (error) {
        console.error(error);
    }
}

onMounted(getInstituciones);

const edades = ref([]);

for (let i = 18; i <= 60; i++) {
    edades.value.push(i);
}

const registerUser = async () => {
    if (rol.value === "Voluntario") {
        const data = {
            rut: rut.value,
            nombreVoluntario: nombre.value,
            apellidoVoluntario: apellido.value,
            edadVoluntario: edad.value,
            sexoVoluntario: sexo.value,
            email: email.value,
            contrasena: contrasena.value,
            disponibilidad: disponibilidad.value,
            role: rol.value.toUpperCase()
        }
        console.log("Voluntario")
        console.log(data);

        try {
            const response = await axios.post('http://localhost:8090/voluntarios/crear', data);
            console.log(response.data);
            redirectToLogin();
        } catch (error) {
            console.log("Error al registar un nuevo voluntario", error);
        }

        redirectToLogin();
    }
    else if (rol.value === "Coordinador") {
        const data = {
            rut: rut.value,
            nombre: nombre.value,
            apellido: apellido.value,
            email: email.value,
            contrasena: contrasena.value,
            idInstitucion: institucion.value,
            role: rol.value.toUpperCase()
        }

        console.log("Coordinador")
        console.log(data);

        try {
            const response = await axios.post('http://localhost:8090/coordinadores/crear', data);
            console.log(response.data);
            redirectToLogin();
        } catch (error) {
            console.log("Error al registar un nuevo coordinador", error);
        }
    }
}

const redirectToLogin = () => {
    console.log("Redirigiendo a /");
    router.push('/');
}
</script>