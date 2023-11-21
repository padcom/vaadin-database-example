import { defineCustomElement } from 'vue'
import HelloWorld from './HelloWorld.ce.vue'

// @ts-ignore xxx
globalThis.__VUE_OPTIONS_API__ = true
// @ts-ignore xxx
globalThis.__VUE_PROD_DEVTOOLS__ = true

customElements.define('hello-world', defineCustomElement(HelloWorld))
