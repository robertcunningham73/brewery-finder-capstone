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

  .nav-container {
    grid-area: left-display;
    text-align: center;
  }
  
  .container{
    display: grid;
    grid-template-columns: 1fr 3fr;
    grid-template-areas: 
        "left-display right-display";
    text-align: center;
  }

  #nav {
    height: 100%;
    width: 20%;
    position: fixed;
    left: 0;
    top: 0;
    padding-top: 20px;
    padding-bottom: 20px;
    overflow-x: hidden;
    background-color: rgb(255,243,176);
    border-top-right-radius: 15px;
    border: transparent;
    z-index: 1;
      }
</style>
