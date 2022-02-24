<template>
  <div class="container">
    <h1>Feedback</h1>
    <FeedbackItem :item="item" :key="item.key" v-for="item in feedbacks" />
  </div>
</template>

<script>
import FeedbackItem from "@/components/feedback/FeedbackItem.vue";

export default {
  name: "Feedback",
  components: {
    FeedbackItem,
  },
  created() {
    this.$store.dispatch("fetchFeedbacks");
  },
  computed: {
    feedbacks() {
      return this.$store.state.feedbacks;
    },
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
.container *:not(h1) {
  margin: 10px;
}
</style>
