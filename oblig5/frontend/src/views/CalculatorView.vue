<template>
  <div class="view">
    <Calculator />
  </div>
</template>

<script lang="ts">
import Calculator from "@/components/calculator/CalculatorComponent.vue";

export default {
  name: "CalculatorView",
  components: {
    Calculator,
  },
};
</script>

<style scoped>
.view {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: calc(100vh - var(--navHeight));
  width: 100vw;
}
</style>
