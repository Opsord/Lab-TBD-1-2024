<script setup>
import './assets/base.css'
import MainTabs from "./components/MainTabs.vue"
import NavBar from './components/NavBar.vue';
</script>

<template>

  <main>

<!--     <div class="h-screen w-screen  bg-zinc-900 text-zinc-200 p-4">
      <div class="flex flex-row  justify-center md:mr-56 ">
        <MainTabs />
      </div>
      <div class=" h-full flex flex-auto justify-center align-middle items-center">
        <h1 class=" text-4xl"> Sistema de Emergencia Metropolitana</h1>

      </div>
    </div> -->

    <NavBar />
    <div class="flex flex-col h-svh w-auto bg-zinc-900 text-zinc-200 p-4 flex-grow">
      <div class="flex justify-center items-center">
        <MainTabs />
      </div>
      <RouterView />
    </div>
  </main>

</template>
