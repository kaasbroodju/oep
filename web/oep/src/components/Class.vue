<template>
  <div class="classWrapper" skiplinkable>
    <router-link to="/classes">
      <img src="@/assets/duits.png" alt="">
      <h2 tabindex="0">duits</h2>
    </router-link>
  </div>
</template>

<script>
export default {
  name: "Class"
}
</script>

<style scoped lang="less">
  .classWrapper {
    width: 20vw;
    display: inline-block;
    margin: 1em;
    img {
      width: 100%;
    }
    text-align: center;
    > a {
      text-decoration: none;
      color: black;
      h2 {
        margin: 0;
      }
    }
  }
</style>