<template>
<div class="content">
  <div class="list-beers">
    <h1>All Beers</h1>
    <div v-for="beer in this.$store.state.beerList" v-bind:key="beer.id">
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.beerId}}" >{{ beer.name }}</router-link>
    </div>
  </div>
   <div class="beer-list-img">
      <img :src="require(`@/assets/beer_flight.jpg`)"/>
    </div>
  </div>
</template>

<script>
import beerService from "@/services/BeerService.js";

export default {
  name: 'beer-list',
  methods: {
    getBeerList(){
    beerService.getBeerList().then(response => {
      this.$store.commit("SET_BEER_LIST", response.data);
    });
  }
  },
  created(){
    this.getBeerList();
  }
}
</script>

<style>
.beer-list-img{
  height:  300px;
  width: 600px;
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-bottom: 15px;
  padding-top: 15px;
}

.list-beers a{
  color: #183A37
}

@media screen and (max-width: 600px){
  .brewery-list-img{
    height: auto;
    width: auto;
  }
}
</style>