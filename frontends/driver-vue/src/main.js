import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import * as VueGoogleMaps from 'gmap-vue'
import store from './store';
Vue.config.productionTip = false
import router from './router'

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyD1MQSxcqK4KNG-0b5co-Ev5qQGzlExYEM',
    libraries: 'places', 
  },

  installComponents: true
})

new Vue({
  vuetify,
  store,
  router,
  render: h => h(App)
}).$mount('#app')


