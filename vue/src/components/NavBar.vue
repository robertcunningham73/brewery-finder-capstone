<template>
  <nav class="nav-bar" id="left-bar">
    <div id="nav-logo">
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''"><img :src="require(`@/assets/bf-logo-teal.png`)"/></router-link>
    </div>
    <div id="nav-text">
      <router-link class="nav-router" :to="{name: 'breweries'}" v-if="$store.state.token != ''">Breweries</router-link>
    <div class="all-beers-button" v-if="$store.state.token != ''">
      <router-link class="nav-router" :to="{name: 'beerList'}">All Beers</router-link>
    </div>
    <div id="logout">
      <router-link class="nav-router" id="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> 
    </div>
  </nav>
</template>

<script>
export default {
  
}
 

</script>

<style scoped>

  #left-bar{
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-direction: column;
  /* height: 100%; */
  z-index: 1;
  }

  .nav-bar a{
    color: #EFD6AC;
    padding: 0px 24px;
    margin-left: 5px;
  }
  
  a {
    height: 60px;
    font-size: 26px;
  } 

  /* div.all-beers-button{
    height: 60px;
    color: #183A37;
    font-size: 26px;
  } */

#nav-logo{
  display: flex;
  justify-content: flex-start;
  align-content: flex-start;
  height: 200px;
  width: 200px;
  padding-bottom: 0;
}

#logout{
  /* position: absolute; */
  bottom: 50px;
  left: 20px;
  padding-top: 300px;
}

@media screen and (max-width: 600px){
  #left-bar{
    display: flex;
    flex-direction: row;
  }
   #logout{
     display: flex;
     justify-content: flex-start;
     padding-top: 60px;
     font-size: smaller;
     /* bottom: 10px;
     left: 100px; */
     /* stick to bottom of the viewport rather than bottom of the nav bar */
  } 
  #nav-text{
    top:0;
    padding-left: 55px;
  }
  #nav-logo{
    height: 125px;
    width: 125px;
    display: block;
  }
  .nav-router{
    font-size: 18px;
  }
}

</style>