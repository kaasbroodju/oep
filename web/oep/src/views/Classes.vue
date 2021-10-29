<template>
  <div id="classes" skip-link-title="classes">
    <class v-for="index in 10" :key="index" :class-name="index"/>
  </div>
</template>

<script>
import Class from "@/components/Class";
export default {
  name: "Classes",
  components: {Class}
}
</script>

<style scoped lang="less">
  div {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
</style>