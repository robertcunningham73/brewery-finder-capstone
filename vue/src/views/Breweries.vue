<template>
  <div class="content">
    <brewery-list />
    <div id="brewery-list-img">
      <img :src="require(`@/assets/casks.jpg`)"/>
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
brewery-list.img{
  height:  100%;
  width: 125%;
  position: relative;
  top: 0;
}


</style>