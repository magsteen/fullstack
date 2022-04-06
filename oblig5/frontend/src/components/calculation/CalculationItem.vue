<template>
  <div class="box">
    <div class="header">
      <div id="expression">{{ calculation.expression }}</div>
    </div>
    <div class="break" />
    <div class="content">{{ calculation.result }}</div>
  </div>
</template>

<script lang="ts">
import { Calculation } from "@/types/Calculation";
import { defineComponent } from "vue";

export default defineComponent({
  name: "CalclutaionItem",
  props: {
    calculation: {
      type: Calculation,
    },
  },
});
</script>

<style scoped>
* {
  text-align: left;
  font-size: 0.75rem;
}
.box {
  font-family: "Courier New", Courier, monospace;
  height: 120px;
  width: 300px;
  border: 1px solid gray;
  display: flex;
  flex-direction: column;
}
.break {
  border-top: 1px solid grey;
  width: calc(300px - 40px);
  align-self: center;
}
.header {
  margin: 20px 20px 5px 20px;
}
.content {
  margin: 10px 20px 10px 20px;
}
</style>
