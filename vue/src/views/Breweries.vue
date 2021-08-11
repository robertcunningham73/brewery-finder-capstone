<template>
  <div class="content">
    <brewery-list />
    <div id="brewery-list-img">
      <!-- <img :src="require(`@/assets/casks.jpg`)"/> -->
    </div>
  </div>
  
</template>

<script>
import BreweryList from '../components/BreweryList.vue';

export default {
  components: {
    BreweryList
  }
}
</script>

<style>
brewery-list-img{
  height:  300px;
  width: 600px;
  display: flex;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-bottom: 15px;
}


</style>