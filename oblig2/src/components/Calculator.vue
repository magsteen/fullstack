<template>
  <div class="calcContainer">
    <div class="screenContainer">
      <div class="screen">
        <div class="logsAndInput">
          <div v-for="log in logs" :key="log">
            <p class="formula">{{ log.formula }}</p>
            <p class="result">{{ "= " + log.result }}</p>
            <hr />
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
/*
* Prefixed by https://autoprefixer.github.io
* PostCSS: v8.3.6,
* Autoprefixer: v10.3.1
* Browsers: last 4 version
*/

.calcContainer {
  display: -ms-grid;
  display: grid;
  -ms-grid-rows: minmax(0, 1000fr) 1fr;
  grid-template-rows: minmax(0, 1000fr) 1fr;
  grid-template-areas:
    "screenContainer"
    "buttonContainer";
  -webkit-box-align: stretch;
  -ms-flex-align: stretch;
  align-items: stretch;
  -ms-flex-line-pack: stretch;
  align-content: stretch;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  width: 100%;
  max-width: 500px;
  background: grey;
  border: 10px solid black;
  border-radius: 30px;
  max-height: 100%;
}

.screenContainer {
  -ms-grid-row: 1;
  -ms-grid-column: 1;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  grid-area: screenContainer;
}

.screen {
  /*Fill possible space after buttons are placed */
  -webkit-box-flex: 1;
  -ms-flex-positive: 1;
  flex-grow: 1;
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  border: 2px solid black;
  border-radius: 30px;
  margin: 20px;
  background: darkgreen;
  color: white;
}

.logsAndInput {
  -webkit-box-flex: 1;
  -ms-flex-positive: 1;
  flex-grow: 1;
  -webkit-box-sizing: border-box;
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
  -ms-grid-row: 2;
  -ms-grid-column: 1;
  display: -ms-grid;
  display: grid;
  grid-area: buttonContainer;
  grid-template-columns: repeat(auto-fill, 60px);
  background: lightslategray;
  border-radius: 20px;
  width: 100%;
}
</style>
