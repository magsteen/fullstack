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
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
