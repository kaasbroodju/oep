<template>
  <rect
      tabindex="0"
      :x="this.x + '%'"
      y="0"
      height="100%"
      :width="this.width + '%'"
      :key="this.x"
  />
  <text
      :x="this.calcPositionXText() + '%'"
      y="50%"
      :text-anchor="this.calcTextAnchor()"
      :key="this.x"
  >{{title}}</text>
</template>

<script>
export default {
  name: "EventBox",
  props: {
    title: String,
    x: Number,
    width: Number
  },
  methods: {
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
rect {
  stroke: gray;
  fill: darkgray;
  opacity: 0.25;
  &:hover, &:focus-within, &:active {
    opacity: 0.50;
  }
}
</style>