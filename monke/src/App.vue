<template>
  <div id="nav">
    <router-link to="/">Calculator</router-link> |
    <router-link to="/contactform">Contactform</router-link> |
    <router-link to="/login">Login</router-link> |
    <router-link to="/register">Register</router-link> |
    <router-link to="/home">Home</router-link>
  </div>
  <router-view />
</template>

<style>
:root {
  --navHeight: 80px;
}

body {
  margin: 0%;
  /**max-height: 100vh;*/
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  flex-direction: column;
  align-items: center;
}

#nav {
  height: calc(var(--navHeight) - 60px);
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
