<template>
  <div id="app">
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
  .nav-container{
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  flex-basis: 15%;
}
</style>
