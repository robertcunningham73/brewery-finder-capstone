<template>
  <div class="content">
    <brewery-details v-bind:breweryId="parseInt($route.params.breweryId)"/>
  
  <!-- <div id ="img-beers">
      <img :src="require(`@/assets/beers.jpg`)"/>
     </div> -->
     </div>
</template>

<script>
import BreweryDetails from "../components/BreweryDetails";

export default {
  components: {
    BreweryDetails
  }
}
</script>

<style>

</style>