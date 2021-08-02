<template>
  <nav class="nav-container">
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

</style>