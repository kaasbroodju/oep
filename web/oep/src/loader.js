import * as compilerino from '@vuedx/compiler-sfc'

function parseComponent(component) {
    return compilerino.parse(component)
}

export default parseComponent