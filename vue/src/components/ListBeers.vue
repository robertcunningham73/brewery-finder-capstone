<template>
<div class="content">
  <div class="list-beers">
    <h1>All Beers</h1>
    <div v-for="beer in beerList" v-bind:key="beer.id">
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.beerId}}" >{{ beer.name }}</router-link>
    </div>
  </div>
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