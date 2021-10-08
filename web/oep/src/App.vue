<template>
  <nav-bar v-bind:links="links"></nav-bar>
  <router-view/>
</template>

<style>

</style>
<script>
import NavBar from "@/components/NavBar";
export default {
  components: {NavBar},
  data() {
    return {
      links: [
        {to: '/', text: 'classes'},
        {to: '/grades', text: 'grades'},
        {to: '/', text: 'email'}
      ]
    }
  }
}
</script>