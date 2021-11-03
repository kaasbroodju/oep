import {modroutes} from "./modRoute.js";

export function importmod(main) {
    modroutes.forEach(
        (route) => {main.$router.addRoute(route); main.$router.push(route)}
    )
    main.links.push({to:'/mod', text:'mod'})
}

export default { importmod }