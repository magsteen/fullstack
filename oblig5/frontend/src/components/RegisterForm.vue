<template>
  <div class="Register">
    <h1>Register page</h1>
    <form class="box" @submit.prevent="onSubmit">
      <BaseInput
        label="Email"
        v-model="email"
        type="email"
        data-testid="email-input"
      />
      <BaseInput
        label="Password"
        v-model="password"
        type="password"
        data-testid="password-input"
        :error="errors.password"
      />
      <button type="submit">Register</button>
    </form>

    <label data-testid="status">{{ isRegistered }}</label>
  </div>
</template>

<script lang="ts">
import { register } from "@/service/RegisterService";
import router from "@/router";
import { object, string } from "yup";
import { useField, useForm } from "vee-validate";
import { defineComponent } from "@vue/runtime-core";

export default defineComponent({
  name: "RegisterForm",
  data() {
    return {
      isRegistered: "",
    };
  },
  methods: {
    async onSubmit() {
      await this.submit().then(async (userCredentials) => {
        if (userCredentials !== undefined) {
          if (
            userCredentials.email !== undefined &&
            userCredentials.password !== undefined
          ) {
            try {
              const registerResponse = await register(
                userCredentials.email,
                userCredentials.password
              );
              this.isRegistered = registerResponse;

              if (this.isRegistered === "Success") {
                router.push("calculator");
              }
            } catch (e) {
              console.error(e);
            }
          }
        }
      });
    },
  },
  setup() {
    const validationSchema = object({
      email: string()
        .email("ugyldig epost adresse")
        .required("epost adresse er påkrevd"),
      password: string().required("passord er påkrevd"),
    });

    const { handleSubmit, errors } = useForm({
      validationSchema,
      initialValues: {
        email: "",
        password: "",
      },
    });

    const { value: email } = useField("email");
    const { value: password } = useField("password");

    const submit = handleSubmit((values) => {
      return values;
    });

    return {
      validationSchema,
      errors,
      email,
      password,
      submit,
    };
  },
});
</script>

<style scoped>
.box {
  max-width: 200px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.submit-button {
  background-color: rgb(70, 70, 255);
  border: none;
  border-radius: 20px;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
}

.submit-button:hover {
  background-color: #5656ff;
  cursor: pointer;
}

:deep(.input-interactable) {
  margin: 10px;
  padding: 10px 5px;
}

:deep(label) {
  margin: 10px 0px 0px 0px;
  align-self: flex-start;
  text-align: left;
}

@media screen and (min-width: 600px) {
  .box {
    width: 400px;
    max-width: 400px;
  }

  :deep(.input-interactable) {
    width: 400px;
  }
}
</style>
