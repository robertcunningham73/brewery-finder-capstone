<template>
  <main class="beer-details" >
    <div class="edit-beer-button">
      <button
        id="show-edit-beer-button"
        v-on:click="showEditBeerForm = true"
        v-show="showEditBeerForm === false && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Edit Beer</button>
      <button
        id="hide-edit-beer-button"
        v-on:click.prevent="showEditBeerForm = false"
        v-show="showEditBeerForm === true && this.$store.state.user.id === this.$store.state.activeBrewery.brewerId"
        >Hide Edit Beer Form</button>
      </div>
      <div >
        <edit-beer v-show="showEditBeerForm === true"/>
      </div>
     <h1>
      {{this.$store.state.beer.name}}
    </h1>
    <h4>
      ABV: {{this.$store.state.beer.abv}} | Type: {{this.$store.state.beer.beerType}}
    </h4>
      <h3>
      Description: {{this.$store.state.beer.description}}
    </h3>
    <div class= "img-beer">
    <img :src="require(`@/assets/${imagePath}`)" alt="Picture of beer" />
    </div>
  </main>
</template>

<script>
import beerService from "@/services/BeerService.js";
import EditBeer from "./EditBeer.vue";

export default {
  components: { EditBeer },
  name: 
    "beer-details", 
  props: {
    beerId: Number
  }, 
  data(){
    return{
      showEditBeerForm : false,
      showAddBeerForm : false,
      imagePath: "beers.jpg"
      
    }  
  }, 
  created() {
    beerService.getBeer(this.$route.params.id).then(response =>{
      this.$store.commit("SET_ACTIVE_BEER", response.data);
      this.imagePath = this.$store.state.beer.imagePath;
    });
    beerService.getBreweryByBeerId(this.$route.params.id).then(response => {
      this.$store.commit("SET_ACTIVE_BREWERY", response.data);
      this.images = this.$store.state.activeBrewery.images;
      this.hoursArray = this.$store.state.activeBrewery.hours.split(",");
    });
  },
   
}
</script>
<style scoped>
 .img-beer{
  height:  200px;
  width: 200px;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-bottom: 15px;
 
}
img{
  max-width: 100%;
  max-height: 100%;
}

</style>