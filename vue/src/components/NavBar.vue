<template>
  <nav class="nav-bar" id="left-bar">
    <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''">Home</router-link>
    <router-link :to="{name: 'breweries'}" v-if="$store.state.token != ''">Breweries</router-link>
    <div class="all-beers-button" v-if="$store.state.token != ''">
      <router-link :to="{name: 'beerList'}" v-if="this.$store.state.user.authorities[0].name != 'ROLE_BREWER'">All Beers</router-link>
    </div>
    <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
  </nav>
</template>

<script>
export default {
  
}
 

</script>

<style>

  #left-bar{
  display: flex;
  justify-content: flex-start;
  align-items: center;
  flex-direction: column;
  height: 100%;
  }

  .nav-bar a{
    color: #EFD6AC;
  }
  
  a {
    height: 60px;
    color: #183A37;
    font-size: 26px;
  } 

  div.all-beers-button{
    height: 60px;
    color: #183A37;
    font-size: 26px;
  }

</style>