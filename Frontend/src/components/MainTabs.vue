<script setup>
import '../assets/base.css'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
</script>

<template>
    <div class="flex flex-row justify-center align-middle bg-gray-50 shadow mb-4">
        <Tabs default-value="account">
            <TabsList>
                <TabsTrigger value="inicio">
                    <RouterLink to="/">Inicio</RouterLink>
                </TabsTrigger>
                <TabsTrigger value="ingreso">
                    <RouterLink to="/crearEmergencia">
                        Registrar Emergencia
                    </RouterLink>
                </TabsTrigger>
                <TabsTrigger value="emergencias">
                    <RouterLink to="/verEmergencia">
                        Emergencias Activas
                    </RouterLink>
                </TabsTrigger>
                <TabsTrigger value="finalizadas">
                    Emergencias Finalizadas
                </TabsTrigger>
            </TabsList>
        </Tabs>
    </div>
</template>