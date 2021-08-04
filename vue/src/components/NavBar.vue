<template>
  <nav class="nav-container" id="left-bar">
    <router-link v-bind:to="{ name: 'home' }">Home</router-link>
      <router-link :to="{name: 'breweries'}">Breweries</router-link>
      <router-link :to="{name: 'beerList'}">All Beers</router-link>
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
  
  a {
    height: 60px;
    color: white;
    font-size: 26px;
  }

</style>