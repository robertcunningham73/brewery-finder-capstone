<template>
  <div class="brewery-details">
    <div>
      <a
        id="show-edit-brewery-button"
        href="#"
        v-on:click.prevent="showEditBreweryForm = true"
        v-if="showEditForm === false && this.$store.state.user.id === this.$store.state.brewery.brewerId"
        >Edit Brewery</a>
      <a
        id="hide-edit-beer-button"
        href="#"
        v-on:click.prevent="showEditBreweryForm = false"
        v-if="showReviews === true && this.$store.state.user.id === this.$store.state.brewery.brewerId"
        >Hide Edit Brewery Form</a>
      </div>
      <div>
        <edit-brewery v-show="showEditBreweryForm === true"/>
      </div>
    <div id="name">
      <h1>{{this.$store.state.activeBrewery.name}}</h1> 
      <!-- <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Edit Brewery name</button> -->
    </div>
    <div id="location">
      <h3>{{this.$store.state.activeBrewery.address}} 
        {{this.$store.state.activeBrewery.city}}, 
        {{this.$store.state.activeBrewery.state}}, 
        {{this.$store.state.activeBrewery.zip}}
      </h3>
      <!-- <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Edit address</button> -->
    </div>
    <div id="history"><h2>History</h2>
      <h3>
        {{this.$store.state.activeBrewery.history}}
      </h3>
      <!-- <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Edit History</button> -->
    </div>
    <div class="beer-list" v-for="beer in beerList" v-bind:key="beer.beerId">
      <h2>Brewery's Available Beers:</h2>
      <router-link v-bind:to="{ name: 'beer', params:{id: beer.beerId}}">{{ beer.name }}</router-link>
      <!-- <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Add Beer</button> -->
    </div>
    <div class="brewery-hours">
      <h2>Hours of Operation: </h2> 
      <!-- TODO: add hours of operation -->
      <!-- <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Edit Hours of Operation</button> -->
    </div>
    <div id="contact-info"><h2>Contact Us:</h2>
      <h3>{{this.$store.state.activeBrewery.phone}} | {{this.$store.state.activeBrewery.email}}</h3>
      <!-- <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Edit Phone Number</button>
      <button v-if="this.user.id == this.$store.state.activeBrewery.bewerId">Edit Email Address</button> -->
    </div>
  </div>
</template>

<script>
import beerService from '@/services/BeerService.js';
import EditBrewery from './EditBrewery.vue';

export default {
  components: { EditBrewery },
name: "brewery-details",
data(){
  return {
    beerList: []
  }
},
  
  created(){
    beerService.getBeerByBrewery(this.$route.params.id).then(response =>{
      this.beerList = response.data;
    }); 
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
    });
  }
}


</script>

<style>

</style>