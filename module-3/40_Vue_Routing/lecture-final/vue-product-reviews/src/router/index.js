import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound'
import Store from '@/store/index'
import WatcherExample from '@/views/WatcherExample'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/products/:id/add',
    name: 'add-review',
    component: AddReview
  },
  {
    path: '/products',
    redirect: { name: 'products'}
  },
  {
    path: '/watcherexample',
    name: 'watcher-example',
    component: WatcherExample
  },
  {
    path: '*',
    name: 'notFound',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// to - where the user is going
// from - where the user came from
// next - an object to get them to their next location
router.beforeEach( (to, from, next) => {
  if (to.name == 'product-detail' || to.name == 'add-review') {
    const id = to.params.id;
    const product = Store.state.products.find( 
      product => { return product.id == id });
    if (!product) {
      // redirect the user to the 404
      next( { name: 'notFound' } );
    }
  }
  // send the user to where they trying to go
  next();
})

export default router
