<template>
  <nav class="test" id="left-bar">
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
  flex-direction: column;
  flex-basis: 15%;
  max-width: 15%;
}
</style>