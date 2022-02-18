<template>
  <div class="container">
    <h1>Feedback</h1>
    <FeedbackItem :item="item" :key="item.key" v-for="item in Feedbacks" />
  </div>
</template>

<script>
import FeedbackItem from "@/components/FeedbackItem.vue";
import FeedbackService from "@/services/FeedbackService.js";

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
          name: "Navn navnesen",
          email: "navn@navnesen.com",
          message:
            "Create calcumulator! Gots to say. Oooga booga spaaaammememer",
        },
        {
          key: 1,
          name: "Navn navnesen",
          email: "navn@navnesen.com",
          message:
            "Create calcumulator! Gots to say. Oooga booga spaaaammememer",
        },
      ],
    };
  },
  created() {
    FeedbackService.getFeedbacks()
      .then((r) => {
        this.Feedbacks = r.data;
      })
      .catch((err) => {
        console.log(err);
      });
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
