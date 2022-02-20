<template>
  <div class="container">
    <label v-if="label">{{ label }}</label>
    <input
      :value="modelValue"
      :placeholder="label"
      class="inputfield"
      @input="$emit('update:modelValue', $event.target.value)"
    />
  </div>
</template>

<script>
export default {
  name: "FormItem",
  props: {
    label: {
      type: String,
      default: "",
    },
    modelValue: {
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
  max-width: 400px;
}
.inputfield {
  height: 50px;
}
</style>
