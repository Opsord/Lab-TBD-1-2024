<template>
    <div class=" bg-red-500">
        <h1>Esto es ver emergencia</h1>
        <h1>Esto es ver emergencia</h1>

        <div v-if="user && user.length">
            <li v-for="data in user" :key="data.idEmergencia">
                {{ data.tituloEmergencia }}
            </li>
        </div>
    </div>
</template>


<script setup>
import axios from 'axios'
import { ref, onMounted } from 'vue'

const user = ref(null)

async function fetchUserData() {
    try {
        const response = await axios.get('http://localhost:8090/emergencia/todo');
        user.value = response.data; // Make sure to adjust this according to the actual structure of your response
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}

// If you want to fetch data when the component mounts
onMounted(fetchUserData);
</script>