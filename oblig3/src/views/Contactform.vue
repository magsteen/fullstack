<template>
  <div class="contactformPage">
    <h1>Here is out contactform:</h1>
    <Contactform />
  </div>
</template>

<script>
import { Contactform } from "@/components/Contactform.vue";

export default {
  name: "Contactform",
  component: {
    Contactform,
  },
};
</script>

<style scoped>
.contactFormPage {
  
}
</style>
