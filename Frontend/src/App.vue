<script setup>
import './assets/base.css'
import MainTabs from "./components/MainTabs.vue"
import NavBar from './components/NavBar.vue';
import SideBar from './components/SideBar.vue';
</script>

<template>

  <main>
    <NavBar />
    <div class="h-svh w-auto bg-zinc-50 text-zinc-900 flex flex-col flex-grow">
      <MainTabs />
      <RouterView />
    </div>
  </main>
</template>
