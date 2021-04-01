<template>
  <div id="app">
    <h1>THE PAGE</h1>
    <nav>
      <router-link v-bind:to="{name: 'my-books'}"> MY BOOKS </router-link>
    </nav>

    <router-view/>
    
    
  </div>
</template>

<script>
//import Home from './views/Home.vue';

export default {
  name: 'app',
  // components: {
  //   Home
  // }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin: 60px;
}
</style>
