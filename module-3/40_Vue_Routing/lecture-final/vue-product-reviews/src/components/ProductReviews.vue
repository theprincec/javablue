<template>

    <div class="main">
        
    
 
    </div>
</template>

<script>

export default {
    name: 'product-reviews',
    data() {
        return {
            
            // showForm and newReviw move to AddReview.vue
            
        
        }
    },
    computed: {
        // filteredReviews: move to ReviewList.vue
     


        // isFormValid: Move to AddReview.vue
  
    },
    methods: {
  
        // addNewReview and resetForm: Move to AddReview.vue

    }
}
</script>


<style scoped>

/* Move these styles to App.vue */
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


/* Move these styles to ReviewDisplay.vue */
div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

div.main div.review div.rating img {
    height: 100%;
}

div.main div.review p {
    margin: 20px;
}

div.main div.review h3 {
    display: inline-block;
}

div.main div.review h4 {
    font-size: 1rem;
}

div.main div.review.favorited {
    background-color: lightyellow;
}



/* Move these styles to AddReview.vue */
div.form-element {
 margin-top: 10px;
}
div.form-element > label {
 display: block;
}
div.form-element > input, div.form-element > select {
 height: 30px;
 width: 300px;
}
div.form-element > textarea {
 height: 60px;
 width: 300px;
}
form > input[type=button] {
 width: 100px;
}
form > input[type=submit] {
 width: 100px;
 margin-right: 10px;
}


</style>


