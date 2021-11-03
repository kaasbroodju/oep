<template>
  <component
      v-bind:is="'script'"
      src="/api/js/testimportmod/testimporter.js"
      defer="'defer'"
      type="module"
      async>
  </component>
</template>


<script>
export default {
  name: "ModLoader",
  methods: {
    loadMod(callback) {
      callback.call(this, this.$root)
    }
  },
  created() {
    window.loadMod = this.loadMod
  }
}
window.loadme = (callbackFunction) => {
  callbackFunction.call(this, window.modloader.$root)
}
</script>

<style scoped>

</style>