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
        <div class="hours">
            <label for="monday-open">Mon Open: </label>
            <input type="time" v-model="hoursArray[0]" />
            
            <label for="monday-close">Mon close: </label>
            <input type="time" v-model="hoursArray[1]" />
            <button
            v-on:click.prevent="hoursArray[0] = 0, hoursArray[1] = 0, showMonClose = false"
            v-show="showMonClose == true"
            >Mon Closed</button>
        </div>
        <div class="hours">
            <label for="tuesday-open">Tue Open: </label>
            <input type="time" v-model="hoursArray[2]"/>
            <label for="tuesday-close">Tue Close: </label>
            <input type="time" v-model="hoursArray[3]"/>
            <button
            v-on:click.prevent="hoursArray[2] = 0, hoursArray[3] = 0, showTuesClose = false"
            v-show="showTuesClose == true"
            >Tue Closed</button>
        </div>
        <div class="hours">
            <label for="wednesday-open">Wed Open: </label>
            <input type="time" v-model="hoursArray[4]"/>
            <label for="wednesday-close">Wed Close: </label>
            <input type="time" v-model="hoursArray[5]"/>
            <button
            v-on:click.prevent="hoursArray[4] = 0, hoursArray[5] = 0, showWedClose = false"
            v-show="showWedClose == true"
            >Wed Closed</button>
        </div>
        <div class="hours">
            <label for="thurday-open">Thu Open: </label>
            <input type="time" v-model="hoursArray[6]"/>
            <label for="thursday-close">Thu Close: </label>
            <input type="time" v-model="hoursArray[7]"/>
            <button
            v-on:click.prevent="hoursArray[6] = 0, hoursArray[7] = 0, showThursClose = false"
            v-show="showThursClose == true"
            >Thu Closed</button>
        </div>
        <div class="hours">
            <label for="friday-open">Fri Open: </label>
            <input type="time" v-model="hoursArray[8]"/>
            <label for="friday-close">Fri Close: </label>
            <input type="time" v-model="hoursArray[9]"/>
            <button
            v-on:click.prevent="hoursArray[8] = 0, hoursArray[9] = 0, showFriClose = false"
            v-show="showFriClose == true"
            >Fri Closed</button>
        </div>
        <div class="hours"> 
            <label for="saturday-open">Sat Open: </label>
            <input type="time" v-model="hoursArray[10]"/>
            <label for="saturday-close">Sat Close: </label>
            <input type="time" v-model="hoursArray[11]"/>
            <button
            v-on:click.prevent="hoursArray[10] = 0, hoursArray[11] = 0, showSatClose = false"
            v-show="showSatClose == true"
            >Sat Closed</button>
        </div>
        <div class="hours">
            <label for="sunday-open">Sun Open: </label>
            <input type="time" v-model="hoursArray[12]"/>
            <label for="sunday-closed">Sun Close: </label>
            <input type="time" v-model="hoursArray[13]"/>
        <button
            v-on:click.prevent="hoursArray[12] = 0, hoursArray[13] = 0, showSunClose = false"
            v-show="showSunClose == true"
            >Sun Closed</button>
        </div>
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
            hoursArray: [],
            showMonClose: true,
            showTuesClose: true,
            showWedClose: true,
            showThursClose: true,
            showFriClose: true,
            showSatClose: true,
            showSunClose: true
        };
    },
   created() {
        beerService.getBrewery(this.$route.params.id).then(response => {
        this.$store.commit("SET_ACTIVE_BREWERY", response.data);
        this.hoursArray = this.$store.state.activeBrewery.hours.split(",");
        this.updatedBrewery = this.$store.state.activeBrewery;
    });
        

        
    }, 
    methods: {
        updateBrewery(){
            this.updatedBrewery.hours = this.hoursArray.toString();
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
            this.$store.state.beer.active = true;
          }
        }
    }
}
</script>

<style>
.hours{
    display: flex;
    justify-content: space-evenly;
}
</style>