<template>
  <div class="box">
    <LoginForm />
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";
import LoginForm from "../components/LoginForm.vue";

export default defineComponent({
  name: "LoginView",
  components: {
    LoginForm,
  },
});
</script>

<style scoped>
.box {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
