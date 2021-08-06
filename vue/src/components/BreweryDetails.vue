<template>
  <div class="brewery-details">
    <div>
      <a
        id="show-edit-brewery-button"
        href="#"
        v-on:click.prevent="showEditBreweryForm = true"
        v-if="showEditBreweryForm === false && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Edit Brewery</a>
      <a
        id="hide-edit-beer-button"
        href="#"
        v-on:click.prevent="showEditBreweryForm = false"
        v-if="showEditBreweryForm === true && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Hide Edit Brewery Form</a>
      </div>
      <div>
        <edit-brewery class="edit-brewery-form" v-show="showEditBreweryForm === true"/>
      </div>
    <div id="name">
      <h1>{{this.$store.state.activeBrewery.name}}</h1> 
    </div>
    <div id="location">
      <h3>{{this.$store.state.activeBrewery.address}} 
        {{this.$store.state.activeBrewery.city}}, 
        {{this.$store.state.activeBrewery.state}}, 
        {{this.$store.state.activeBrewery.zip}}
      </h3>
    </div>
    <div id="history"><h2>History</h2>
      <h3>
        {{this.$store.state.activeBrewery.history}}
      </h3>
    </div>
    <div class="beer-list" >
      <h2>Brewery's Available Beers:</h2>
      <div v-for="beer in this.$store.state.beerList" v-bind:key="beer.beerId">
      <router-link  v-bind:to="{ name: 'beer', params:{id: beer.beerId}}">{{ beer.name }}</router-link>
      </div>
    </div>
    <div class="brewery-hours">
      <h2>Hours of Operation: </h2> 
      <!-- TODO: add hours of operation -->
    </div>
    <div id="contact-info"><h2>Contact Us:</h2>
      <h3>{{this.$store.state.activeBrewery.phone}} | {{this.$store.state.activeBrewery.email}}</h3>
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
   return{
     showEditBreweryForm: false
   }
  },
  
  created(){
    beerService.getBeerByBrewery(this.$route.params.id).then(response =>{
      this.$store.commit("SET_BEER_LIST", response.data);
    }); 
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
    });
  }
}


</script>

<style>

</style>