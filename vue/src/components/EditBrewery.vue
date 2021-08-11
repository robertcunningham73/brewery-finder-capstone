<template>
    <form>
        <div class="add-imagePath-button" v-show="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'">
            <label for="add-brewery-image">Add image path</label>
            <input type="text" v-model="imagePath">
        </div>
        <div class="edit-brewer-id" v-show="this.$store.state.user.authorities[0].name == 'ROLE_ADMIN'">
            <label for="edit-brewer">Edit Brewer</label>
            <select v-model="updatedBrewery.brewerId">
                <option v-for="user in users" :key="user.id" :value="user.id">{{user.username}}</option>
            </select>
        </div>
        <div class="edit-brewery-name" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="name">Brewery Name: </label>
            <input type="text" v-model="updatedBrewery.name" />
        </div>
        <div class="edit-brewery-address" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="address">Street Address: </label>
            <input type="text" v-model="updatedBrewery.address" />
        </div>
        <div class="edit-brewery-city" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="city">City: </label>
            <input type="text" v-model="updatedBrewery.city" />
        </div>
        <div class="edit-brewery-state" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="state">State Initials:</label>
            <input type="text" v-model="updatedBrewery.state" />
        </div> 
        <div class="edit-brewery-zip" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="zip">Zip: </label>
            <input type="text" v-model="updatedBrewery.zip" />
        </div>
        <div class="edit-brewery-phone-number" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="phone">Phone Number: </label>
            <input type="text" v-model="updatedBrewery.phone" />
        </div>
        <div class="edit-brewery-email" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="email">Email Address: </label>
            <input type="text" v-model="updatedBrewery.email" />
        </div>
        <div class="edit-brewery-history" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <label for="history">History: </label>
            <textarea type="text" v-model="updatedBrewery.history" />
        </div>
        <div class="edit-brewery-hours" v-show="this.$store.state.user.id === this.$store.state.activeBrewery.brewerId">
            <div class="hours">
                <label for="monday-open" class="open-labels">Mon Open: </label>
                <input type="time" v-model="hoursArray[0]" />
                
                <label for="monday-close">Mon close: </label>
                <input type="time" v-model="hoursArray[1]" />
                <button
                    class="closed-buttons"
                    v-on:click.prevent="hoursArray[0] = 0, hoursArray[1] = 0, showMonClose = false"
                    v-show="showMonClose == true"
                >Mon Closed</button>
            </div>
            <div class="hours">
                <label for="tuesday-open" class="open-labels">Tue Open: </label>
                <input type="time" v-model="hoursArray[2]"/>
                <label for="tuesday-close" class="close-lables">Tue Close: </label>
                <input type="time" v-model="hoursArray[3]"/>
                <button
                    class="closed-buttons"
                    v-on:click.prevent="hoursArray[2] = 0, hoursArray[3] = 0, showTuesClose = false"
                    v-show="showTuesClose == true"
                >Tue Closed</button>
            </div>
            <div class="hours">
                <label for="wednesday-open" class="open-labels">Wed Open: </label>
                <input type="time" v-model="hoursArray[4]"/>
                <label for="wednesday-close" class="close-lables">Wed Close: </label>
                <input type="time" v-model="hoursArray[5]"/>
                <button
                    class="closed-buttons"
                    v-on:click.prevent="hoursArray[4] = 0, hoursArray[5] = 0, showWedClose = false"
                    v-show="showWedClose == true"
                >Wed Closed</button>
            </div>
            <div class="hours">
                <label for="thurday-open" class="open-labels">Thu Open: </label>
                <input type="time" v-model="hoursArray[6]"/>
                <label for="thursday-close" class="close-lables">Thu Close: </label>
                <input type="time" v-model="hoursArray[7]"/>
                <button
                    class="closed-buttons"
                    v-on:click.prevent="hoursArray[6] = 0, hoursArray[7] = 0, showThursClose = false"
                    v-show="showThursClose == true"
                >Thu Closed</button>
            </div>
            <div class="hours">
                <label for="friday-open" class="open-labels">Fri Open: </label>
                <input type="time" v-model="hoursArray[8]"/>
                <label for="friday-close" class="close-lables">Fri Close: </label>
                <input type="time" v-model="hoursArray[9]"/>
                <button
                    class="closed-buttons"
                    v-on:click.prevent="hoursArray[8] = 0, hoursArray[9] = 0, showFriClose = false"
                    v-show="showFriClose == true"
                >Fri Closed</button>
            </div>
            <div class="hours"> 
                <label for="saturday-open" class="open-labels">Sat Open: </label>
                <input type="time" v-model="hoursArray[10]"/>
                <label for="saturday-close" class="close-lables">Sat Close: </label>
                <input type="time" v-model="hoursArray[11]"/>
                <button
                    class="closed-buttons"
                    v-on:click.prevent="hoursArray[10] = 0, hoursArray[11] = 0, showSatClose = false"
                    v-show="showSatClose == true"
                >Sat Closed</button>
            </div>
            <div class="hours">
                <label for="sunday-open" class="open-labels">Sun Open: </label>
                <input type="time" v-model="hoursArray[12]"/>
                <label for="sunday-closed" class="close-lables">Sun Close: </label>
                <input type="time" v-model="hoursArray[13]"/>
            <button
                class="closed-buttons"
                v-on:click.prevent="hoursArray[12] = 0, hoursArray[13] = 0, showSunClose = false"
                v-show="showSunClose == true"
                >Sun Closed</button>
        </div>
    </div>
    <div class="brewery-activation-status">
        <button v-if="this.updatedBrewery.active == true" v-on:click.prevent="updateState">Deactivate brewery</button>
        <button v-if="this.updatedBrewery.active == false" v-on:click.prevent="updateState">Activate brewery</button>
    </div>
    <div class="actions">
        <button v-on:click.prevent="resetForm" type="cancel" >Cancel</button>
        <button type="button" v-on:click="updateBrewery">Submit</button>
    </div>
    
    </form>
</template>

<script>
import AuthService from '../services/AuthService';
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
                hours: "",
                images: []
            },
            hoursArray: [],
            showMonClose: true,
            showTuesClose: true,
            showWedClose: true,
            showThursClose: true,
            showFriClose: true,
            showSatClose: true,
            showSunClose: true,
            imagePath: "",
            users: ""
        };
    },
   created() {
       AuthService.getUsers().then(response => {
            if(response.status == 200){
                this.users = response.data;
            }
        });
        beerService.getBrewery(this.$route.params.id).then(response => {
        this.$store.commit("SET_ACTIVE_BREWERY", response.data);
        this.hoursArray = this.$store.state.activeBrewery.hours.split(",");
        this.updatedBrewery = this.$store.state.activeBrewery;
    });    
    }, 
    methods: {
        updateBrewery(){
            /* let imageObject = {
                breweryId: this.$store.state.activeBrewery.breweryId,
                path: ""
            }
            imageObject.path = this.imagePath;
            this.updatedBrewery.images = this.store.state.activeBrewery.images;
            this.updatedBrewery.images.push(imageObject);*/
            this.updatedBrewery.hours = this.hoursArray.toString(); 
            
            beerService.updateBrewery(this.updatedBrewery)
            .then(response => {
                if(response.status == 200){
                    this.$store.commit("SET_ACTIVE_BREWERY", this.updatedBrewery);
                }
            });
            this.resetForm();
        },
        resetForm() {
            this.$parent.showEditBreweryForm = false;
        },
        updateState(){
            if(this.updatedBrewery.active == true){
            this.updatedBrewery.active = false;
          }else{
            this.updatedBrewery.active = true;
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