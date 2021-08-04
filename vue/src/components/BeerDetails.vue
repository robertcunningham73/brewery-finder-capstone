<template>
  <main class="beer-details" >
<h1>
  {{this.$store.state.beer.name}}
</h1>

<h4>
  {{this.$store.state.beer.type}}
</h4>

<h4>
  ABV {{this.$store.state.beer.abv}} | Type {{this.$store.state.beer.beerType}}
</h4>

<h3>
  Description: {{this.$store.state.beer.description}}
</h3>
<img v-bind:src="this.$store.state.beer.imagePath" alt="this.$store.state.beer.name" />
<!-- <div v-for="review in reviews" v-bind:key="review.reviewId">
  {{this.$store.state.beer.reviews}}
</div> -->
  </main>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: "beer-details", 
  props: {
    beerId: Number
  }, 
  created() {
    beerService.getBeer(this.$route.params.id).then(response =>{
      this.$store.commit("SET_ACTIVE_BEER", response.data);
    })
  },
  
}
</script>

<style>

</style>