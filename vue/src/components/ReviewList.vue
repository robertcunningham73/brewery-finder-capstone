<template>
  <div class="review-list">
    <h1>Reviews</h1>
    <div v-for="review in reviewList" v-bind:key="review.reviewId">
        <h4 class="review-username">{{review.username}}</h4>
        <h3 class="review-title">{{ review.title }} {{review.rating}}</h3>
        <p class="review-body">{{review.body}}</p>
    </div>
  </div>
</template>

<script>


export default {
  
}
</script>

<style>

</style>