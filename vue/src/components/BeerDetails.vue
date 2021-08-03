<template>
  <div class="beer-details">
<h1>
  {{beer.name}}
</h1>

<h4>
  {{beer.type}}
</h4>

<h4>
  {{beer.abv}}
</h4>

<h3>
  {{beer.description}}
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
  data(){
    return{
      beer:{
        beerId: 0,
        name: "",
        abv: 0.0,
        description: "",
        beerType: "",
        active: false
    }
  }
  },
  created() {
    beerService.getBeer(this.$route.params.id).then(response =>{
      this.beer = response.data;
    })
  }
}
</script>

<style>

</style>