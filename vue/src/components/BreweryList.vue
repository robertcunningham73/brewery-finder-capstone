<template>
<div class="brewery-list">
  <h1>All Breweries</h1>
    <div v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.breweryId">
        <router-link v-bind:to="{ name: 'brewery', params:{id: brewery.breweryId}}" >{{ brewery.name }}</router-link>
    </div>
</div>
  
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: 'brewery-list',
  methods: {
    getBreweries(){
      beerService.getBreweries().then(response => {
        this.$store.commit("SET_BREWERIES", response.data);
      });
    }
  }, 
  created(){
    this.getBreweries();
  }
}

</script>

<style>
.brewery-list a{ 
  color: #183A37;
}
</style>