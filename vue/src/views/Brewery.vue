<template>
  <div>
    <brewery-details v-bind:breweryId="parseInt($route.param.id)"/>
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