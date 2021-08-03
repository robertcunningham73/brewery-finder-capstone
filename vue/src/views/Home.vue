<template>
<div class = "content" id="right-bar">
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this</p>
  </div>
</div>
</template>

<script>
export default {
  name: "home"
};
</script>
<style>
  /* #right-bar{
    height: 100%;
    width: 100%;
    position: absolute;
    right: 0;
    top:0;
    text-align: center;
  } */

  .content{
    background: linear-gradient(rgb(224,159,62), rgb(158,42,43));
    height: 100%;
    width: 100%;
    position: absolute;
    right: 0;
    top:0;
    text-align: center;
  }
</style>