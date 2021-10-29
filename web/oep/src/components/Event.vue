<template>
  <router-link
    :to="to"
  >
    <event-box
      :title="title"
      :x="this.x"
      :width="this.width"
      v-if="this.width !== 0"
    />
    <deadline
      :x="this.x"
      :title="this.title"
      v-else
    />
  </router-link>
</template>

<script>
import Deadline from "@/components/Deadline";
import EventBox from "@/components/EventBox";
export default {
  name: "Event",
  components: {EventBox, Deadline},
  props: {
    title: String,
    to:String,
    stroke:String,
    timeFrame:{
      from: Date,
      to: Date
    }
  },
  beforeCreate() {
    this.width = (this.timeFrame.to - this.timeFrame.from) * 12.5 / 3600000
    this.x = (this.timeFrame.from - new Date()) * 12.5 / 3600000
  },
  mounted() {
    this.interval = setInterval(this.updateCurrentTime, 10000);
  },
  unmounted() {
    clearInterval(this.interval);
  },
  methods: {
    async updateCurrentTime() {
      this.x = (this.timeFrame.from - new Date()) * 12.5 / 3600000;
      this.$forceUpdate();
    },
    calcPositionXText() {
      const centerPercentage = this.x + (this.width / 2);
      if (centerPercentage > 100) {
        return this.x
      } else if (centerPercentage < 0 && this.x + this.width > 0) {
        return 0
      } else {
        return centerPercentage
      }
    },
    calcTextAnchor() {
      const centerPercentage = this.x + (this.width / 2);
      if (centerPercentage > 100) {
        return 'unset'
      } else if (centerPercentage < 0 && this.x + this.width > 0) {
        return 'unset'
      } else {
        return 'middle'
      }
    }
  }
}
</script>

<style scoped lang="less">
  text {
    dominant-baseline: central;
  }
</style>