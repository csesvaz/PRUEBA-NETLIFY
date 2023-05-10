import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import './scss/styles.scss'
import router from './router/router.js'
import 'primevue/resources/themes/saga-blue/theme.css'
import 'primevue/resources/primevue.min.css'
import 'primeicons/primeicons.css'

// Importar Pinia
import { createPinia } from 'pinia'
const pinia = createPinia()

// import firebase from './firebase/firebase.js'

import * as bootstrap from 'bootstrap'

// Importar fontawesome
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { library } from "@fortawesome/fontawesome-svg-core";
import { fas } from "@fortawesome/free-solid-svg-icons";
import { far } from "@fortawesome/free-regular-svg-icons";
import { fab } from "@fortawesome/free-brands-svg-icons";
library.add(fas);
library.add(far);
library.add(fab);

import PrimeVue from 'primevue/config'


// Importar Firebase
import { VueFire, VueFireDatabaseOptionsAPI, VueFireFirestoreOptionsAPI } from 'vuefire'

//Crear App
createApp(App)
  .component("fa", FontAwesomeIcon)
  .use(PrimeVue)
  .use(router)
  .use(pinia)
  .use(VueFire, {
    modules: [
      VueFireFirestoreOptionsAPI(),
      VueFireDatabaseOptionsAPI(),
    ]
  })
  .mount('#app')
