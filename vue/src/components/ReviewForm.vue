<template>
  <div class="review-content">
    <div id="review-form" >
    <form v-on:submit.prevent="addNewReview">
      <div class="form-element" >
        <label for="rating"><br>Rating</label>
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
        <button v-on:click.prevent="resetForm" type="cancel" >Cancel</button>
        <button>Submit</button>
      </div>
    </form>
    </div>
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
        beerId: this.$store.state.beer.beerId, 
        name: this.$store.state.beer.name, 
        description: this.$store.state.beer.description,
        abv: this.$store.state.beer.abv, 
        beerType: this.$store.state.beer.beerType,
        reviews: this.$store.state.beer.reviews, 
        imagePath: this.$store.state.beer.imagePath,
        active: this.$store.state.beer.active
      } 
      beerService.updateBeer(beer, this.$store.state.activeBrewery.breweryId)
      .then(response => {
        if(response.status == 200){
          //TODO: create Mutation that adds review to reviews store collection
          this.$store.commit("SET_ACTIVE_BEER", beer);
          //this.$store.commit("SET_BEER_LIST", response.data);
        }
      });
      
    },
      
    resetForm() {
      this.newReview = {};
      this.$parent.showForm = false;
    },
    
  }
}
</script>

<style>
label{
  display: flex;
justify-content: center;
}

textarea{
  background-color: #EFD6AC;
  border-radius: 3px;
}
select{
  background-color: #EFD6AC;
  border-radius: 3px;
}
</style>