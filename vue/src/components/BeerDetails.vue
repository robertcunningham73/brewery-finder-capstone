<template>
  <main class="beer-details" >
    <div>
      <a
        id="show-edit-beer-button"
        href="#"
        v-on:click.prevent="showEditBeerForm = true"
        v-if="showEditForm === false && this.$store.state.user.id === this.$store.state.brewery.brewerId"
        >Edit Beer</a>
      <a
        id="hide-edit-beer-button"
        href="#"
        v-on:click.prevent="showEditBeerForm = false"
        v-if="showReviews === true && this.$store.state.user.id === this.$store.state.brewery.brewerId"
        >Hide Edit Beer Form</a>
      </div>
      <div>
        <edit-beer v-show="showEditBeerForm === true"/>
      </div>
      <div>
      <a
        id="show-add-beer-button"
        href="#"
        v-on:click.prevent="showAddBeerForm = true"
        v-if="showEditForm === false && this.$store.state.user.id === this.$store.state.brewery.brewerId"
        >Add Beer</a>
      <a
        id="hide-add-beer-button"
        href="#"
        v-on:click.prevent="showAddBeerForm = false"
        v-if="showReviews === true && this.$store.state.user.id === this.$store.state.brewery.brewerId"
        >Hide Add Beer Form</a>
      </div>
      <div>
        <add-beer v-show="showAddBeerForm === true"/>
      </div>
     <h1>
      {{this.$store.state.beer.name}}
    </h1>
    

    <h4>
      ABV {{this.$store.state.beer.abv}} | Type {{this.$store.state.beer.beerType}}
    </h4>
      
    
    <h3>
      Description: {{this.$store.state.beer.description}}
    </h3>
      

    <div class= "img-beer">
    <img :src="require(`@/assets/${this.$store.state.beer.imagePath}`)" alt="this.$store.state.beer.name" />
    </div>
  </main>
</template>

<script>
import beerService from "@/services/BeerService.js";
import EditBeer from "./EditBeer.vue";
import AddBeer from './AddBeer.vue';

export default {
  components: { EditBeer, AddBeer },
  name: 
    "beer-details", 
  props: {
    beerId: Number
  }, 
  created() {
    beerService.getBeer(this.$route.params.id).then(response =>{
      this.$store.commit("SET_ACTIVE_BEER", response.data);
    })
  },
  methods:{

  } 
}
</script>
<style scoped>
 .img-beer{
  height:  400px;
  width: 400px;
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
 
}
img{
  max-width: 100%;
  max-height: 100%;
 
}

</style>