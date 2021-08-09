<template>
    <form v-on:submit="updateBrewery">
     <div class="form-element">
        <label for="name">Brewery Name: </label>
        <input type="text" v-model="updatedBrewery.name" />
    </div>
    <div class="edit-brewery-address">
        <label for="address">Street Address: </label>
        <input type="text" v-model="updatedBrewery.address" />
    </div>
    <div class="edit-brewery-city">
        <label for="city">City: </label>
        <input type="text" v-model="updatedBrewery.city" />
    </div>
    <div class="edit-brewery-state">
        <label for="state">State Initials:</label>
        <input type="text" v-model="updatedBrewery.state" />
    </div> 
    <div class="edit-brewery-zip">
        <label for="zip">Zip: </label>
        <input type="text" v-model="updatedBrewery.zip" />
    </div>
    <div class="edit-brewery-phone-number">
        <label for="phone">Phone Number: </label>
        <input type="text" v-model="updatedBrewery.phone" />
    </div>
    <div class="edit-brewery-email">
        <label for="email">Email Address: </label>
        <input type="text" v-model="updatedBrewery.email" />
    </div>
    <div class="edit-brewery-history">
        <label for="history">History: </label>
        <textarea type="text" v-model="updatedBrewery.history" />
    </div>
    <div class="edit-brewery-hours">
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
    <div class="brewery-activation-status">
        <button v-if="this.$store.state.activeBrewery.active == true" v-on:click="updateState">Deactivate brewery</button>
        <button v-if="this.$store.state.activeBrewery.active == false" v-on:click="updateState">Activate brewery</button>
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
            updatedBrewery: {
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
    created() {
        this.updatedBrewery = this.$store.state.activeBrewery;
        this.hoursArray = this.$store.state.activeBrewery.hours.split(",");
    },
    methods: {
        updateBrewery(){
            this.updatedBrewery.hours = this.hoursArray.toString();
            this.updatedBrewery.breweryId = this.$store.state.activeBrewery.breweryId;
            this.updatedBrewery.brewerId = this.$store.state.activeBrewery.brewerId;
             if(this.updatedBrewery.name == ""){
                this.updatedBrewery.name = this.$store.state.activeBrewery.name;
            }
            if(this.updatedBrewery.address == ""){
                this.updatedBrewery.address = this.$store.state.activeBrewery.address;
            }
            if(this.updatedBrewery.city == ""){
                this.updatedBrewery.city = this.$store.state.activeBrewery.city;
            }
            if(this.updatedBrewery.state == ""){
                this.updatedBrewery.state = this.$store.state.activeBrewery.state;
            }
            if(this.updatedBrewery.zip == 0){
                this.updatedBrewery.zip = this.$store.state.activeBrewery.zip;
            }
            if(this.updatedBrewery.phone == ""){
                this.updatedBrewery.phone = this.$store.state.activeBrewery.phone;
            }
            if(this.updatedBrewery.email == ""){
                this.updatedBrewery.email = this.$store.state.activeBrewery.email;
            }
            if(this.updatedBrewery.history == ""){
                this.updatedBrewery.history = this.$store.state.activeBrewery.history;
            } 
            beerService.updateBrewery(this.updatedBrewery)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_ACTIVE_BREWERY", response.data);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.updatedBrewery = {};
            this.$parent.showEditBreweryForm = false;
        },
        updateState(){
            if(this.$store.state.beer.active == true){
            this.$store.state.beer.active = false;
          }else{
            this.$store.state.bee.active = true;
          }
        }
    }
}
</script>

<style>

</style>