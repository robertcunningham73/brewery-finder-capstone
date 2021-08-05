<template>
  <div class="review-form" >
   <form v-on:submit.prevent="addNewReview">
    <div class="form-element" >
      <label for="rating">Rating:</label>
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
    </div>
    <div class="form-element">
      <label for="review-body">Review</label>
      <textarea id="review" v-model="newReview.reviewBody"></textarea>
    </div>
    <div class="actions">
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
  </div>
</template>

<script>
import beerService from '../services/BeerService.js'

export default {
  name: "add-review",
  data() {
    return {
      newReview: {
        username: "",
        userId: 0,
        rating: 0,
        reviewBody: "",
      }
    };
  },  
  methods: {
    addNewReview() {
      this.newReview.username = this.$store.state.user.username;
      this.newReview.userId = this.$store.state.user.id;
      this.$store.state.beer.reviews.push(this.newReview);
      this.resetForm();
      //TODO: set up add
      const beer = {
        beerId: this.beer.beerId, 
        name: this.beer.name, 
        description: this.beer.description,
        abv: this.beer.abv, 
        beerType: this.beer.beerType,
        reviews: this.beer.reviews, 
        imagePath: this.beer.imagePath
      }
      beerService.addReview(beer)
      .then(response => {
        if(response.status == 200){
          this.$router.push(`/beer-list/${beer.beerId}`)
        }
      });
    },
      
    resetForm() {
      this.newReview = {};
    },
  }
}
</script>

<style>

</style>