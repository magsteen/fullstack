<template>
  <div class="view">
    <div v-for="(calculation, key) in calculations" :key="key">
      <CalculationItem :calculation="calculation" />
    </div>
  </div>
</template>

<script lang="ts">
import CalculationItem from "@/components/calculation/CalculationItem.vue";
import { getCalculations } from "@/service/CalculationService";
import { Calculation } from "@/types/Calculation";
import { defineComponent } from "@vue/runtime-core";

export default defineComponent({
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
  async mounted() {
    try {
      this.calculations = await getCalculations().then((calculations) => {
        console.log(calculations);
        return calculations;
      });
    } catch (e) {
      console.error(e);
    }
  },
});
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
