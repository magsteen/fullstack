<template>
  <div class="container">
    <h1>Contactform</h1>
    <form class="form-container">
      <BaseInput label="Name" type="text" />
      <BaseInput label="E-mail" type="text" />
      <BaseInput label="Message" type="text" />
    </form>
  </div>
</template>

<script>
import BaseInput from "@/components/BaseInput.vue";

export default {
  name: "Contactform",
  components: {
    BaseInput,
  },
  data() {
    return;
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
  display: grid;
  width: 100%;
  justify-content: center;
}

.test {
  display: flex;
  flex-direction: row;
  align-items: center;
}
</style>
