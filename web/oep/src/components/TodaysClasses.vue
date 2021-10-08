<template>
  <div id="todaysClasses">
    <class />
    <class />
    <class />
    <class />
    <class />
    <class />
  </div>

</template>

<script>
import Class from "@/components/Class";
export default {
  name: "TodaysClasses",
  components: {Class}
}
</script>

<style scoped lang="less">
  #todaysClasses {
    display: inline;
  }
</style>