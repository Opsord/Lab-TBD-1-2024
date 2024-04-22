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
import ScrollArea from '@/components/ui/scroll-area/ScrollArea.vue';

// Separar esto en reqeust para emregencias y otro para los atributos
const formModel = ref({
    tituloEmergencia: '',
    estadoEmergencia: true,
    descripcionEmergencia: '',
});

const habilidadModel = ref([])

import axios from 'axios'
import { onMounted } from 'vue'

const atributos = ref(null)

async function fetchAtributos() {
    try {
        const response = await axios.get('http://localhost:8090/atributos/todo');
        atributos.value = response.data;
    } catch (error) {
        console.error('There was an error fetching the user data:', error);
    }
}

async function crearEmergencia(emergency) {
    try {

        const response = await axios.post('http://localhost:8090/emergencias/crear', emergency, { headers: { 'Content-Type': 'application/json' } })
        return response.data.idEmergencia

    } catch (err) {
        console.log(err)

    }
}
async function createAtributoEmergencia(idEmergencia) {
    console.log(idEmergencia)
    const newModel = habilidadModel.value.map(habilidad => {
        return { ...habilidad, idEmergencia: idEmergencia }
    })
    try {
        const response = await axios.post('http://localhost:8090/emergenciaAtributo/crearVarios', newModel, { headers: { 'Content-Type': 'application/json' } })
        return response.data

    } catch (err) {
        console.log(err)

    }
}
// Hacemos fetch cuando se monta el componente
onMounted(fetchAtributos);

async function onSubmit() {
    const idEmergencia = await crearEmergencia(formModel.value)
    const atributosCreaddos = await createAtributoEmergencia(idEmergencia)
}

</script>
<template>
    <div class="flex align-middle items-center justify-center mt-4 ">
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

            <h1>Habilidades de los voluntarios actuales:</h1>
            <div>
                <ScrollArea class="h-[150px] w-[400px]">
                    <div v-if="atributos && atributos.length">
                        <li v-for="data in atributos.filter(item => !habilidadModel.some(seleccionado => seleccionado.idAtributo === item.idAtributo))"
                            :key="data.idAtributo" class=" break-inside-auto">
                            * {{ data.atributo }}
                            <Button type="button"
                                v-on:click="habilidadModel.push({ idAtributo: data.idAtributo, compatibilidad: 1 })">
                                ✅
                            </Button>
                            <Button type="button"
                                v-on:click="habilidadModel.push({ idAtributo: data.idAtributo, compatibilidad: 0 })">
                                ❌
                            </Button>
                        </li>
                    </div>
                </ScrollArea>
            </div>
            <h1>Habilidades seleccionadas:</h1>
            <div>
                <ScrollArea class="h-[200px] w-[400px] flex flex-col">
                    <div v-if="habilidadModel && habilidadModel.length">
                        <li v-for="data in habilidadModel" :key="data.idAtributo" class=" break-inside-auto flex">
                            * {{ atributos[data.idAtributo - 1].atributo }}
                            <p v-if="data.compatibilidad === 0" class="text-red-400">&nbsp;Incompatible
                            </p>
                            <Button type="button" v-on:click="habilidadModel.pop(this)">
                                ❌
                            </Button>
                        </li>
                    </div>
                </ScrollArea>
            </div>
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
            <Button variant="ghost" class="border border-zinc-600" type="button" v-on:click="onSubmit()">
                Enviar
            </Button>
        </form>
    </div>
</template>
