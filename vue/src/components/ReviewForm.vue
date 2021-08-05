<template>
  <div class="review-form" v-bind:key="review.id">
   <form v-on:submit.prevent="addNewReview">
    <div class="form-element">
      <label for="reviewer">Name:</label>
      <input id="reviewer" type="text" v-model="newReview.reviewer" />
    </div>
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
      this.newReview.username = this.$store.state.currentuser.username;
      this.newReview.userId = this.$store.state.currentuser.userId;
       this.beer.reviews.push(this.newReview);
       resetForm();
    },
      
    resetForm() {
      this.newReview = {};
    }
  }
}
</script>

<style>

</style>