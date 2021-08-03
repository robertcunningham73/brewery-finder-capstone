<template>
  <div class="brewery-details">
    <h1>{{brewery.name}}</h1>
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
      }
    }
  }, 
  created(){
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.brewery = response.data;
    });
  }
}


</script>

<style>

</style>