<template>
    <form v-on:submit.prevent="updateBrewery">
     <div class="form-element">
        <label for="name">Brewery Name: </label>
        <input type="text" id="name" />
    </div>
    <!-- <div class="edit-brewery-address">
        <label for="address">Street Address: </label>
        <textarea type="text" v-model="updatedBrewery.address" />
    </div>
    <div class="edit-brewery-city">
        <label for="city">City: </label>
        <textarea type="text" v-model="updatedBrewery.city" />
    </div>
    <div class="edit-brewery-state">
        <label for="state">State Initials:</label>
        <textarea type="text" v-model="updatedBrewery.state" />
    </div> 
    <div class="edit-brewery-zip">
        <label for="zip">Zip: </label>
        <textarea type="text" v-model="updatedBrewery.zip" />
    </div>
    <div class="edit-brewery-phone-number">
        <label for="phone">Phone Number: </label>
        <textarea type="text" v-model="updatedBrewery.phone" />
    </div>
    <div class="edit-brewery-email">
        <label for="email">Email Address: </label>
        <textarea type="text" v-model="updatedBrewery.email" />
    </div>
    <div class="edit-brewery-history">
        <label for="history">History: </label>
        <textarea type="text" v-model="updatedBrewery.history" />
    </div> -->
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
    data(){
        return{
            updatedBrewery: {
                breweryId: this.store.state.activeBrewery.breweryId,
                name: "",
                address: "",
                city: "",
                state: "",
                zip: "",
                phone: "",
                email: "",
                history: "",
                active: false,
                brewerId: this.$store.state.activeBrewery.brewerId
            }
        }
    },
    methods: {
        updateBrewery(){
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
                this.updatedBrewery.state = this.$tore.state.activeBrewery.state;
            }
            if(this.updatedBrewery.zip == 0){
                this.updatedBrewery.zip = this.$tore.state.activeBrewery.zip;
            }
            if(this.updatedBrewery.phone == ""){
                this.updatedBrewery.phone = this.$tore.state.activeBrewery.phone;
            }
            if(this.updatedBrewery.email == ""){
                this.updatedBrewery.email = this.$tore.state.activeBrewery.email;
            }
            if(this.updatedBrewery.history == ""){
                this.updatedBrewery.history = this.$tore.state.activeBrewery.history;
            }
            this.updatedBrewery.name = document.getElementbyId("name");
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