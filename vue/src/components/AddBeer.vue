<template>
    <form v-on:submit="addBeer">
     <div class="add-beer-name">
        <label for="name">Beer Name: </label>
        <input type="text" v-model="newBeer.name" />
    </div>
    <div class="add-beer-description">
        <label for="description">Description: </label>
        <input type="text" v-model="newBeer.description" />
    </div>
    <div class="add-beer-abv">
        <label for="abv">ABV: </label>
        <input type="text" v-model="newBeer.abv" />
    </div>
    <div class="add-beer-type">
        <label for="beer-type">Beer Type:</label>
        <input type="text" v-model="newBeer.type" />
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
    name: "add-brewery",
    data(){
        return{
            newBeer: {
                beerId: 0,
                name: "",
                description: "",
                abv: 0.0,
                active: true,
                beerType: ""
            }
        };
    },
    methods: {
        addBeer(){
            beerService.addBeer(this.newBeer, this.$store.state.activeBrewery.breweryId)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_ACTIVE_BEER", response.data);
                    this.$store.commit("SET_BEER_LIST", response.data);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.newBeer= {};
            this.$parent.showAddBeerForm = false;
        }
    }
}
</script>

<style>

</style>