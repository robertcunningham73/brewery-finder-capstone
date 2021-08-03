<template>
  <div class="beer-details">
<h1>
  {{this.$store.state.beer.name}}
</h1>

<h4>
  {{this.$store.state.beer.type}}
</h4>

<h4>
  {{this.$store.state.beer.abv}}
</h4>

<h3>
  {{this.$store.state.beer.description}}
</h3>



  </div>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: "beer-details", 
  props: {
    beerId: Number
  }, 
  created() {
    beerService.getBeer(this.beerId)
    .then()

    //NEED TO BE COMPLETED
  }
}
</script>

<style>

</style>