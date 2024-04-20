<script setup>
import './assets/base.css'
import MainTabs from "./components/MainTabs.vue"
import NavBar from './components/NavBar.vue';
import SideBar from './components/SideBar.vue';
import { store } from './store.js';
</script>

<template>

  <main>
    <NavBar />
    <!-- <MainTabs v-if="store.token != null"/> -->
    <MainTabs />
    <div class="h-svh w-auto text-zinc-900 flex flex-col flex-grow">
      <RouterView />
    </div>
  </main>
</template>
