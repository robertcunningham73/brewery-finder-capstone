import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if(currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    filter: 0,
    breweries: [],
    activeBrewery: {
      breweryId: 0,
      name: "",
      address: "",
      city: "",
      state: "",
      zip: 0,
      phone: "",
      email: "",
      history: "",
      active: false,
      brewerId: 0
      //TODO add images, hours of operation, brewers
    },
    beerList: [],
    beer: {
      beerId: 0,
      name: "",
      description: "",
      abv: 0.0,
      beerType: "",
      reviews: [],
      imagePath: "",
      active: true
    },
    
    review: {
      reviewId: 0,
      rating: 0,
      reviewBody: "",
      userId: 0,
      username: ""
    },
    token: currentToken || '',
    user: currentUser || {}
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user',JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    SET_BREWERIES(state, data){
      state.breweries = data;
    },
    SET_ACTIVE_BREWERY(state, data){
      state.activeBrewery = data;
    },
    SET_ACTIVE_BEER(state, data){
      state.beer = data;
    },
    SET_BEER_LIST(state, data){
      state.beerList = data;
    }
  }
})
