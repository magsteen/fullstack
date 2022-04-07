<template>
  <Register @sent="goToHome"></Register>
</template>

<script lang="ts">
import Register from "@/components/RegisterForm.vue";
import router from "@/router";

export default {
  components: {
    Register,
  },
  methods: {
    goToHome() {
      router.push("/home");
    },
  },
};
</script>
