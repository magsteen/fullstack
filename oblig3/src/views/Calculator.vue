<template>
  <div class="pageStyle">
    <Calculator />
  </div>
</template>

<script>
import Calculator from "@/components/Calculator.vue";

export default {
  name: "Calculator",
  components: {
    Calculator,
  },
};
</script>

<style>
.pageStyle {
  display: flex;
  width: 100vw;
}
</style>
