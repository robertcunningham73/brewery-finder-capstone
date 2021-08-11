<template>
  <div class="brewery-details">
    <div class="edit-brewery-button">
      <button
        id="show-edit-brewery-button"
        v-on:click.prevent="showEditBreweryForm = true"
        v-if="showEditBreweryForm === false && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Edit Brewery</button>
      <button
        id="hide-edit-beer-button"
        v-on:click.prevent="showEditBreweryForm = false"
        v-if="showEditBreweryForm === true && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Hide Edit Brewery Form</button>
    </div>
    <div>
      <edit-brewery class="edit-brewery-form" v-show="showEditBreweryForm === true"/>
    </div>
    <div class="add-beer-button">
      <button
        id="show-add-beer-button"
        v-on:click.prevent="showAddBeerForm = true"
        v-show="showAddBeerForm === false && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Add Beer</button>
      <button
        id="hide-add-beer-button"
        v-on:click.prevent="showAddBeerForm = false"
        v-show="showAddBeerForm === true && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Hide Add Beer Form</button>
    </div>
    <div>
      <add-beer v-show="showAddBeerForm === true"/>
    </div> 
    <div id="name">
      <h1>{{this.$store.state.activeBrewery.name}}</h1> 
    </div>
    <div id="location">
      <h3>{{this.$store.state.activeBrewery.address}}</h3>
      <h3>
        {{this.$store.state.activeBrewery.city}}
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
      <div v-for="beer in this.$store.state.beerList"  v-bind:key="beer.beerId" v-show="(beer.active && $store.state.user.authorities[0].name == 'ROLE_USER') || $store.state.user.authorities[0].name != 'ROLE_USER'">
      <router-link  v-bind:to="{ name: 'beer', params:{id: beer.beerId}}">{{ beer.name }}</router-link>
      </div>
    </div>
    <div class="brewery-hours">
      <h2>Hours of Operation: </h2> 
      <p>Monday: {{printMondayHours()}}</p>
      <p>Tuesday: {{printTuesdayHours()}}</p>
      <p>Wednesday: {{printWednesdayHours()}}</p>
      <p>Thursday: {{printThursdayHours()}}</p>
      <p>Friday: {{printFridayHours()}}</p>
      <p>Saturday: {{printSaturdayHours()}}</p>
      <p>Sunday: {{printSundayHours()}}</p>
    </div>
    <div id="contact-info"><h2>Contact Us:</h2>
      <h3>{{this.$store.state.activeBrewery.phone}} | {{this.$store.state.activeBrewery.email}}</h3>
    </div>
    <div class=brewery-images v-for="(image, index) in this.images" v-bind:key="image.imagePath">
      <img :src="require(`@/assets/${image.imagePath}`)" alt="brewery-images" />
      <button v-if="$store.state.user.authorities[0].name != 'ROLE_USER'" @click="deleteImage(index)">Delete</button>
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
     hoursArray: [],
     images: []
     }
   },
  created(){
    beerService.getBeerByBrewery(this.$route.params.id).then(response =>{
      this.$store.commit("SET_BEER_LIST", response.data);
    }); 
    beerService.getBrewery(this.$route.params.id).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
      this.images = this.$store.state.activeBrewery.images;
      this.hoursArray = this.$store.state.activeBrewery.hours.split(",");
      
    });
  },
  methods: {
    showBeer() {
        if (!this.$store.state.beer.active && this.$store.state.user.authorities[0].name == 'ROLE_USER') {
          return false;
        } else {
          return true;
        }
    },
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
    },
    deleteImage(index) {
      beerService.deleteBreweryImage(this.$store.state.activeBrewery.breweryId, this.$store.state.activeBrewery.images[0].imagePath).then   (response => {
        if (response.status == 200) {
          this.images.splice(index, 1);
          this.$store.commit("SET_ACTIVE_BREWERY_IMAGES", this.images);
        }
      });
    }
  }
}


</script>

<style>

</style>