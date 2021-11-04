<template>
  <div/>
</template>


<script>
// import app from "@/main";

export default {
  name: "ModLoader",
  data() {
    return {
      mods: [
        {name:'/api/js/testimportmod/testimporter.js'}
      ]
    }
  },
  created() {
    // import(/*webpackIgnore: true*/ '/api/js/testimportmod/testimporter.js')
    //     .then(mod => {
    //       app.use(mod.default, {root:this.$root})
    //     })
  }
}
</script>

<style scoped>

</style>