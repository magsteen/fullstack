import { createRouter, createWebHistory } from "vue-router";
import CalculatorView from "@/views/CalculatorView.vue";
import FeedbackFormView from "@/views/FeedbackFormView.vue";

const routes = [
  {
    path: "/",
    name: "CalculatorView",
    component: CalculatorView,
  },
  {
    path: "/contactform",
    name: "FeedbackFormView",
    component: FeedbackFormView,
  },
  {
    path: "/register",
    name: "RegisterView",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/RegisterView.vue"),
  },
  {
    path: "/login",
    name: "LoginView",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/LoginView.vue"),
  },
  {
    path: "/home",
    name: "HomeView",
    component: () =>
      import(/* webpackChunkName: "about" */ "@/views/HomeView.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
