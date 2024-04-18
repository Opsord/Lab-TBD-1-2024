<script setup>
import '../assets/base.css'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
</script>

<template>

    <div class="flex flex-row justify-center align-middle">
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
                    <RouterLink to="/verEmergencia">
                        Ver Emergencia Activas
                    </RouterLink>
                </TabsTrigger>
                <TabsTrigger value="finalizadas">
                    Emergencias Finalizadas
                </TabsTrigger>
            </TabsList>
        </Tabs>
    </div>
</template>