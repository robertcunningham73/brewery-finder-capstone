<template>
<div class="brewery-list">
  <div>
      <button
        id="show-add-brewery-button"
        href="#"
        v-on:click.prevent="showAddBreweryForm = true"
        v-show="showAddBreweryForm == false && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
        >Add Brewery</button>
      <button
        id="hide-add-brewerybutton"
        href="#"
        v-on:click.prevent="showAddBreweryForm = false"
        v-show="showAddBreweryForm == true && this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'"
        >Hide Add Brewery Form</button>
      </div>
      <div>
        <add-brewery v-show="showAddBreweryForm == true"/>
      </div>

  <h1>All Breweries</h1>
   <div
     v-for="brewery in this.$store.state.breweries" v-bind:key="brewery.breweryId" v-show="brewery.active || $store.state.user.authorities[0].name == 'ROLE_ADMIN' || $store.state.user.id === $store.state.activeBrewery.brewerId">
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
.brewery-list a{ 
  color: #183A37;
}
#brewery-list-img{
  height:  300px;
  width: 600px;
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-bottom: 15px;
}





</style>