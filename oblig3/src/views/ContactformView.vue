<template>
  <div class="view">
    <Contactform class="components" />
    <Feedback class="components" />
  </div>
</template>

<script>
import Contactform from "@/components/Contactform.vue";
import Feedback from "@/components/Feedback.vue";

export default {
  name: "ContactformView",
  components: {
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
.components {
  height: calc(100vh - var(--navHeight));
  width: 50vw;
}
</style>
