<template>
  <nav>
    <ol>
      <router-link :to="`/class/${this.$route.params.className}`">{{ this.$route.params.className }}</router-link>
    </ol>
  </nav>
</template>

<script>
export default {
  name: "ClassNavBar"
}
</script>

<style scoped lang="less">
@import "public/main";
  nav {
    width: 15vw;
    background-color: @idk-1;
    position: relative;
    height: 90vh;
  }
a {
  text-decoration: none;
  color: black;
}
</style>