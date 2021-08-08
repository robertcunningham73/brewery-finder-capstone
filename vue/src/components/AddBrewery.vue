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
    <div class="set-brewery-hours">
        <label for="monday-open">Monday Open: </label>
        <input type="time" v-model="this.hoursArray[0]"/>
        <label for="monday-close">Monday close: </label>
        <input type="time" v-model="this.hoursArray[1]"/>
        <label for="tuesday-open">Tuesday Open: </label>
        <input type="time" v-model="hoursArray[2]"/>
        <label for="tuesday-close">Tuesday Close: </label>
        <input type="time" v-model="hoursArray[3]"/>
        <label for="wednesday-open">Wednesday Open: </label>
        <input type="time" v-model="hoursArray[4]"/>
        <label for="wednesday-close">Wednesday Close: </label>
        <input type="time" v-model="hoursArray[5]"/>
        <label for="thurday-open">Thursday Open: </label>
        <input type="time" v-model="hoursArray[6]"/>
        <label for="thursday-close">Thurday Close: </label>
        <input type="time" v-model="hoursArray[7]"/>
        <label for="friday-open">Friday Open: </label>
        <input type="time" v-model="hoursArray[8]"/>
        <label for="friday-close">Friday Close: </label>
        <input type="time" v-model="hoursArray[9]"/>
        <label for="saturday-open">Saturday Open: </label>
        <input type="time" v-model="hoursArray[10]"/>
        <label for="saturday-close">Saturday Close: </label>
        <input type="time" v-model="hoursArray[11]"/>
        <label for="sunday-open">Sunday Open: </label>
        <input type="time" v-model="hoursArray[12]"/>
        <label for="monday-open">Sunday Close: </label>
        <input type="time" v-model="hoursArray[13]"/>
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
                brewerId: 0,
                hours: ""
            },
            hoursArray: []
        };
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