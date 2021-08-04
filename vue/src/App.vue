<template>
  <div class="container1" id="app">
      <nav-bar class="nav1"/>
      <router-view class="content1"/>
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'
export default {
  components: { NavBar },
  
}
</script>
<style>

  html {
    height: 100%;
  }

  body {
    height: 100%;
    margin: 0;
    border: 0;
  }

  .container1 {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: row;
  }

  .nav1 {
    width: 170px;
    padding-top: 25px;
    background: linear-gradient(#183A37, #335c67);
    position: fixed;
    
  }

  .content1 {
    padding-top: 25px;
    flex: 1 0 auto;
    text-align: center;
    background: linear-gradient(rgb(224,159,62), rgb(158,42,43));
    }

  /* .nav-container {
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
    background: linear-gradient(#183A37, #335c67);
    border-top-right-radius: 15px;
    border: transparent;
    z-index: 1;
      } */
</style>
