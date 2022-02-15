<template>
  <div class="view">
    <Contactform class="view"/>
    <Feedback class="view"/>
  </div>
</template>

<script>
import { Contactform } from "@/components/Contactform.vue";
import { Feedback } from "@/components/Feedback.vue";

export default {
  name: "ContactformView",
  component: {
    Contactform,
    Feedback,
  },
};
</script>

<style scoped>
.view {
  display: flex;
  flex-direction: row;
  align-items: center;
  height: calc(100vh - var(--navHeight));
  width: 100vw;
}
</style>
