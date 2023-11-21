import { LitElement, html, customElement } from 'lit-element'

@customElement('example-component')
export class ExampleComponent extends LitElement {
  render() {
    return html`<hello-world></hello-world>`
  }
}

// @ts-ignore xxx
globalThis.__VUE_OPTIONS_API__ = true
// @ts-ignore xxx
globalThis.__VUE_PROD_DEVTOOLS__ = true

import { defineCustomElement } from 'vue'
import HelloWorld from './HelloWorld.vue'

customElements.define('hello-world', defineCustomElement(HelloWorld))
