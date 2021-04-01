<template>
  <div class="product" v-bind:class="{ bestseller: product.is_top_seller }">
      <h2>{{ product.name }}</h2>
      <img v-bind:src="require('../assets/product-images/' + product.image_name)" />
      <div class="rating">
          <img src="../assets/star.png" class="ratingStar" 
            v-for="stars in numberOfStars" v-bind:key="stars.id"/>
          <img src="../assets/star_empty.png" class="ratingStar"
            v-for="s in numberOfEmptyStars" v-bind:key="s.id" />
      </div>
      <p>{{ formattedPrice }}</p>
      <div class="notices">
          <!-- display when is_top_seller is true -->
          <span v-if="product.is_top_seller" class="topseller">Top Seller</span>
          <!-- display when quantity is 0 -->
          <span v-if="!product.quantity" class="limitedstock">Sold Out</span>
          <!-- display when quantity is 1-3 -->
          <span v-if="product.quantity < 3 && product.quantity > 0" class="limitedstock">
              Only {{product.quantity}} Remain</span>
      </div>
  </div>
</template>

<script>
export default {
    name: 'product-list-item',
    props: ['product'],
    computed: {
        numberOfStars() {
            return parseInt(this.product.rating);
        },
        numberOfEmptyStars() {
            return 5 - parseInt(this.product.rating);
        },
        formattedPrice() {
            return '$' + Number(this.product.price).toFixed(2);
        }
    }

}
</script>

<style>
div.product {
    border: 1px black solid;
    width: 30%;
    margin: 20px;
    border-radius: 5px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

div.product.bestseller {
    background-color: lightyellow;
}
div.product img {
    width: 75%;
    max-height: 200px;
    align-self: center;
}
div.product h2 {
    font-size: 1.1rem;
    color: black;
}

div.rating {
    display: flex;
    justify-content: center;
    margin-top: 5px;

}
div.rating img.ratingStar {
    width: 20px;
}

div.product div.notices {
    display: flex;
    justify-content: space-between;
    align-content: flex-end;
    margin-right: 10px;
    margin-left: 10px;
    margin-bottom: 5px;
    font-weight: 800;
}
div.product div.notices span.topseller {
    color: blue;
}
div.product div.notices span.limitedstock {
    color: red;
}
button {
    margin-bottom: 5px;
}
</style>