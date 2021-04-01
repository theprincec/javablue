<template>
  <div class="home">
    <h1>{{ $store.state.storeName }}</h1>
    <product-filter />
    <main>
      <product-list />
    </main>
  </div>
</template>

<script>
import ProductList from '@/components/ProductList.vue'
import ProductFilter from '@/components/ProductFilter.vue'

export default {
  name: "home",
  components: {
    ProductList,
    ProductFilter
   
  },
};
</script>

<style>
div.home {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  
  }
 div.home main {
    display: flex;
    align-content: center;
    justify-content: center;
  }
div.home a {
    display: inline-block;
    margin-top: 10px;
    text-decoration: none;
    color: darkblue;
    font-weight: 600;
  }
div.home a:hover {
    color: blue;
  }
</style>
