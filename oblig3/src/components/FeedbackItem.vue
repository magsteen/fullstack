<template>
  <div class="box">
    <div class="header">{{ item.name }} - {{ item.email }}</div>
    <div class="break"/>
    <div class="content">{{ item.message }}</div>
  </div>
</template>

<script>
export default {
  name: "FeedbackItem",
  props: {
    item: Object,
  },
  // mounted() {
  //   console.log(this.item); // {x:1}
  // },
};
</script>

<style scoped>
.box {
  font-family: 'Courier New', Courier, monospace;
  height: 120px;
  width: 300px;
  border: 1px solid gray;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}
.break {
  border-top: 1px solid grey;
  width: calc(300px - 40px);
  align-self: center;
}
.header {
  margin: 20px 20px 5px 20px;
}
.content {
    margin: 10px 20px 10px 20px;
}
</style>
