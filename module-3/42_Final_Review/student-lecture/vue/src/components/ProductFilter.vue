<template>
  <div class="filter">
      <div>
          <label for="category">Category:</label>
          <select id="category" 
            v-model="selectedCategory"
            v-on:change="setCategoryFilter">
              <option v-for="cat in $store.state.categories" 
                v-bind:key="cat"
                v-bind:value="cat">{{ cat }}</option>
          </select>
      </div>
      <div>
          You are filtering on: {{ $store.state.category }}
      </div>
  </div>
</template>

<script>
export default {
    name:'product-filter',
    data() {
        return {
            selectedCategory: this.$store.state.category
        }
    },
    methods: {
        setCategoryFilter() {
            this.$store.commit("SET_CATEGORY", this.selectedCategory);
        }
    }
}
</script>

<style>

</style>