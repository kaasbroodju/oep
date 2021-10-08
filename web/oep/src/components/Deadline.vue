<template>
  <line
      :x1="this.x + '%'" y1="0%"
      :x2="this.x + '%'" y2="47.5%"
      stroke="red"
      stroke-width="3px"
  />
  <text
    :x="this.x + '%'"
    y="50%"
  >
    {{ this.title }}
  </text>
  <line
      :x1="this.x + '%'" y1="52.5%"
      :x2="this.x + '%'" y2="100%"
      stroke="red"
      stroke-width="3px"
  />

</template>

<script>
export default {
  name: "Deadline",
  props: {
    x: Number,
    title: String
  }
}
</script>

<style scoped lang="less">
text {
  dominant-baseline: central;
  text-anchor: middle;
}
</style>