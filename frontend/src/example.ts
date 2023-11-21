import { LitElement, html, customElement, property } from 'lit-element'

interface Column {
  id: string
}

@customElement('example-component')
export class ExampleComponent extends LitElement {
  @property({ type: Object }) columns!: Column[]

  render() {
    return html`<hello-world></hello-world>`
  }
}
