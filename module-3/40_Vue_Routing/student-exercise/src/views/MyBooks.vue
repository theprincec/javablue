<template>
    <div class="my-books">
        <reading-list/>
        <router-link v-bind:to="{name: 'new-book'}"> Add a book </router-link>
    </div>
</template>

<script>
//import MyBooks from '@/components/ReadingList.vue';
import ReadingList from '@/components/ReadingList.vue';

export default {
    components:{
        ReadingList
    }

}
</script>

<style>


</style>