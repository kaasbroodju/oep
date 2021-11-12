import { createApp } from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from "vue-router";
import routes from './router/index'

async function main() {
    const app = createApp(App);
    const routeArray = await createRouterArray()
    app.use(createRouteWithRouting(routeArray))
    const mounted = app.mount('#app');
    import('../mods/mod/src/main').then(router => app.use(router.default, {root:mounted.$root}))
}

async function createRouterArray() {
    let mainRoutes = [...routes];
    await import('../mods/mod/src/main').then(router => mainRoutes = router.default.routing(mainRoutes))
    return mainRoutes;
}

function createRouteWithRouting(routes) {
    return createRouter({
        history: createWebHistory(process.env.BASE_URL),
        routes
    })
}

main();