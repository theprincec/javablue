import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'


Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    storeName: 'Java Blue Mart',
    products: [],
    categories: ['All', 'Home', 'Apparel', 'Jewelry', 'Garden'],
    category: 'All'
  },
  mutations: {
    SET_PRODUCTS(state, products) {
      state.products = products;
    },
    SET_CATEGORY(state, category) {
      state.category = category;
    }
  },
  actions: {
    getProducts( {commit} ) {
      axios.get('products.json').then( response => {
        commit('SET_PRODUCTS', response.data);
      })
    }
  },
  modules: {
  },
  strict: true
})
