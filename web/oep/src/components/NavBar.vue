<template>
  <nav>
    <ul>
      <li><router-link to="/"><img src="@/assets/logo.svg" tabindex="0" alt="home"></router-link></li>

      <li v-for="link in links" :key="link">
        <router-link v-bind:to="link.to" onfocus="console.log('hey')">{{link.text}}</router-link>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
  props: {
    links: Array
  }
}
</script>

<style scoped lang="less">
@import "public/main";
nav {
  background: @primary-colour;
  ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
  }

  li {
    float: left;
    &:first-child a {
      padding: 0 0.5em;
      background: inherit !important;
    }
    a {
      display: flex;
      text-align: center;
      color: black;
      padding: 0.5em;
      font-size: 2em;
      text-decoration: none;
      &:hover, &:focus, &:active {
        background-color: @primary-colour-hover;
      }
      &[aria-current="page"] {
        background: @primary-colour-hover;
      }
    }
  }
  img {
    height: 2.158em;
  }
}
</style>