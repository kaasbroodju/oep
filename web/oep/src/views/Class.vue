<template>
  <div>
    <class-nav-bar id="class-navigation" skip-link-title="class navigation bar"/>
    <router-view />
  </div>
</template>

<script>
import ClassNavBar from "@/components/ClassNavBar";
export default {
  name: "Class",
  components: {ClassNavBar},
  beforeCreate() {
    document.title = this.$route.params.className
  },
  unmounted() {
    document.title = this.$root.localOEPName;
  }
}
</script>

<style scoped>
  div {
    display: inline-flex;
  }
</style>