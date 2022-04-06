import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import CalculatorView from "@/views/CalculatorView.vue";
import CalculationsView from "@/views/CalculationsView.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "CalculatorView",
    component: CalculatorView,
  },
  {
    path: "/calculations",
    name: "CalculationsView",
    component: CalculationsView,
  },
  {
    path: "/register",
    name: "RegisterView",
    component: () =>
      import(/* webpackChunkName: "Register" */ "@/views/RegisterView.vue"),
  },
  {
    path: "/login",
    name: "LoginView",
    component: () =>
      import(/* webpackChunkName: "Login" */ "@/views/LoginView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
