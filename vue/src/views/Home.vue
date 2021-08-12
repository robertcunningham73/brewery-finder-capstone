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
</style>