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

</style>