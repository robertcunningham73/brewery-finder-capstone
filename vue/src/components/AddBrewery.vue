<template>
    <form v-on:submit="addBrewery">
     <div class="new-brewery-name">
        <label for="name">Brewery Name: </label>
        <input type="text" v-model="newBrewery.name" />
    </div>
    <div class="new-brewery-address">
        <label for="address">Street Address: </label>
        <input type="text" v-model="newBrewery.address" />
    </div>
    <div class="new-brewery-city">
        <label for="city">City: </label>
        <input type="text" v-model="newBrewery.city" />
    </div>
    <div class="new-brewery-state">
        <label for="state">State Initials:</label>
        <input type="text" v-model="newBrewery.state" />
    </div> 
    <div class="new-brewery-zip">
        <label for="zip">Zip: </label>
        <input type="text" v-model="newBrewery.zip" />
    </div>
    <div class="new-brewery-phone-number">
        <label for="phone">Phone Number: </label>
        <input type="text" v-model="newBrewery.phone" />
    </div>
    <div class="new-brewery-email">
        <label for="email">Email Address: </label>
        <input type="text" v-model="newBrewery.email" />
    </div>
    <div class="set-brewerId">
        <label for="email">Brewer ID: </label>
        <input type="text" v-model="newBrewery.brewerId" />
    </div>
    <div class="new-brewery-history">
        <label for="history">History: </label>
        <textarea type="text" v-model="newBrewery.history" />
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
            newBrewery: {
                breweryId: 0,
                name: "",
                address: "",
                city: "",
                state: "",
                zip: 0,
                phone: "",
                email: "",
                history: "",
                active: true,
                brewerId: 0
            }
        };
    },
    methods: {
        addBrewery(){
            beerService.addBrewery(this.newBrewery)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_BREWERIES", response.data);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.unewBrewery = {};
        }
    }
}
</script>

<style>

</style>