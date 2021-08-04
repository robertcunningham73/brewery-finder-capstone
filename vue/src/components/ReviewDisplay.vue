<template>
  <div class="review-display">
    <h4>{{ review.username }}</h4>
    <h3>{{review.rating}}</h3>
    <h3>{{review.reveiwBody}}</h3>
  </div>
</template>

<script>


export default {
  name: 'review-display',
  props: ['review']
}
</script>

<style>

</style>