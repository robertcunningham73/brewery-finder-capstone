<template>
  <div class="brewery-details">
    <div class="edit-brewery-button">
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
    <div class="add-beer-button">
      <a
        id="show-add-beer-button"
        href="#"
        v-on:click.prevent="showAddBeerForm = true"
        v-show="showAddBeerForm === false && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Add Beer</a>
      <a
        id="hide-add-beer-button"
        href="#"
        v-on:click.prevent="showAddBeerForm = false"
        v-show="showAddBeerForm === true && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Hide Add Beer Form</a>
    </div>
    <div>
      <add-beer v-show="showAddBeerForm === true"/>
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
      <div v-for="beer in this.$store.state.beerList"  v-bind:key="beer.beerId">
      <router-link  v-bind:to="{ name: 'beer', params:{id: beer.beerId}}">{{ beer.name }}</router-link>
      </div>
    </div>
    <div class="brewery-hours">
      <h2>Hours of Operation: </h2> 
      <!-- TODO: add hours of operation -->
      <h5>Monday: {{printMondayHours()}}</h5>
      <h5>Tuesday: {{printTuesdayHours()}}</h5>
      <h5>Wednesday: {{printWednesdayHours()}}</h5>
      <h5>Thursday: {{printThursdayHours()}}</h5>
      <h5>Friday: {{printFridayHours()}}</h5>
      <h5>Saturday: {{printSaturdayHours()}}</h5>
      <h5>Sunday: {{printSundayHours()}}</h5>
    </div>
    <div id="contact-info"><h2>Contact Us:</h2>
      <h3>{{this.$store.state.activeBrewery.phone}} | {{this.$store.state.activeBrewery.email}}</h3>
    </div>
  </div>
</template>

<script>
import beerService from '@/services/BeerService.js';
import EditBrewery from './EditBrewery.vue';
import AddBeer from './AddBeer.vue';

export default {
  components: { EditBrewery,  AddBeer},
  name: "brewery-details",
  data(){
   return{
     showEditBreweryForm: false,
     showAddBeerForm: false,
     hoursArray: []
   }
  },
  
  created(){
    beerService.getBeerByBrewery(this.$route.params.id).then(response =>{
      this.$store.commit("SET_BEER_LIST", response.data);
    }); 
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
      this.hoursArray = this.$store.state.activeBrewery.hours.split(",");
    });
  },
  methods: {
    printMondayHours(){
      let mondayHours = '';
      if(this.hoursArray[0] == 0 || this.hoursArray[1] == 0){
        mondayHours = 'Closed'
      }else{
        mondayHours = this.hoursArray[0] + ' - ' + this.hoursArray[1];
      }
      return mondayHours;
    },
     printTuesdayHours(){
      let tuesdayHours = '';
      if(this.hoursArray[2] == 0 || this.hoursArray[3] == 0){
        tuesdayHours = 'Closed'
      }else{
        tuesdayHours = this.hoursArray[2] + ' - ' + this.hoursArray[3];
      }
      return tuesdayHours;
    },
    printWednesdayHours(){
      let wednesdayHours = '';
      if(this.hoursArray[4] == 0 || this.hoursArray[5] == 0){
        wednesdayHours = 'Closed'
      }else{
        wednesdayHours = this.hoursArray[4] + ' - ' + this.hoursArray[5];
      }
      return wednesdayHours;
    },
    printThursdayHours(){
      let thursdayHours = '';
      if(this.hoursArray[6] == 0 || this.hoursArray[7] == 0){
        thursdayHours = 'Closed'
      }else{
        thursdayHours = this.hoursArray[6] + ' - ' + this.hoursArray[7];
      }
      return thursdayHours;
    },
    printFridayHours(){
      let fridayHours = '';
      if(this.hoursArray[8] == 0 || this.hoursArray[9] == 0){
        fridayHours = 'Closed'
      }else{
        fridayHours = this.hoursArray[8] + ' - ' + this.hoursArray[9];
      }
      return fridayHours;
    },
    printSaturdayHours(){
      let saturdayHours = '';
      if(this.hoursArray[10] == 0 || this.hoursArray[11] == 0){
        saturdayHours = 'Closed'
      }else{
        saturdayHours = this.hoursArray[10] + ' - ' + this.hoursArray[11];
      }
      return saturdayHours;
    },
    printSundayHours(){
      let sundayHours = '';
      if(this.hoursArray[12] == 0 || this.hoursArray[13] == 0){
        sundayHours = 'Closed'
      }else{
        sundayHours = this.hoursArray[12] + ' - ' + this.hoursArray[13];
      }
      return sundayHours;
    }
  }
}


</script>

<style>

</style>