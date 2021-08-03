<template>
  <div class="list-beers">
    <!-- Might want to make a grid view rather than use a table -->
    
      <div v-for="beer in beerList" v-bind:key="beer.id"></div>
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.id}}" >{{ beer.name }}</router-link>
  </div>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: 'beer-list',
  data(){
    return {
      beerList: []
    }
  },
  created(){
    beerService.getBeerList().then(response => {
        this.beerList = response.data;
  });
  }
}
</script>

<style>

</style>