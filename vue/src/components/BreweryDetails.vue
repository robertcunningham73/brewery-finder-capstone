<template>
  <div class="brewery-details">
    <h1>{{ this.$store.state.activeBrewery }}</h1>
      
  </div>
</template>

<script>
import beerService from '@/services/BeerService.js';

export default {
name: "brewery-details",
props: {
  breweryId: Number
},
  /* data(){
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
  }, */
  created(){
    beerService.getBrewery(this.breweryId).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
  });
}
}
</script>

<style>

</style>