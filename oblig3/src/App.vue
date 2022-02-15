<template>
  <div id="nav">
    <router-link to="/">Calculator</router-link> |
    <router-link to="/about">About</router-link>
  </div>
  <router-view />
</template>

<style>
body {
  margin: 0%;
  max-height: 100vh;
}
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  display: flex;
  justify-content: center;
  height: 100vh;
  max-height: 100vh;
  width: 100vw;
  max-width: 100vw;
}

#nav {
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
