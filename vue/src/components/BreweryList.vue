<template>
<div class="brewery-list">
  <div>
      <a
        id="show-add-brewery-button"
        href="#"
        v-on:click.prevent="showAddBreweryForm = true"
        v-show="showAddBreweryForm == false && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
        >Add Brewery</a>
      <a
        id="hide-add-brewerybutton"
        href="#"
        v-on:click.prevent="showAddBreweryForm = false"
        v-show="showAddBreweryForm == true && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
        >Hide Add Brewery Form</a>
      </div>
      <div>
        <add-brewery v-show="showAddBreweryForm == true"/>
      </div>

  <h1>All Breweries</h1>
    <div
    :style="{'background-image':'url(public/casks.jpg)'}"
     v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.breweryId" v-show="(brewery.active && $store.state.user.authorities[0].name == 'ROLE_USER') || $store.state.user.authorities[0].name != 'ROLE_USER'">
        <router-link v-bind:to="{ name: 'brewery', params:{id: brewery.breweryId}}" >{{ brewery.name }}</router-link>
    </div>
    <div id ="brewery-list-img">
      <img :src="require(`@/assets/casks.jpg`)"/>
     </div> 
</div>
  
</template>

<script>
import beerService from "@/services/BeerService.js";
import AddBrewery from './AddBrewery.vue';

export default {
  components: { AddBrewery },
  data(){
    return{
      showAddBreweryForm: false
    }
  },
  name: 'brewery-list',
  methods: {
    getBreweries(){
      beerService.getBreweries().then(response => {
        this.$store.commit("SET_BREWERIES", response.data);
      });
    }
  }, 
  created(){
    this.getBreweries();
  }
}

</script>

<style scoped>
/* .brewery-list a{ 
  color: #efd6ac;
} */

.brewery-list{
 
  z-index: 1;
}


</style>