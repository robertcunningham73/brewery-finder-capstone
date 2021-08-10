<template>
    <form v-on:submit="updateBeer">
     <div class="edit-beer-name">
        <label for="name">Beer Name: </label>
        <input type="text" v-model="updatedBeer.name" />
    </div>
    <div class="edit-beer-description">
        <label for="description">Description: </label>
        <input type="text" v-model="updatedBeer.description" />
    </div>
    <div class="edit-beer-abv">
        <label for="abv">ABV: </label>
        <input type="text" v-model="updatedBeer.abv" />
    </div>
    <div class="edit-beer-type">
        <label for="beer-type">Beer Type:</label>
        <input type="text" v-model="updatedBeer.beerType" />
    </div> 
    <div class="beer-activation-status">
        <button v-if="this.$store.state.beer.active == true" v-on:click="updateState">Deactivate</button>
        <button v-if="this.$store.state.beer.active == false" v-on:click="updateState">Activate</button>
    </div>
    <div class="actions">
        <button v-on:click.prevent="resetForm" type="cancel" >Cancel</button>
        <button>Submit</button>
        </div>
    </form>
</template>

<script>
import beerService from '../services/BeerService';


export default {
    name: "edit-brewery",
    data(){
        return{
            updatedBeer: {
                beerId: 0,
                name: "",
                description: "",
                abv: 0.0,
                active: true,
                beerType: "",
                imagePath: ""
            }
        };
    },
    created(){
        beerService.getBeer(this.$route.params.id).then(response =>{
      this.$store.commit("SET_ACTIVE_BEER", response.data);
      this.updatedBeer = this.$store.state.beer;
    })
        
    },
    methods: {
        updateBeer(){
            this.updatedBeer.imagePath = this.$store.state.beer.imagePath;
            this.updatedBeer.beerId = this.$store.state.beer.beerId;
            if(this.updatedBeer.name == ""){
                this.updatedBeer.name = this.$store.state.beer.name;
            }
            if(this.updatedBeer == ""){
                this.updatedBeer.description = this.$store.state.beer.description;
            }
            if(this.updatedBeer.abv == 0.0){
                this.updatedBeer.abv = this.$store.state.beer.abv;
            }
            if(this.updatedBeer.beerType == ""){
                this.updatedBeer.beerType = this.$store.state.beer.beerType;
            }
            beerService.updateBeer(this.updatedBeer, this.$store.state.activeBrewery.breweryId)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_ACTIVE_BEER", response.data);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.updatedBeer= {};
            this.$parent.showEditBeerForm = false;
        },
        updateState(){
          if(this.$store.state.beer.active == true){
            this.$store.state.beer.active = false;
          }else{
            this.$store.state.beer.active = true;
          }
        }
    }
}
</script>

<style>

</style>