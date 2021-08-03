<template>
  <main class="beer-details" >
<h1>
  {{beer.name}}
</h1>

<h4>
  {{beer.type}}
</h4>

<h4>
  ABV {{beer.abv}} | Type {{beer.beerType}}
</h4>

<h3>
  Description: {{beer.description}}
</h3>
<div v-for="review in reviews" v-bind:key="review.reviewId">
  {{beer.reviews}}
</div>
  </main>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: "beer-details", 
  props: {
    beerId: Number
  }, 
  data(){
    return{
      beer:{
        beerId: 0,
        name: "",
        abv: 0.0,
        description: "",
        beerType: "",
        active: false,
        reviews: []
    }
  }
  },
  created() {
    beerService.getBeer(this.$route.params.id).then(response =>{
      this.beer = response.data;
    })
  },
  methods: {
    
  }
}
</script>

<style>

</style>