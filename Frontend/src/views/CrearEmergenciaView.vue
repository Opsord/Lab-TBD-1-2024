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

const formModel = ref({
    tituloEmergencia: '',
    estadoEmergencia: true,
    descripcionEmergencia: '',
    tipoAtributo: '',

});
// Tengo como idea para marcar los que no necesitan
// Solo agregar otro textbox donde se indica que NO se necesita
// El input de atributo será separado por commas
// Para mandar a backend, tomo estos dos datos del json, si viene de SI, marcar con 1 sino 0

function onSubmit() {
    console.log('Form submitted!', JSON.stringify(formModel.value, null, 2))
}
</script>
<template>
    <div class="flex flex-col justify-center items-center align-middle h-full  ">
        <form class=" space-y-4" @submit="onSubmit">
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
