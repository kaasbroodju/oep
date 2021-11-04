import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import parseComponent from "@/loader";
// import {babelParse} from "@vue/compiler-sfc";
import * as test from "@vue/compiler-core"


const app  = createApp(App)
app.use(router)
const root = app.mount('#app')
import(/*webpackIgnore: true*/ '/api/js/testimportmod/testimporter.js')
    .then(mod => {
        app.use(mod.default, {root:root.$root})
    })
// babelParse()
export default app

fetch(
    'http://localhost:8080/api/js/testimportmod/Mod.vue',
    {headers:{'Accept-Encoding': 'gzip, deflate, br'}}
).then(function (repsonse) {
    return repsonse.text()
}).then(function (body) {
    return parseComponent(body)
}).then(parsed => console.log(parsed))

fetch(
    'http://localhost:8080/api/js/testimportmod/Mod.vue',
    {headers:{'Accept-Encoding': 'gzip, deflate, br'}}
).then(function (repsonse) {
    return repsonse.text()
}).then(function (body) {
    return test.baseCompile(test.baseParse(body)).code
}).then(parsed => console.log(parsed))

//app.component('hello-kitty', fetch('http://localhost:8080/api/js/testimportmod/Mod.vue'))

console.log(root.$router.getRoutes())