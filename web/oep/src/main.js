import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import * as idk from '../mods/static/mod/src/main';

const app  = createApp(App)
app.use(router)

const root = app.mount('#app')
app.use(idk.default, {root:root.$root})

export default app