<template>
  <div class="app-container" id="app">
      <nav-bar class="nav-bar"/>
      <router-view class="page-content"/>

  
   <!-- <div class ="img-beers">
      <img :src="require(`@/assets/beers.jpg`)"/>
     </div>  -->
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
    height: 100%;
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
    flex-direction: row;
  }
  
  .nav-bar {
    width: 200px;
    padding-top: 25px;
    background: linear-gradient(#183A37, #335c67);
    /* position: fixed; */
    font-family: 'Gravitas One', cursive;
  }

  .page-content {
    padding-top: 25px;
    /* flex: 1 0 auto; */
    text-align: center;
    background: linear-gradient(rgb(224,159,62), rgb(158,42,43));
    /* margin-left: 10em; */
    }

    h1{
      font-family: 'Gravitas One', cursive;
      font-size: 48px;
    }

    img {
      width: 100%;
      height: auto;
    }

    @media screen and (max-width: 600px){
      .app-container {
       display: flex;
        flex-direction: column;
      }
      .nav-bar{
        width: 100%;
        height: 200px;
        padding: 10px;
      }

    
    }

/*   @media only screen and (min-width: 700px) {
  .app-container {
   display: flex;
        flex-direction: column;
         width: 200%;
    height: 200%;
    display: flex;
    flex-direction: row;
}
} */
  

  /* .nav-container {
    grid-area: left-display;
    text-align: center;
  }
  
  .container{
    display: grid;
    grid-template-columns: 1fr 3fr;
    grid-template-areas: 
        "left-display right-display";
    text-align: center;
  }

  #nav {
    height: 100%;
    width: 20%;
    position: fixed;
    left: 0;
    top: 0;
    padding-top: 20px;
    padding-bottom: 20px;
    overflow-x: hidden;
    background: linear-gradient(#183A37, #335c67);
    border-top-right-radius: 15px;
    border: transparent;
    z-index: 1;
      } */
</style>
