import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// import { importmod } from "./testimportmod/testimporter";

// eslint-disable-next-line no-unused-vars
const main = createApp(App).use(router).mount('#app')

for (const stringsKey in ['/api/js/testimportmod/testimporter.js']) {
    import(stringsKey)
        .then(
            (imported) => {
                console.log(imported)
                imported.importmod(main);
            })
}
