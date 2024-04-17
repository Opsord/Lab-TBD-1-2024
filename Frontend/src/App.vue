<script setup>
import { RouterLink, RouterView } from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
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
  </main>
  <!-- <img alt="Vue logo" class="logo" src="@/assets/logo.svg" width="125" height="125" />
    <div class="wrapper">
      <HelloWorld msg="You did it!" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav> -->

</template>
