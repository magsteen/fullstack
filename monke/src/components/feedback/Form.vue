<template>
  <div class="container">
    <h1>Contactform</h1>
    <form class="form-container" @submit.prevent="onSubmit">
      <FormItem label="Name" v-model="name" :error="errors.name" />
      <FormItem label="E-mail" v-model="email" :error="errors.email" />
      <FormItem label="Message" v-model="message" :error="errors.message" />
      <button type="submit">Submit</button>
    </form>
  </div>
</template>

<script>
import FormItem from "@/components/feedback/FormItem.vue";
import { useField, useForm } from "vee-validate";
import { object, string } from "yup";

export default {
  name: "Form",
  components: {
    FormItem,
  },
  methods: {
    async onSubmit() {
      try {
        await this.submit().then((feedback) => {
          if (feedback === undefined) {
            return;
          }
          console.log(feedback);
          this.$store.dispatch("createFeedback", feedback);
          alert("Feedback submitted");
        });
      } catch (error) {
        console.error(error);
      }
    },
  },
  setup() {
    const validationSchema = object({
      name: string().required("name is required").min(2, "to short name"),
      email: string().required("email is required").email("invalid email"),
      message: string().required("message is required"),
    });

    const { handleSubmit, errors } = useForm({
      validationSchema,
      initialValues: {
        name: "",
        email: "",
        message: "",
      },
    });

    const { value: name } = useField("name");
    const { value: email } = useField("email");
    const { value: message } = useField("message");

    const submit = handleSubmit((values) => {
      console.log(values);
      return values;
    });

    return {
      validationSchema,
      errors,
      submit,
      name,
      email,
      message,
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
