<template>
  <div class="book-container">
      <book-card
        v-for="book in $store.state.books"
        v-bind:key="book.isbn"
        v-bind:book="book"/>
  </div>

</template>

<script>

import BookCard from './BookCard.vue';

export default {
    name: 'reading-list',
    components: { BookCard },
    computed: {
      books(){
        const bookList = this.$store.state.books;
        return bookList;
      }
    }
}
</script>

<style>
.book-container {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    padding: 40px;
    border: 2pt solid pink;
}
</style>