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
  #right-bar{
    display: flex;
    align-self: center;
    flex: 1 0 auto;
    justify-content: center;
    flex-direction: column;
  }
</style>