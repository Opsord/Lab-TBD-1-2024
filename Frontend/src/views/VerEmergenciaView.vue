<template>
    <div class=" bg-green-500 flex justify-center items-center align-middle">
        <div v-if="emergencia && emergencia.length">
            <li v-for="data in emergencia" :key="data.idEmergencia">
                <h1 class=" text-xl">{{ data.tituloEmergencia }}</h1>
                <h2>{{ data.descripcionEmergencia }}</h2>
                Voluntarios registrados:
                <p v-for="voluntario in data.voluntarios">{{ voluntario.nombreVoluntario }} {{
                    voluntario.apellidoVoluntario }}</p>
            </li>
        </div>
    </div>
</template>


<script setup>
//http://localhost:8090/tarea/porIdEmergencia/4

import axios from 'axios'
import { ref, onMounted } from 'vue'

const emergencia = ref(null)

async function fetchEmergencia() {
    try {
        const response = await axios.get('http://localhost:8090/emergencias/activas');
        emergencia.value = response.data; // Make sure to adjust this according to the actual structure of your response
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}



async function fetchVoluntarios() {
    const rankingGet = "http://localhost:8090/ranking/obtenerRankingPorIdTarea/";
    if (emergencia.value && emergencia.value.length > 0) {
        try {
            const fetchPromises = emergencia.value.map(async (emergenciaEach) => {
                const response = await axios.get(`${rankingGet}${emergenciaEach.idEmergencia}`);
                const idVoluntario = response.data.map(ranking => ranking.idVoluntario)
                return { ...emergenciaEach, ids: idVoluntario };
            });
            emergencia.value = await Promise.all(fetchPromises); // Correctly await all promises
        } catch (error) {
            console.error('There was an error fetching the volunteers data:', error);
        }
    }
}

async function fetchVoluntariosData() {
    const voluntarioGet = "http://localhost:8090/voluntario/porId/";
    if (emergencia.value && emergencia.value.length > 0) {
        try {
            const fetchPromises = emergencia.value.map(async (emergenciaEach) => {
                const voluntarioPromises = emergenciaEach.ids.map(async (id) => {
                    const responseVoluntario = await axios.get(`${voluntarioGet}${id}`);
                    return responseVoluntario.data
                })
                return { ...emergenciaEach, voluntarios: await Promise.all(voluntarioPromises) };
            });
            emergencia.value = await Promise.all(fetchPromises); // Correctly await all promises
        } catch (error) {
            console.error('There was an error fetching the volunteers data:', error);
        }
    }
}
// If you want to fetch data when the component mounts
onMounted(async () => { await fetchEmergencia(); await fetchVoluntarios(); await fetchVoluntariosData() });

</script>