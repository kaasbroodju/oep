<template>
  <div>
    <router-link to="#test">refresh token</router-link>
  </div>
</template>

<script>
export default {
  name: "AutoSkipLinks",
  data() {
    return {
      links: []
    }
  },
  mounted() {
    setTimeout(this.refreshLinks, 1000);
  },
  methods: {
    refreshLinks()  {
      const skipLinksElements = document.querySelectorAll("[skiplinkable]");
      const skipLinksArray = [].slice.call(skipLinksElements);
      console.log(skipLinksArray.sort((a, b) => this.sorter(a, b)));
      this.links = skipLinksArray.sort((a, b) => this.sorter(a, b))


    },
    sorter(a, b) {
      return a.tabindex - b.tabindex;
    }
  },
  watch:{
    $route (){
      this.refreshLinks();
    },
  }

}
</script>

<style scoped lang="less">

</style>