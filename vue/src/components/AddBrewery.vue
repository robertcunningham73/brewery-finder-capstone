<template>
    <form v-on:submit="addBrewery">
     <div class="new-brewery-name">
        <label for="name">Brewery Name (Required): </label>
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
        <label for="brewer">Brewer (Required): </label>
        <select v-model="newBrewery.brewerId">
            <option v-for="user in users" :key="user.id" :value="user.id">{{user.username}}</option>
        </select>
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
import AuthService from '../services/AuthService';
import beerService from '../services/BeerService';


export default {
    name: "add-brewery",
    data(){
        return{
            newBrewery: {
                breweryId: 0,
                name: "",
                address: "Street Address",
                city: "City Name",
                state: "ZZ",
                zip: "99999",
                phone: "Phone Number",
                email: "Email Address",
                history: "Input brewery's history here.",
                active: false,
                brewerId: 0,
                hours: ""
            },
            hoursArray: [0,0,0,0,0,0,0,0,0,0,0,0,0,0],
            users: ""
        };
    },
    created() {
        AuthService.getUsers().then(response => {
            if(response.status == 200){
                this.users = response.data;
            }
        });
    },
    methods: {
        addBrewery(){
            this.newBrewery.hours = this.hoursArray.toString();
            beerService.addBrewery(this.newBrewery)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_BREWERIES", response.data);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.newBrewery = {};
        }  
    }
}
</script>

<style>

</style>