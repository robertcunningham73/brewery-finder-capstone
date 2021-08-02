<template>
  <div class="container" id="app">
     <div id="nav"> 
      <nav-bar />
    
     </div>
      <router-view />
    
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'
export default {
  components: { NavBar },
  
}
</script>
<style>
  /* #right-bar {
    grid-area: right-display;
    text-align: center;
  } */

  .nav-container {
    grid-area: left-display;
    text-align: center;
  }
  
  .container{
    display: grid;
    grid-template-columns: 1fr 3fr;
    grid-template-areas: 
        "left-display right-display";
    
  }
</style>
