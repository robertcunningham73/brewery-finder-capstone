<template>
    <form>
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
        <button v-if="this.$store.state.beer.active == true" v-on:click.prevent="updateState">Deactivate</button>
        <button v-if="this.$store.state.beer.active == false" v-on:click.prevent="updateState">Activate</button>
    </div>
    <div class="actions">
        <button v-on:click.prevent="resetForm" type="cancel" >Cancel</button>
        <button type="button" v-on:click="updateBeer">Submit</button>
        </div>
    </form>
</template>

<script>
import beerService from '../services/BeerService';


export default {
    name: "edit-beer",
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
            beerService.updateBeer(this.updatedBeer, this.$store.state.activeBrewery.breweryId)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_ACTIVE_BEER", this.updatedBeer);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.$parent.showEditBeerForm = false;
        },
        updateState(){
          if(this.updatedBeer.active == true){
            this.updatedBeer.active = false;
          } else {
            this.updatedBeer.active = true;
          }
        }
    }
}
</script>

<style>

</style>