<template>
  <div class="Register">
    <h1>Register page</h1>
    <p>
      Username:
      <input data-testid="username-input" type="text" v-model="username" />
    </p>
    <p>
      Email: <input data-testid="email-input" type="text" v-model="email" />
    </p>
    <p>
      Password:
      <input data-testid="password-input" type="text" v-model="password" />
    </p>
    <button v-on:click="register">Register</button>
    <label data-testid="status">{{ isRegistered }}</label>
  </div>
</template>

<script>
import { doRegister } from "@/utils/apiutils.js";

export default {
  name: "RegisterComponent",
  data() {
    return {
      username: "",
      email: "",
      password: "",
      isRegistered: "",
    };
  },
  methods: {
    register() {
      const registerRequest = {
        username: this.username,
        email: this.email,
        password: this.password,
      };
      const registerResponse = doRegister(registerRequest);
      console.log(registerResponse);
      this.isRegistered = registerResponse.registerStatus;

      //API CALLS (validating and sending data. Recieveing response)
      //....

      //Confirmation that everything worked
      if (this.isRegistered === "Success") {
        console.log("monkke");
        this.$store.dispatch("registerUser", registerRequest);
        // .catch((error) => {
        //   console.log(error);
        // });
        this.$emit("sent");
      }
    },
  },
};
</script>
