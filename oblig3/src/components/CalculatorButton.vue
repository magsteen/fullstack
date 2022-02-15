<template>
  <button v-bind:class="{ special: button.special }">
    {{ button.value }}
  </button>
</template>

<script>
export default {
  name: "CalculatorButton",
  props: {
    button: {
      type: Object,
      required: true,
    },
  },
};
</script>

<style scoped>
button {
  height: 50px;
  width: 50px;
  background-color: lightgray;
  border-radius: 30%;
  margin: 5px;
}
.special {
  background: orange;
}
</style>
