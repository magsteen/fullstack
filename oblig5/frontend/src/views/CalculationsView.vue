<template>
  <div class="view">
    <div v-for="(calculation, key) in calculations" :key="key">
      <CalculationItem :calculation="calculation" />
    </div>
  </div>
</template>

<script lang="ts">
import CalculationItem from "@/components/calculation/CalculationItem.vue";
import { Calculation } from "@/types/Calculation";

export default {
  name: "CalculatorView",
  components: {
    CalculationItem,
  },
  data: (): {
    calculations: Array<Calculation>;
  } => {
    return {
      calculations: [],
    };
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
