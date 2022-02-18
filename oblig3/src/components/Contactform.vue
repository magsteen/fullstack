<template>
  <div class="container">
    <h1>Contactform</h1>
    <form class="form-container" @submit.prevent="onSubmit">
      <ContactformItem label="Name" type="text" v-model="feedback.name" />
      <ContactformItem label="E-mail" type="text" v-model="feedback.email" />
      <ContactformItem label="Message" type="text" v-model="feedback.message" />
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import ContactformItem from "@/components/ContactformItem.vue";
import FeedbackService from "@/services/FeedbackService.js";

export default {
  name: "Contactform",
  components: {
    ContactformItem,
  },
  data() {
    return {
      feedback: {
        name: "",
        email: "",
        message: "",
      },
    };
  },
  methods: {
    onSubmit() {
      const feedback = { ...this.feedback };
      FeedbackService.postFeedback(feedback).catch((error) => {
        console.log(error);
      });
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

.form-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}

button {
  align-self: flex-end;
}

.form-container * {
  margin: 10px;
}

.input {
  padding: 0px 10px;
}

.test {
  display: flex;
  flex-direction: row;
  align-items: center;
}
</style>
