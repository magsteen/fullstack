<template>
  <h1>WELCOME HOME {{ user }}</h1>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      user: this.$store.state.username,
    };
  },
};
</script>
