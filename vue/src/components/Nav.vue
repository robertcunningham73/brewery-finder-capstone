<template>
  <nav class="nav-container">
      <router-link :to="{name: 'breweries'}">Breweries</router-link>
      <router-link :to="{name: 'beerList'}">All Beers</router-link>
  </nav>
</template>

<script>
export default {

}
</script>

<style>
.nav-container{
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
}
</style>