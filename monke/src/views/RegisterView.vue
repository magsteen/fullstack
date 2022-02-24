<template>
  <Register @sent="goToHome"></Register>
</template>

<script>
import Register from "@/components/Register.vue";

export default {
  components: {
    Register,
  },
  methods: {
    goToHome() {
      this.$router.push("/home");
    },
  },
};
</script>
