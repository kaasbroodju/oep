<template>
  <nav>
    <router-link
      v-for="link in links"
      :key="link"
      :to="{id:link.id}"
      @click="goto(link.title)"
    >
      <p tabindex="0">| {{link.title}} |</p>
    </router-link>
  </nav>
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
    // todo dirty implementation after page load get links
    setTimeout(this.refreshLinks, 1000);
  },
  methods: {
    refreshLinks()  {
      this.links = Array.from(document.querySelectorAll("[skip-link-title]"))
          .filter(this.dataValidator)
          .sort(this.sorter)
          .map(this.mapper)
    },
    dataValidator(skipLink) {
      if (skipLink.attributes["skip-link-title"].nodeValue === undefined) {
        console.error("missing id on element");
        return false;
      } else if (skipLink.id === undefined) {
        console.error("missing id on element");
        return false;
      }
      return true
    },
    sorter(a, b) {
      return a.tabindex - b.tabindex;
    },
    mapper(skipLink) {
      const title = skipLink.attributes["skip-link-title"].nodeValue
      const id = skipLink.id
      if (title === undefined) console.error("tile");
      return {
        title,
        id
      }
    },
    goto(skipLinkId) {
      const element = document.querySelector(`[skip-link-title="${skipLinkId}"]`);
      element.scrollIntoView();
      element.focus()
    }
  },
  watch:{
    $route (){
      // todo dirty implementation after page load get links
      setTimeout(this.refreshLinks, 1000);
    },
  }

}
</script>

<style scoped lang="less">
// todo temp for lay-out
  nav {
    display: inline-flex;
  }
</style>