<template>
  <div id="loginContainer">
    <div id="loginTitle">
      <label>Please login!</label>
    </div>
    <div id="username">
      <label id="usernameLabel">Username:</label>
      <input data-testid="username-input" v-model="username" />
    </div>
    <div id="password">
      <label id="passwordLabel">Password: </label>
      <input data-testid="password-input" v-model="password" />
      <button v-on:click="handleClickSignin">Sign in</button>
      <label id="loginstatusLabel">{{ loginStatus }}</label>
    </div>
    <p id="loginFailResolver">
      Not registered yet:
      <router-link to="/register">register</router-link>
    </p>
  </div>
</template>

<script>
import { doLogin } from "@/utils/apiutils.js";

export default {
  name: "LoginComponent",
  methods: {
    handleClickSignin() {
      const loginRequest = { username: this.username, password: this.password };
      console.log(loginRequest);
      const loginResponse = doLogin(loginRequest);
      console.log(loginResponse);

      this.loginStatus = loginResponse.loginStatus;

      //If login is successfull then status should be set as "Success"
      //Mocking this since were not testing "doLogin" but the submit button
      
      if (this.loginStatus === "Success") {
        this.$store.dispatch("loginUser", this.username);
        //   .catch((error) => {
        //   console.log(error);
        // });
        this.$router.push("/home");
      } else if (this.loginStatus === "Failed") {
        document.getElementById("loginFailResolver").style.visibility =
          "visible";
      }
    },
  },
  data() {
    return {
      username: "",
      password: "",
      loginStatus: "",
    };
  },
};
</script>

<style scoped>
#loginContainer {
  display: grid;
  justify-content: center;
  margin: 40px;
}

#loginTitle {
  font-size: x-large;
  font-weight: bold;
  margin-bottom: 20px;
}

#username,
#password {
  display: flex;
  flex-direction: row;
  align-items: center;
  column-gap: 20px;
}

#usernameLabel,
#passwordLabel {
  width: 100px;
}

#loginFailResolver {
  visibility: hidden;
}
</style>
