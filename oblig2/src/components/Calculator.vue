<template>
  <div class="calcContainer">
    <div class="screenContainer">
      <div class="screen">
        <div class="logsAndInput">
          <div v-for="log in logs" :key="log">
            <p class="formula">{{ log.formula }}</p>
            <p class="result">{{ "= " + log.result }}</p>
            <hr>
          </div>
          <p class="inputField">{{ input }}</p>
        </div>
      </div>
    </div>
    <div class="buttonContainer">
      <CalculatorButton
        v-for="button in buttons"
        :key="button.value"
        :button="button"
        @click="handleClick(button)"
      />
    </div>
  </div>
</template>

<script>
const Buttons = {
  C: 1,
  ANS: 2,
  DEL: 3,
  OPERATE: 4,
  CALC: 5,
};

import CalculatorButton from "@/components/CalculatorButton.vue";
export default {
  name: "Calculator",
  components: { CalculatorButton },
  data() {
    return {
      logs: [],
      buttons: [
        { value: "C", type: Buttons.C },
        { value: "ANS", type: Buttons.ANS },
        { value: "DEL", type: Buttons.DEL },
        { value: " + ", type: Buttons.OPERATE },
        { value: " - ", type: Buttons.OPERATE },
        { value: " * ", type: Buttons.OPERATE },
        { value: " / ", type: Buttons.OPERATE },
        { value: " =", type: Buttons.CALC, special: true },
        { value: "1", type: Buttons.OPERATE },
        { value: "2", type: Buttons.OPERATE },
        { value: "3", type: Buttons.OPERATE },
        { value: "4", type: Buttons.OPERATE },
        { value: "5", type: Buttons.OPERATE },
        { value: "6", type: Buttons.OPERATE },
        { value: "7", type: Buttons.OPERATE },
        { value: "8", type: Buttons.OPERATE },
        { value: "9", type: Buttons.OPERATE },
        { value: "0", type: Buttons.OPERATE },
        { value: ".", type: Buttons.OPERATE },
      ],
      input: "",
    };
  },
  methods: {
    operate(element) {
      this.input += element;
    },

    handleClick(button) {
      switch (button.type) {
        case Buttons.C:
          this.input = "";
          this.logs = [];
          break;

        case Buttons.ANS:
          if (!isNaN(this.logs[this.logs.length - 1].result))
            this.input += this.logs[this.logs.length - 1].result;
          break;

        case Buttons.DEL:
          if (this.input.slice(-1) === " ")
            this.input = this.input.slice(0, -3);
          else this.input = this.input.slice(0, -1);
          break;

        case Buttons.OPERATE:
          this.input += button.value;
          break;

        case Buttons.CALC:
          try {
            this.logs.push({ formula: this.input, result: eval(this.input) });
          } catch (error) {
            this.logs.push({
              formula: this.input,
              result: "Faulty expression",
            });
          }
          if (this.logs[this.logs.length - 1].result === Infinity)
            this.logs[this.logs.length - 1].result = "Can't divide by zero";
          this.input = "";
          break;
      }
    },
  },
};
</script>

<style scoped>
.calcContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  box-sizing: border-box;
  width: 100%;
  max-width: 500px;
  background: grey;
  border: 10px solid black;
  border-radius: 30px;
}

.screenContainer {
  display: flex;
  width: 100%;
  height: 100%;
  max-height: 100%;
}

.screen {
  /*Fill possible space after buttons are placed */
  flex-grow: 1;
  display: flex;
  box-sizing: border-box;
  border: 2px solid black;
  border-radius: 30px;
  margin: 20px;
  background: darkgreen;
  color: white;
}

.logsAndInput {
  flex-grow: 1;
  box-sizing: border-box;
  margin: 20px;
  overflow-y: scroll;
}

hr {
  color: darkslategrey;
}

p {
  margin: 15px;
  text-align: left;
  font-size: 150%;
}

.result {
  text-align: right;
}

.buttonContainer {
  display: grid;
  grid-template-columns: repeat(auto-fill, 60px);
  background: lightslategray;
  border-radius: 20px;
  width: 100%;
}
</style>
