<template>
    <div class="flex justify-center items-center align-middle m-4">
        <div v-if="emergencia && emergencia.length">
            <div v-for="data in emergencia" :key="data.idEmergencia">
                <Card>
                    <CardHeader>
                        <CardTitle>{{ data.tituloEmergencia }}</CardTitle>
                        <CardDescription>
                            Tareas registradas:
                            <p v-for="tarea in data.tareas">
                                {{ tarea.tipoTarea }}</p>
                        </CardDescription>
                    </CardHeader>
                    <CardContent>
                        {{ data.descripcionEmergencia }}
                    </CardContent>
                    <CardFooter class=" whitespace-pre-line">
                        <p>Voluntarios registrados:</p>
                        <p v-for="voluntario in data.voluntarios">
                            &nbsp;
                            {{ voluntario.nombreVoluntario }} {{
                                voluntario.apellidoVoluntario }}
                        </p>

                    </CardFooter>

                </Card>

            </div>
        </div>
    </div>
</template>


<script setup>
//http://localhost:8090/tarea/porIdEmergencia/4

import axios from 'axios'
import { ref, onMounted } from 'vue'
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
} from "@/components/ui/card"

const emergencia = ref(null)

async function fetchEmergencia() {
    try {
        const response = await axios.get('http://localhost:8090/emergencias/finalizadas');
        emergencia.value = response.data; // Make sure to adjust this according to the actual structure of your response
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}


async function fetchTarea() {
    const tareaGet = "http://localhost:8090/tarea/porIdEmergencia/";
    if (emergencia.value && emergencia.value.length > 0) {
        try {
            const fetchPromises = emergencia.value.map(async (emergenciaEach) => {
                const response = await axios.get(`${tareaGet}${emergenciaEach.idEmergencia}`);
                const tareas = response.data
                return { ...emergenciaEach, tareas: tareas };
            });
            emergencia.value = await Promise.all(fetchPromises); // Correctly await all promises
        } catch (error) {
            console.error('There was an error fetching the volunteers data:', error);
        }
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
    const voluntarioGet = "http://localhost:8090/voluntarios/porId/";
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
onMounted(async () => { await fetchEmergencia(); await fetchTarea(); await fetchVoluntarios(); await fetchVoluntariosData() });

</script>