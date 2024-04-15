<script setup>
import '../assets/base.css'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
</script>

<template>
    <Tabs default-value="account" class="w-[400px]">
        <TabsList>
            <TabsTrigger value="inicio">
                Inicio
            </TabsTrigger>
            <TabsTrigger value="ingreso">
                Ingreso de Emergencia
            </TabsTrigger>
            <TabsTrigger value="emergencias">
                Emergencias Activas
            </TabsTrigger>
            <TabsTrigger value="finalizadas">
                Emergencias Finalizadas
            </TabsTrigger>
        </TabsList>
    </Tabs>
</template>