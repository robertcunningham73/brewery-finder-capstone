<template>
  <div class="review-content">
    <div id="review-display">
      <table id="rd-table"><br>
        <thead>
          <th></th>
          <th id="rating-container"><br>Rating</th>
          <th id="review-container"><br>Review</th>
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
.review-display{
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

table, td{
  border-bottom: 2px solid #183A37;
  border-collapse: collapse;
  padding: 5px 10px;
}

</style>
