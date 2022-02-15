<template>
  <div class="container">
    <label v-if="label">{{ label }}</label>
    <input
      :value="value"
      :placeholder="label"
      class="inputfield"
      @input="$emit('update:value', $event.target.value)"
    />
  </div>
</template>

<script>
export default {
  name: "BaseInput",
  props: {
    label: {
      type: String,
      default: "",
    },
    value: {
      type: [String, Number],
      default: "",
    },
  },
};
</script>

<style scoped>
.container {
  width: 100%;
  height: 100%;
  padding: 10px 0px;
  max-width: 400px;
}
.inputfield {
  height: 50px;
}
</style>
