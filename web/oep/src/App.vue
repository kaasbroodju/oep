<template>
  <auto-skip-links></auto-skip-links>
  <nav-bar v-bind:links="links"></nav-bar>
  <router-view/>
</template>

<style>

</style>
<script>
import NavBar from "@/components/NavBar";
import AutoSkipLinks from "@/components/AutoSkipLinks";
export default {
  components: {AutoSkipLinks, NavBar},
  data() {
    return {
      links: [
        {to: '/classes', text: 'classes'},
        {to: '/grades', text: 'grades'},
        {to: '/', text: 'email'}
      ]
    }
  }
}
</script>