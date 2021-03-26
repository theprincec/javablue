<template>
  <div class="reviews">
      <review-display 
        v-for="reviewFromArray in filteredReviews" 
        v-bind:key="reviewFromArray.id"
        v-bind:review="reviewFromArray"
         />
         <div v-if="noReviewsFound">
             <p>No {{ $store.state.filter }} Star Reviews Found</p>
         </div>
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay.vue'
export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviews = this.$store.state.reviews;
            const filter = this.$store.state.filter;
            return reviews.filter( review => {
                return filter === 0 ? true : filter === review.rating;
            });
        },
        noReviewsFound() {
            return this.filteredReviews.length === 0;
        }
    }
}
</script>

<style>

</style>