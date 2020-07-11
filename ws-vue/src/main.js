// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import router from './router'
import {fetch, post, patch} from './providers/http-service'
import {dateFormat} from './components/DateFormat'
import {setCookie, getCookie} from './util/CookieUtil'

Vue.config.productionTip = false
Vue.prototype.$axiosPost = post
Vue.prototype.$axiosGet = fetch
Vue.prototype.$axiosPatch = patch
Vue.prototype.myDateFormat = dateFormat
Vue.prototype.setCookie = setCookie
Vue.prototype.getCookie = getCookie
Vue.use(ElementUI)


/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {App},
  template: '<App/>'
})

