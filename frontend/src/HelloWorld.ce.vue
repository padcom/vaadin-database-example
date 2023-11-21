<template>
  <table border="1">
    <thead>
      <tr>
        <th v-for="column in columns">{{ column.id }}</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="row in data" :key="row.id">
        <td v-for="column in columns" :key="column.id">
          {{ row[column.id] }}
        </td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import { ref, watchEffect } from 'vue'

const props = defineProps({
  columns: { type: Array, default: () => [] },
  data: { type: Array, default: () => [] },
})

watchEffect(() => {
  console.log('props.columns', props.columns)
})

const message = ref('Hello, world! from Vue.js using webpack!')
// const columns1 = ref([
//   { id: 'id' },
//   { id: 'title' },
//   { id: 'completed' },
//   { id: 'userId' },
// ])
</script>

<style lang="css">
:host {
  container-type: inline-size;
}

table {
  border-collapse: collapse;
}

th, td {
  padding-inline: 0.5rem;
  padding-block: 0.25rem;
}
</style>
