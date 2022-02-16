<template>
  <div class="container">
    <h1>Contactform</h1>
    <form class="form-container">
      <ContactformItem label="Name" type="text" v-model="feedback.name" />
      <ContactformItem label="E-mail" type="text" v-model="feedback.email" />
      <ContactformItem label="Message" type="text" v-model="feedback.message" />
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import ContactformItem from "@/components/ContactformItem.vue";

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
  display: grid;
  width: 100%;
  justify-content: center;
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
