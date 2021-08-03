<template>
  <div class="brewery-details">
    <div id="name"><h1>{{brewery.name}}</h1></div>
    <div id="location"><h3>{{brewery.address}} {{brewery.city}}, {{brewery.state}}, {{brewery.zip}}</h3></div>
    <div id="history"><h2>History</h2>
    <h3>{{brewery.history}}</h3>
    </div>
    <div id="contact-info"><h2>Contact US:</h2>
    <h3>{{brewery.phone}} | {{brewery.email}}</h3>
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
      brewery: {
        breweryId: 0,
        name: "",
        address: "",
        city: "",
        state: "",
        zip: 0,
        phone: "",
        email: "",
        history: "",
        active: true
      },
      beerList: []
    }
  }, 
  created(){
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.brewery = response.data;
    });
    beerService.getBeerByBrewery(this.$route.params.id).then(response =>{
      this.beerList = response.data;
    });
  }
}


</script>

<style>

</style>