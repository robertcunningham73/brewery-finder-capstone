<template>
<div class="brewery-list">
  <table>
    <thead>
      <tr>
        <th>All Breweries</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.id"></tr>
      <router-link v-bind:to="{ name: 'brewery', params:{id: brewery.id}}" >{{ brewery.name }}</router-link>
    </tbody>
  </table> 

</div>
  
</template>

<script>
export default {

}
</script>

<style>

</style>