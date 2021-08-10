<template>
  <div class="content">
    <beer-details v-bind:beerId="this.beerId"/>
    <review-list />
  </div>
</template>

<script>
import BeerDetails from "../components/BeerDetails";
import ReviewList from '../components/ReviewList.vue';

export default {
  components: {
    BeerDetails,
    ReviewList
  },
  computed: {
    beerId() {
      return parseInt(this.$route.params.id);
    }
  }
}
</script>

<style>

</style>