<template>
  <div class="container" id="app">
     <div id="nav"> 
      <nav-bar />
     <router-view />
     </div>
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'
export default {
  components: { NavBar },
  
}
</script>
<style>

  
  .test{
    grid-template-columns: 1fr 3fr;
    grid-template-rows: auto;
  }
</style>
