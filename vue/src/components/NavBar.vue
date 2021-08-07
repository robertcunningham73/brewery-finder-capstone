<template>
  <nav class="nav-links" id="left-bar">
    <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
    <router-link :to="{name: 'breweries'}" v-if="$store.state.token != ''">Breweries</router-link> 
    <router-link :to="{name: 'beerList'}" v-if="$store.state.token != ''">All Beers</router-link>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
  </nav>
</template>

<script>
export default {
 
}
</script>

<style>

  #left-bar{
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-direction: column;
  height: 100%;
  }

  .nav-links a{
    color: #EFD6AC;
  }
  
  a {
    height: 60px;
    color: #183A37;
    font-size: 26px;
  } 

  

</style>