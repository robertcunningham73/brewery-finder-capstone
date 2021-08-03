<template>
  <div class="list-beers">
    <!-- Might want to make a grid view rather than use a table -->
    <table>
    <thead>
      <tr>
        <th>All Beers</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="beer in this.$store.state.beerList" v-bind:key="beer.id"></tr>
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.id}}" >{{ beer.name }}</router-link>
    </tbody>
  </table> 

  </div>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: 'beer-list',
  methods: {
    getBeerList(){
      beerService.getBeerList().then(response => {
        this.$store.commit("SET_BEERLIST", response.data);
      });
    }
  }

}
</script>

<style>

</style>