<template>
<div class="content">
  <div class="list-beers">
    <h1>All Beers</h1>
    <div v-for="beer in this.$store.state.beerList" v-bind:key="beer.id">
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.beerId}}" >{{ beer.name }}</router-link>
    </div>
  </div>
   <div id="brewery-list-img">
      <img :src="require(`@/assets/casks.jpg`)"/>
    </div>
  </div>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: 'beer-list',
  methods: {
    getBeerList(){
    beerService.getBeerList().then(response => {
      this.$store.commit("SET_BEER_LIST", response.data);
    });
  }
  },
  created(){
    this.getBeerList();
  }
}
</script>

<style>

</style>