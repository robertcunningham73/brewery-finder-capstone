<template>
  <div class="content">
    <brewery-details v-bind:breweryId="parseInt($route.params.breweryId)"/>
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