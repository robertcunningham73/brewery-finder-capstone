<template>
  <div class="review-content">
    <div class="rating-display">Average Rating: {{ averageRating }}</div>
    <div id="review-list">
      <div>
        <button
          id="show-review-button"
          href="#"
          v-on:click.prevent="showReviews = true"
          v-if="showReviews === false"
          >Show Reviews</button>
        <button
          id="hide-review-button"
          href="#"
          v-on:click.prevent="showReviews = false"
          v-if="showReviews === true"
          >Hide Reviews</button>
        </div>
        <div class="review-display">
          <review-display v-if="showReviews === true" />
        </div>
      <div>
        <button
          id="show-form-button"
          href="#"
          v-on:click.prevent="showForm = true"
          v-if="showForm === false && this.$store.state.user.authorities[0].name == 'ROLE_USER'"
          >Add Review</button>
        </div>
        <div class="add-review-form">
          <review-form v-if="showForm === true"/>
        </div>
      </div>
   </div>   
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'
import ReviewForm from './ReviewForm.vue'


export default {
  name: 'review-list',
  components:{
    ReviewDisplay,
    ReviewForm
  },
  data(){
    return{
      showReviews: false,
      showForm: false
    }
  },
  computed: {
    averageRating() {
      const reviews = this.$store.state.beer.reviews;
      if (reviews) {
          let sum = reviews.reduce((currentSum, review) => {
          return currentSum + review.rating;
        }, 0);
        if (reviews.length > 0) {
          return (sum / reviews.length).toFixed(2) + " / 5";
        } else {
          return "No ratings available yet";
        }
      } 
      else {
        return "No ratings available yet";
      }
    }
  }
}

</script>

<style>

</style>