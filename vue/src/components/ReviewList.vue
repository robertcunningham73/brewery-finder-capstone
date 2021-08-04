<template>
  <div class="review-list">
    <review-display />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'

export default {
  name: 'review-list',
  components:{
    ReviewDisplay
  },
  computed: {
    filteredReviews(){
      const beer = this.$store.state.beerList.find(
        b => b.beerId == this.$store.state.beer
      );
      const reviewsFilter = this.$store.state.filter;
      return beer.reviews.filter(review => {
        return reviewsFilter === 0 ? true : reviewsFilter === review.rating;
      });
    }
  }
}
</script>

<style>

</style>