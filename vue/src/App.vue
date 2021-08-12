<template>
  <div class="app-container" id="app">
      <nav-bar class="nav-bar">
        <router-link v-bind:to="{ name: 'home' }" v-if="$store.state.token != ''"><img :src="require(`@/assets/bf-logo-teal.png`)"/></router-link>
      </nav-bar>
      <router-view class="page-content"/>
     </div> 
</template>

<script>
import NavBar from './components/NavBar.vue'
export default {
  components: { NavBar },
  
}
</script>
<style>
@import url('https://fonts.googleapis.com/css2?family=Montserrat&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Gravitas+One&display=swap');

   html {
    width: 100%;
    height: 100%;
    margin: 0px;
    padding: 0px;
    overflow-x: hidden; 
  }

  body {
    height: 100%;
    margin: 0;
    border: 0;
    font-family: 'Montserrat', sans-serif;
    color: #183A37;
  }
  
  .app-container {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    overflow-x: hidden;
  }
  
  .nav-bar {
    width: 100%;
    padding-top: 25px;
    background: #183A37;
    font-family: 'Gravitas One', cursive;
  }

  .page-content {
    padding-top: 25px;
    flex: 1 0 auto;
    text-align: center;
    background: linear-gradient(rgb(224,159,62), rgb(158,42,43));
    
    }

    h1{
      font-family: 'Gravitas One', cursive;
      font-size: 48px;
    }

    img {
      width: 100%;
      height: auto;
    }

    a:link{
    text-decoration: none;
    }

    a:hover{
    text-decoration: underline;
    }
    a{
      color:#183A37;
    }

    #img-sign{
      height: 200px;
      width: 200px;
    }

    @media screen and (max-width: 600px){
      .app-container {
        display: flex;
        flex-direction: column;
        max-width: 100%;
      }
      .nav-bar{
        width: 100%;
        height: 150px;
        padding: 10px;
      }

      h1{
        font-size: 24px;
      }

    }
</style>
