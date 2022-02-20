<template>
  <div class="view">
    <Form class="components" />
    <Feedback class="components" />
  </div>
</template>

<script>
import Form from "@/components//feedback/Form.vue";
import Feedback from "@/components/feedback/Feedback.vue";

export default {
  name: "FeedbackFormView",
  components: {
    Form,
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
