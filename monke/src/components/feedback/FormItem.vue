<template>
  <div class="container">
    <label :for="uuid" v-if="label">{{ label }}</label>
    <input
      v-bind="$attrs"
      :value="modelValue"
      :placeholder="placeholder"
      class="inputfield"
      @input="$emit('update:modelValue', $event.target.value)"
      :id="uuid"
    />

    <p v-if="error" class="errorMessage" :id="`${uuid}-error`">{{ error }}</p>
  </div>
</template>

<script>
import NewUID from "@/utils/uid.js";

export default {
  name: "FormItem",
  props: {
    placeholder: {
      type: String,
      default: "",
    },
    label: {
      type: String,
      default: "",
    },
    modelValue: {
      type: [String, Number],
      default: "",
    },
    modelType: {
      type: String,
      default: "",
    },
    error: {
      type: String,
      default: "",
    },
  },
  setup() {
    const uuid = NewUID().getID();
    return {
      uuid,
    };
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

.errorMessage {
  color: red;
  align-self: flex-end;
}
</style>
