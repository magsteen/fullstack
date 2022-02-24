<template>
  <div class="container">
    <h1>Contactform</h1>
    <form class="form-container" @submit.prevent="onSubmit">
      <FormItem
        label="Name*"
        placeholder="E.g Karen..."
        v-model="name"
        :error="errors.name"
      />
      <FormItem
        label="E-mail*"
        placeholder="E.g entitled@humen.com..."
        v-model="email"
        :error="errors.email"
      />
      <FormItem
        label="Message*"
        placeholder="E.g Where is the manager??"
        v-model="message"
        :error="errors.message"
      />
      <div>
        <button type="submit">Submit</button>
        <p>{{ status }}</p>
      </div>
    </form>
  </div>
</template>

<script>
import FormItem from "@/components/feedback/FormItem.vue";
import { useField, useForm } from "vee-validate";
import { object, string } from "yup";
import { useStore } from "vuex";

export default {
  name: "Form",
  components: {
    FormItem,
  },
  computed: {
    status() {
      return this.$store.state.status;
    },
  },
  methods: {
    async onSubmit() {
      try {
        await this.submit().then((feedback) => {
          if (feedback === undefined) {
            return;
          }
          this.$store.dispatch("updateStatus", "Loading...");
          console.log(this.status);
          setTimeout(() => {
            const status = "Sent!";
            this.$store.dispatch("updateStatus", status);
            this.$store.dispatch("createFeedback", {
              ...feedback,
              status: status,
            });
            setTimeout(() => {
              this.$store.dispatch("updateStatus", "");
            }, 1500);
          }, 1500);
        });
      } catch (error) {
        console.error(error);
      }
    },
  },
  setup() {
    const store = useStore();
    const validationSchema = object({
      name: string().required("name is required").min(2, "to short name"),
      email: string().required("email is required").email("invalid email"),
      message: string().required("message is required"),
    });

    const { handleSubmit, errors } = useForm({
      validationSchema,
      initialValues: {
        name:
          store.state.unfinishedFeedback.username === ""
            ? store.state.username
            : store.state.unfinishedFeedback.username,
        email:
          store.state.unfinishedFeedback.email === ""
            ? store.state.email
            : store.state.unfinishedFeedback.email,
        message: store.state.unfinishedFeedback.message,
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
