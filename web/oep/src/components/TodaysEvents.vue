<template>
  <svg width="80%" height="288px">
    <event v-for="item in items"
           :title="item.title"
           :to="item.to"
           :stroke="item.stroke"
           :time-frame="item.timeFrame"
           v-bind:key="item"
           class="event"
    ></event>
    <line :x1="1/8*100 + '%'" y1="0%" :x2="1/8*100 + '%'" y2="95%" stroke="black" stroke-width="3px"></line>
    <text
        :x="1/8*100 + '%'"
        y="100%"
        text-anchor="middle"
    >now</text>
  </svg>
</template>

<script>
import Event from "@/components/Event";
export default {
  name: "TodaysEvents",
  components: {Event},
  data() {
    return {
      items: [
        {
          title: 'gilde',
          to:'gilde',
          stroke: 'yellow',
          timeFrame:{
            from: new Date(2021, 9, 29, 14, 30),
            to: new Date(2021, 9, 29, 18, 0)
          }
        },
        {
          title: 'training',
          to:'training',
          stroke: 'red',
          timeFrame:{
            from: new Date(2021, 9, 29, 20, 30),
            to: new Date(2021, 9, 29, 22, 0)
          }
        },
        {
          title: 'deadline',
          to:'dealine',
          stroke: 'green',
          timeFrame:{
            from: new Date(2021, 9, 29, 18, 0),
            to: new Date(2021, 9, 29, 18, 0)
          }
        },
      ]
    }
  }
}
</script>

<style scoped lang="less">
  .event {
    position: relative;
  }
  #todayEvents {
    overflow: hidden;
  }
</style>