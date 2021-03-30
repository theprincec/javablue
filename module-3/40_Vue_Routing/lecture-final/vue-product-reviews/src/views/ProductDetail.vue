<template>
  <div id="app" class="main">
    <h2>{{ product.name }}</h2>
    <p class="description">{{ product.description }}</p>

    <div class="actions">
        <router-link v-bind:to="{ name: 'products'}"
            >Back to Products</router-link>
        &nbsp;|
        <router-link v-bind:to="{ name:'add-review', params: { id: product.id }}">
            Add Reviews</router-link>
    </div>

    <div class="well-display">
      <average-summary />
      <star-summary rating="1" />
      <star-summary rating="2" />
      <star-summary rating="3" />
      <star-summary rating="4" />
      <star-summary rating="5" />
    </div>

    <review-list />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary.vue'
import StarSummary from '@/components/StarSummary.vue'
import ReviewList from '@/components/ReviewList.vue'

export default {
    name: 'product-detail',
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    computed: {
        product() {
            return this.$store.state.products.find( product => {
                return product.id == this.$store.state.activeProduct;
            })
        }
    },
    created() {
        // $route is an object representing the URL
        // params is an object that is a property of $route that
        //    represents the parameters on a URL
        // id is named id in the router/index.js route definition
        const productIdFromUrl = this.$route.params.id; 
        this.$store.commit('SET_ACTIVE_PRODUCT', productIdFromUrl);
    }
}
</script>

<style>
div.main {
    margin: 1rem 0;
}
div.main div.well-display {
    display: flex;
    justify-content: space-around;
}

div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.main div.well-display div.well span.amount:hover {
    color: blue;
    cursor: pointer;
}
</style>