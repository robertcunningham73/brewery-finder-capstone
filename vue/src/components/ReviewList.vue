<template>
  <div class="review-list">
    <div>
      <a
        id="show-review-button"
        href="#"
        v-on:click.prevent="showReviews = true"
        v-if="showReviews === false"
        >Show Reviews</a>
      <a
        id="hide-review-button"
        href="#"
        v-on:click.prevent="showReviews = false"
        v-if="showReviews === true"
        ><br>Hide Reviews</a>
      </div>
      <div class="rating-display">{{ averageRating }} Average Rating:</div>
      <div class="review-display">
        
        <review-display v-if="showReviews === true" />
      </div>
    
    <div>
      <a
        id="show-form-button"
        href="#"
        v-on:click.prevent="showForm = true"
        v-if="showForm === false && this.$store.state.user.authorities[0].name == 'ROLE_USER'"
        ><br>Add Review</a>
      </div>
      <div class="add-review-form">
        <review-form v-if="showForm === true"/>
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
  //TODO create avg rating method
  computed: {
    averageRating() {
      const reviews = this.$store.state.beer.reviews;
      let sum = reviews.reduce((currentSum, review) => {
        return currentSum + review.rating;
      }, 0);
      return (sum / reviews.length).toFixed(2);
    }
  }
  }

</script>

<style>

</style>