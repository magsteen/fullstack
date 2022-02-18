<template>
  <div class="box">
    <div class="header">
      <div id="name">{{ item.name }}</div>
      <div id="mail">- {{ item.email }}</div>
    </div>
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
* {
  text-align: left;
  font-size: 0.75rem;
}
.box {
  font-family: 'Courier New', Courier, monospace;
  height: 120px;
  width: 300px;
  border: 1px solid gray;
  display: flex;
  flex-direction: column;
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
