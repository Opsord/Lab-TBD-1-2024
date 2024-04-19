<script setup>
import {
    FormControl,
    FormDescription,
    FormField,
    FormItem,
    FormLabel,
    FormMessage
} from '@/components/ui/form'
import { Input } from '@/components/ui/input'
import { Checkbox } from '@/components/ui/checkbox';
import { Button } from '@/components/ui/button';

import { ref } from 'vue';
import { Textarea } from "@/components/ui/textarea"
import ScrollArea from '@/components/ui/scroll-area/ScrollArea.vue';

// Separar esto en reqeust para emregencias y otro para los atributos
const formModel = ref({
    tituloEmergencia: '',
    estadoEmergencia: true,
    descripcionEmergencia: '',
    tipoAtributo: '',
    tipoAtributoIncompatibles: '',

});

import axios from 'axios'
import { onMounted } from 'vue'

const atributos = ref(null)

async function fetchAtributos() {
    try {
        const response = await axios.get('http://localhost:8090/atributos/todo');
        atributos.value = response.data; // Make sure to adjust this according to the actual structure of your response
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}

// If you want to fetch data when the component mounts
onMounted(fetchAtributos);
// Tengo como idea para marcar los que no necesitan
// Solo agregar otro textbox donde se indica que NO se necesita
// El input de atributo será separado por commas
// Para mandar a backend, tomo estos dos datos del json, si viene de SI, marcar con 1 sino 0

function onSubmit() {
    console.log('Form submitted!', JSON.stringify(formModel.value, null, 2))
}
</script>
<template>
    <div class="flex align-middle items-center justify-center mt-16">
        <form class=" space-y-4 flex flex-col" @submit="onSubmit">
            <FormField name="titulo">
                <FormItem>
                    <FormLabel>Titulo:</FormLabel>
                    <FormControl>
                        <Input type="text" placeholder="Titulo de la Emergencia" v-model="formModel.tituloEmergencia" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>

            <FormField name="descripcion">
                <FormItem>
                    <FormLabel>Descripción:</FormLabel>
                    <FormControl>
                        <Input type="text" placeholder="Descripción" v-model="formModel.descripcionEmergencia" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>


            <FormField name="atributos">
                <FormItem>
                    <FormLabel>Habilidades requeridas:</FormLabel>
                    <FormControl>
                        <Textarea type="text" placeholder="Ingrese separado por comas"
                            v-model="formModel.tipoAtributo" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>


            <h1>Habilidad de los voluntarios actuales:</h1>
            <div>
                <ScrollArea class="h-[100px]">
                    <div v-if="atributos && atributos.length">
                        <li v-for="data in atributos" :key="data.idAtributo">
                            * {{ data.atributo }}
                        </li>
                    </div>


                </ScrollArea>
            </div>


            <FormField name="atributos">
                <FormItem>
                    <FormLabel>Atributos no compatibles:</FormLabel>
                    <FormControl>
                        <Textarea type="text" placeholder="Ingrese separado por comas"
                            v-model="formModel.tipoAtributoIncompatibles" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>

            <FormField name="activa" type="checkbox" v-model="formModel.disponibilidad">
                <FormItem class="flex flex-row items-center align-middle space-x-2">
                    <FormLabel>¿Marcar como activa?</FormLabel>
                    <FormControl>
                        <Checkbox id="disponibilidad" :checked="formModel.estadoEmergencia"
                            @update:checked="value => formModel.estadoEmergencia = value" class="bg-slate-100 flex" />
                    </FormControl>
                    <FormMessage />
                </FormItem>
            </FormField>
            <Button variant="secondary" type="submit">
                Enviar
            </Button>
        </form>
    </div>
</template>
