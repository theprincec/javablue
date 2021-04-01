<template>
  <form class="new-book-form">
     <h1>Add a Book</h1>
      <label> Title </label>
      <div> 
        <input class="title-input" v-model="$store.state.newBook.title">
      </div>

      <label> Author </label>
      <div> 
        <input class="author-input" v-model="$store.state.newBook.author">
      </div>
      
      <label> ISBN </label>
      <div> 
        <input class="isbn-input" v-model="$store.state.newBook.isbn">
      </div>
      <button> Add Book </button>
      
  </form>

</template>

<script>
export default {
    name: 'new-book-form'

}
</script>

<style>

.new-book-form{
    border: 2px solid pink;
    margin-top: 40px;
    padding: 20px;

}
.new-book-form button{
    margin: 10px;
    background-color: pink;
    border-radius: 5px;
    min-width: 60%;
}
.new-book-form input{
    min-width: 60%;
}
.new-book-form input:focus{
    border: 2px solid pink;
    background-color: pink;
    opacity: .3;
}

</style>