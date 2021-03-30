<template>
  <div id="app">
    <h1>{{ $store.state.storeName }}</h1>
    <product-filter />
    <main>
        <product-list />
      </main>
  </div>
</template>

<script>
import ProductList from '../src/components/ProductList.vue'
import ProductFilter from '../src/components/ProductFilter.vue'

export default {
  name: 'App',
  components: {
    ProductList,
    ProductFilter
   
  },
  mounted() {
    this.$store.dispatch("getProducts");
  }
}
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  
  }
  div#app main {
    display: flex;
    align-content: center;
    justify-content: center;
  }
  div#app a {
    display: inline-block;
    margin-top: 10px;
    text-decoration: none;
    color: darkblue;
    font-weight: 600;
  }
  div#app a:hover {
    color: blue;
  }
</style>
