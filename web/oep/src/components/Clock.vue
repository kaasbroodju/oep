<template>
  <svg viewBox="0 0 100 100">
    <circle cx="50" cy="50" r="40"/>
    <line id="bigLine" x1="50" y1="50" :x2="big.x" :y2="big.y" :key="big" stroke="black" />

    <line id="smallLine" x1="50" y1="50" :x2="small.x" :y2="small.y" :key="small" stroke="red" />
    <circle cx="50" cy="50" r="40" stroke="black" stroke-width="0" fill="red !important" />
  </svg>
</template>

<script>
export default {
  name: "Clock",
  data() {
    return {
      big: {
        x:50,
        y:50,
        size: 35
      },
      small: {
        x:50,
        y:50,
        size: 27.5
      },
    }
  },
  created() {
    this.updatePointers();
    this.interval = setInterval(this.updatePointers, 1000);
  },
  unmounted() {
    clearInterval(this.interval);
  },
  methods: {
    toCoordinates(degree) {
      const radiant = (degree - 90) * (Math.PI / 180);
      return {x: Math.cos(radiant), y:Math.sin(radiant)}
    },
    async updatePointers() {
      const date = new Date();
      let small = this.toCoordinates(((date.getHours() % 12) + (date.getMinutes()/60)) * 30);
      let big =  this.toCoordinates(date.getMinutes() * 6);
      this.big.x = 50 + (this.big.size * big.x)
      this.big.y = 50 + (this.big.size * big.y);
      this.small.x = 50 + (this.small.size * small.x)
      this.small.y = 50 + (this.small.size * small.y)
    }
  }
}
</script>

<style scoped lang="less">
  svg {
    height: auto;
    width: 100%;
    stroke-width: 5px;
    circle {
      fill: none;
      stroke: black;
    }
  }
</style>