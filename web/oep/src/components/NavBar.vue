<template>
  <nav id="navbar" skip-link-title="navigation bar">
    <ul>
      <li><router-link to="/"><p tabindex="0"><img src="@/assets/logo.svg" alt="home"></p></router-link></li>

      <li v-for="link in links" :key="link">
        <router-link v-bind:to="link.to"><p tabindex="0">{{link.text}}</p></router-link>
      </li>
      <li><p>example student</p><img src="@/assets/user.png" alt="home"></li>
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
    height: 4em;
    display: flex;
    &:first-child {
      height: 2em;
      padding: 0 0.5em;
      a {
        height: 100%;
        padding: 0;
        background-color: unset !important;
        p {
          font-size: initial;
        }
      }
    }
    &:last-child {
      float: right;
      p {
        font-size: 2em;
        margin: 0.5em;
      }
    }
    a {
      display: flex;
      text-align: center;
      color: black;
      padding: 0.5em;
      font-size: 2em;
      text-decoration: none;
      p {
        margin: 0;
      }
      &:hover, &:focus-within, &:active {
        background-color: @primary-colour-hover;
      }
      &[aria-current="page"] {
        background: @primary-colour-hover;
      }
    }
    img {
      height: 4em;
    }
  }
}
</style>