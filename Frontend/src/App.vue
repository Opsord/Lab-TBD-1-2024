<script setup>
import './assets/base.css'
import MainTabs from "./components/MainTabs.vue"
import NavBar from './components/NavBar.vue';
import SideBar from './components/SideBar.vue';
</script>

<template>

  <main>
    <NavBar />
    <div class="grid grid-cols-6">
      <div class="col-span-1">
        <SideBar />
      </div>
      <div class="col-span-5">
        <div class="h-svh w-auto bg-zinc-900 text-zinc-200 p-4 flex flex-col flex-grow">
          <MainTabs />
          <RouterView />
        </div>
      </div>
    </div>
  </main>
</template>
