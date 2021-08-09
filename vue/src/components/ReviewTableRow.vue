/* <template>
  <div class="card">
     <h3 nowrap>{{ review.username }}</h3>
    <h4>{{ review.rating }}</h4>
    <h5>{{ review.reviewBody }}</h5>
</template> */

<template>
  <tr>
    <td>{{ review.rating }}</td>
    <td nowrap>{{ review.username }}</td>
    <td>{{ review.reviewBody }}</td>
  </tr> 
</template> 

<script>
export default {
  name: "review-table-row",
  props: ["review"]
  }
;
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}
</style>