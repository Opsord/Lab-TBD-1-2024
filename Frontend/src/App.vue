<script setup>
import './assets/base.css'
import MainTabs from "./components/MainTabs.vue"
</script>

<template>

  <main>

    <div class="flex flex-col h-svh w-auto bg-zinc-900 text-zinc-200 p-4 flex-grow">
      <div class="flex justify-center items-center">
        <MainTabs />
      </div>
      <RouterView />
    </div>
  </main>

</template>
