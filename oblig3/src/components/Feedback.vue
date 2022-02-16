<template>
  <div class="container">
    <h1>Feedback</h1>
    <FeedbackItem :item="item" :key="item.key" v-for="item in Feedbacks" />
  </div>
</template>

<script>
import FeedbackItem from "@/components/FeedbackItem.vue";

export default {
  name: "Feedback",
  components: {
    FeedbackItem,
  },
  data() {
    return {
      Feedbacks: [
        {
          key: 0,
          name: "first",
          email: "mailing",
          message: "here is a message",
        },
      ],
    };
  },
};
</script>

<style scoped>
.container {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
