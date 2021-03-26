<template>
  <div id="app">
    <product-reviews></product-reviews>
  </div>
</template>

<!--
  To add a component
  1. Add an import to the <script>
  2. Add the import name to the coponents section
  3. Use the imported component as a tag in the template
  -->

<script>
import ProductReviews from './components/ProductReviews.vue'

export default {
  name: 'App',
  components: {
    ProductReviews
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
</style>
