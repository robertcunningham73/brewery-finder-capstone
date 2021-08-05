<template>
  <div class="content">
    <beer-details />
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
  }
}
</script>

<style>

</style>