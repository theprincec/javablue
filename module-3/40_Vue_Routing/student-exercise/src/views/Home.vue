<template>
  <div class="home"> 
      <h1> SUB-PAGE. home view </h1>
      <best-seller-list/>
      <new-releases-list/>
  </div>
</template>



<script>
import BestSellerList from '@/components/BestSellerList.vue';
import NewReleasesList from '@/components/NewReleasesList.vue';
// import BestSellerList from '../components/BestSellerList.vue';
// import NewReleasesList from '../components/NewReleasesList.vue';

export default {
    name: 'Home',
    components: {
        BestSellerList,
        NewReleasesList
    }

}
</script>


<style>

</style>