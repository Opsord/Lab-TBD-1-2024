<script setup>
import '../assets/base.css'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
</script>

<template>

    <Tabs default-value="account">
        <TabsList>
            <TabsTrigger value="inicio">
                <RouterLink to="/">Inicio</RouterLink>

            </TabsTrigger>
            <TabsTrigger value="ingreso">

                <RouterLink to="/crearEmergencia">
                    Ingreso de Emergencia
                </RouterLink>
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