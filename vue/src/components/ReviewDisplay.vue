<template>
  <div class="review-display">
    <table>
      <thead>
        <th>Rating</th>
        <th></th>
        <th>Review: </th>
      </thead>
      <tbody>
        <review-table-row 
        v-for="review in this.$store.state.beer.reviews"
        v-bind:key="review.reviewId"
        v-bind:review="review"/>
        <tr v-show="this.$store.state.beer.reviews.length == 0">
          <td colspan="3">There are no reviews</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import ReviewTableRow from './ReviewTableRow.vue'


export default {
  components: { ReviewTableRow },
  name: 'review-display',
  props: ['review']
}
</script>

<style>

</style>