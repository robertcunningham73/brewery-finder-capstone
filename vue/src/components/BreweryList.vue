<template>
<div class="content">
<div class="brewery-list">
  <!-- <table>
    <thead>
      <tr>
        <th>All Breweries</th>
      </tr>
    </thead>
    <tbody>
        <tr v-for="brewery in breweries" v-bind:key="brewery.breweryId"></tr>
      <td>
        <router-link v-bind:to="{ name: 'brewery', params:{id: brewery.breweryId}}" >{{ brewery.name }}</router-link>
      </td>
    </tbody>
  </table> -->
  <div v-for="brewery in breweries" v-bind:key="brewery.breweryId">
    <router-link :to="{ name: 'brewery', params:{id: brewery.breweryId}}">{{ brewery.name}}</router-link>
  </div>
</div>
</div>
  
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: 'brewery-list',
  data() {
    return {
      breweries: [],
    };
  }, 
  /* methods: {
    getBreweries(){
      beerService.getBreweries().then(response => {
        this.$store.commit("SET_BREWERIES", response.data);
      });
    }
  }, */
  created(){
    beerService.getBreweries().then(response => {
      this.breweries = response.data;
    }); 
    /* this.getBreweries();
  } */
}
}
</script>

<style>

</style>