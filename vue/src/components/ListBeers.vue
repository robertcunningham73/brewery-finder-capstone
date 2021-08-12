<template>
<div class="content">
  <div class="list-beers">
    <h1>All Beers</h1>
    <div v-for="beer in this.$store.state.beerList" v-bind:key="beer.id">
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.beerId}}" >{{ beer.name }}</router-link>
    </div>
  </div>
   <div class="beer-list-img">
     <div id="img-beer-list">
       <img :src="require(`@/assets/beer_flight.jpg`)"/>
     </div>
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
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-bottom: 15px;
  padding-top: 15px;
}

#img-beer-list{
  max-width: 100%;
}

.list-beers a{
  font-size: 22px;
  font-weight: bold;
}

@media screen and (max-width: 600px){
  .brewery-list-img{
    height: auto;
    width: auto;
  }
}
</style>