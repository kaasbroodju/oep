<template>
  <rect
      tabindex="0"
      :x="this.x + '%'"
      y="0"
      height="100%"
      :width="this.width + 'px'"
      :transform="`translate(-${this.width/2}, 0)`"
  />
  <line
      :x1="this.x + '%'" y1="0%"
      :x2="this.x + '%'" y2="47.5%"
  />
  <text
    :x="this.x + '%'"
    y="50%"
    ref="testo"
  >
    {{ this.title }}
  </text>
  <line
      :x1="this.x + '%'" y1="52.5%"
      :x2="this.x + '%'" y2="100%"
  />

</template>

<script>
export default {
  name: "Deadline",
  props: {
    x: Number,
    title: String
  },
  data() {
    return {
      width: 10
    }
  },
  mounted() {
    this.width = this.$refs.testo.getBBox().width
  }
}
</script>

<style scoped lang="less">
text {
  dominant-baseline: central;
  text-anchor: middle;
}
rect {
  opacity: 0;
  &:hover ~ line {
    stroke: darkred;
  }
}
line {
  stroke: red;
  stroke-width: 3px;
}
</style>