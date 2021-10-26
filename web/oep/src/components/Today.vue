<template>
  <div>
    <h1>today:</h1>
    <div id="today">
      <div style="width: 20vw">
        <Clock />
      </div>
      <div style="width: 80vw">
        <todays-events />
      </div>
    </div>
  </div>
  <div>
    <h1>classes today:</h1>
    <todays-classes />
  </div>

</template>

<script>
import Clock from "@/components/Clock";
import TodaysClasses from "@/components/TodaysClasses";
import TodaysEvents from "@/components/TodaysEvents";
export default {
  name: "Today",
  components: {TodaysEvents, TodaysClasses, Clock}
}
</script>

<style scoped lang="less">
  #today {
    display: inline;
    > div {
      display: inline-block;
    }
  }
</style>