<template>
<div class = "content" id="right-bar">
  <div class="home">
    <h1>Brewery Finder</h1>
    <p><b><em>Your One Stop Resource To Find Your Favorite Brewery And Beers</em></b></p>
  </div>
  <div id="img-flex">
    <div class="img-home">
      <img :src="require(`@/assets/beers.jpg`)"/>
     </div>
  </div>
    
</div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style scoped>
#img-flex{
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-top: 15px;
}

.img-home{
  max-width: 100%;
}

/* @media screen and(max-width: 840px){
  img{
    height: 20vh;
    width: 30vw;
  } 
}*/

/* .home{
  background-image: url("C:\Users\Student\workspace\phl-4-final-capstone-green-001\vue\src\assets\beers.jpg");
}  */
   /*#right-bar{
    height: 100%;
    width: 600px;
    position: absolute;
    right: 0;
    top:0;
    text-align: center;
  } */

  /* .content{
    background: linear-gradient(rgb(224,159,62), rgb(158,42,43));
    height: 100%;
    width: 100%;
    position: absolute;
    right: 0;
    top:0;
    text-align: center;
  } */
</style>