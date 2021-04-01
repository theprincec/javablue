<template>
  <div v-bind:class="{read : book.read}" class="card">
      
    
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
   
    <p class="book-title"> {{book.title}}</p>
      <p class="book-author"> {{book.author}}</p>
     <!-- <p> {{book.read}}</p> -->
      <p> {{book.isbn}}</p>

    <button @click.prevent="changeReadStatus(book)"> {{ book.read==true ? 'mark-unread':'mark-read' }}</button>
    
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        changeReadStatus(book){
            return this.$store.commit('CHANGE_READ_STATUS', book) ;
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    background-color: aquamarine;
    padding: 40px 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>