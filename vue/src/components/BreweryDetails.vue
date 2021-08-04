<template>
  <div class="brewery-details">
    <div id="name"><h1>{{this.$store.state.activeBrewery.name}}</h1></div>
    <div id="location"><h3>{{this.$store.state.activeBrewery.address}} {{this.$store.state.activeBrewery.city}}, {{this.$store.state.activeBrewery.state}}, {{this.$store.state.activeBrewery.zip}}</h3></div>
    <div id="history"><h2>History</h2>
    <h3>{{this.$store.state.activeBrewery.history}}</h3>
    </div>
    <div id="contact-info"><h2>Contact US:</h2>
    <h3>{{this.$store.state.activeBrewery.phone}} | {{this.$store.state.activeBrewery.email}}</h3>
    </div>
    <div class="beer-list" v-for="beer in beerList" v-bind:key="beer.beerId">
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.beerId}}" >{{ beer.name }}></router-link>
    </div>
  </div>
</template>

<script>
import beerService from '@/services/BeerService.js';

export default {
name: "brewery-details",
data(){
  return {
    beerList: []
  }
},
  
  created(){
    beerService.getBeerByBrewery(this.$route.params.id).then(response =>{
      this.beerList = response.data;
    }); 
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
    });
  }
}


</script>

<style>

</style>