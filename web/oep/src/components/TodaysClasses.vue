<template>
  <div>
    <class class-name="duits"/>
    <class class-name="frans"/>
    <class class-name="wiskunde"/>
    <class class-name="nederlands"/>
    <class class-name="test"/>
    <class class-name="hutspot"/>
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
  #div {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
</style>