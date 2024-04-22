<script setup>
import '../assets/base.css'
import { Tabs, TabsContent, TabsList, TabsTrigger } from '@/components/ui/tabs'
</script>

<template>
    <div class="flex flex-row justify-center align-middle bg-gray-50 border-b border-gray-200">
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
                    <RouterLink to="/emergenciaFinalizadas">
                        Emergencias Finalizadas
                    </RouterLink>

                </TabsTrigger>
            </TabsList>
        </Tabs>
    </div>
</template>