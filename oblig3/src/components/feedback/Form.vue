<template>
  <div class="container">
    <h1>Contactform</h1>
    <form class="form-container" @submit.prevent="onSubmit">
      <FormItem label="Name" type="text" v-model="form.name" />
      <FormItem label="E-mail" type="text" v-model="form.email" />
      <FormItem label="Message" type="text" v-model="form.message" />
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import FormItem from "@/components/feedback/FormItem.vue";

export default {
  name: "Form",
  components: {
    FormItem,
  },
  data() {
    return {
      form: {
        name: "",
        email: "",
        message: "",
      },
    };
  },
  methods: {
    onSubmit() {
      const feedback = { ...this.form };
      console.log(feedback);
      this.$store.dispatch("createFeedback", feedback);
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
