<template>
  <div class="review-list">
    <a
      id="show-review-button"
      href="#"
      v-on:click.prevent="showReviews = true"
      v-if="showReviews === false"
      >Show Reviews</a
    >
    <a
      id="hide-review-button"
      href="#"
      v-on:click.prevent="showReviews = false"
      v-if="showReviews === true"
      >Hide Reviews</a>
      <review-display v-if="showReviews === true" />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'

export default {
  name: 'review-list',
  components:{
    ReviewDisplay
  },
  data(){
    return{
      showReviews: false
    }
  }
  }

</script>

<style>

</style>