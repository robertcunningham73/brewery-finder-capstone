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
    <div class="brewery-activation-status">
        <button v-if="this.$store.state.activeBrewery.active == true" v-on:click="updatedBrewery.active = false">Deactivate brewery</button>
        <button v-if="this.$store.state.activeBrewery.active == false" v-on:click="updatedBrewery.active = true">Activate brewery</button>
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
                brewerId: 0
            }
        };
    },
    methods: {
        updateBrewery(){
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
        }
    }
}
</script>

<style>

</style>