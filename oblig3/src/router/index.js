import { createRouter, createWebHistory } from "vue-router";
import CalculatorView from "@/views/CalculatorView.vue";
import ContactformView from "@/views/ContactformView.vue";

const routes = [
  {
    path: "/",
    name: "CalculatorView",
    component: CalculatorView,
  },
  {
    path: "/contactform",
    name: "ContactformView",
    component: ContactformView,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
