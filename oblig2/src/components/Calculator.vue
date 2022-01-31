<template>
  <div class="calcContainer">
    <div class="screen"></div>
    <div class="buttonContainer">
      <CalculatorButton v-for="button in buttons" :key="button.name" :button="button"/>
    </div>
  </div>
</template>

<script>
import CalculatorButton from '@/components/CalculatorButton.vue';
export default {
  components: { CalculatorButton },
  name: "Calculator",
  props: {
    screen: {},
  },
  data() {
    return {
      buttons: [
        { name: "C" },
        { name: "ANS" },
        { name: "DEL" },
        { name: "+" },
        { name: "-" },
        { name: "*" },
        { name: "/" },
        { name: "=", special: true },
        { name: "1" },
        { name: "2" },
        { name: "3" },
        { name: "4" },
        { name: "5" },
        { name: "6" },
        { name: "7" },
        { name: "8" },
        { name: "9" },
        { name: "0" },
        { name: "." },
      ],
    };
  },
};
</script>

<style scoped>
.calcContainer {
  height: 100%;
  max-width: 600px;
  background: grey;
}

.screen {
  /*Fill possible space after buttons are placed */
}
.buttonContainer {
  display: grid;
  grid-template-columns: repeat(auto-fill, 60px);
  background: lightslategray;
  border-radius: 20px;
}
</style>
