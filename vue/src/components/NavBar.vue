<template>
  <nav class="nav-bar" id="left-bar">
    <div id="nav-logo">
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token == ''"><img :src="require(`@/assets/bf-logo-teal.png`)"/></router-link>
      <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''"><img :src="require(`@/assets/bf-logo-teal.png`)"/></router-link>
    </div>
    <div id="nav-text">
      <router-link class="nav-router" :to="{name: 'breweries'}" v-if="$store.state.token != ''">Breweries</router-link>
    <div class="all-beers-button" v-if="$store.state.token != ''">
      <router-link class="nav-router" :to="{name: 'beerList'}">All Beers</router-link>
    </div>
      <router-link class="nav-router" id="logout-link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div> 
  </nav>
</template>

<script>
export default {
  
}
 

</script>

<style scoped>

#nav-text{
  display: flex;
  flex-direction: row;
  flex-grow: 4;
  justify-content: flex-end;
  height: 30px;
}

  #left-bar{
  display: flex;
  justify-content: flex-start;
  flex-direction: row;
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

#nav-logo{
  display: flex;
  justify-content: flex-start;
  align-content: flex-start; 
  height: 200px;
  width: 200px;
  padding-bottom: 0;
}

@media screen and (max-width: 840px){
  img{
    height: 140px;
    width: 140px;
  }
}

@media screen and (max-width: 400px){
  img{
    height: 120px;
    width: 120px;
  }
}

@media screen and (max-width: 800px){
  #nav-text{
    display: flex;
    flex-direction: column;
    align-items: flex-end;
    justify-content: flex-start;
  }
}

@media screen and (max-width: 600px){
  #left-bar{
    display: flex;
    flex-direction: row;
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