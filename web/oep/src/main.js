import { createApp } from 'vue'
import App from './App.vue'
import {createRouter, createWebHistory} from "vue-router";
import routes from './router/index'

async function main() {
    const app = createApp(App);
    const mods = [...require.context('/mods/.', true, /main\.js$/).keys()].map(s => s.slice(2, s.length - 3));

    const routeArray = await createRouterArray(mods)
    app.use(createRouteWithRouting(routeArray))
    const mounted = app.mount('#app');

    mods.forEach(mod => {
        import('/mods/' + mod).then(router => app.use(router.default, {root:mounted.$root}))
    })
}

async function createRouterArray(mods) {
    let mainRoutes = [...routes];
    for (let mod of mods) {
        await import('/mods/' + mod).then(router => mainRoutes = router.default.routing(mainRoutes))
    }
    // await mods.forEach(mod => import('/mods/' + mod).then(router => mainRoutes = router.default.routing(mainRoutes)))
    return mainRoutes;
}

function createRouteWithRouting(routes) {
    return createRouter({
        history: createWebHistory(process.env.BASE_URL),
        routes
    })
}

main();