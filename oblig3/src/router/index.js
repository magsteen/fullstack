import { createRouter, createWebHistory } from "vue-router";
import Calculator from "@/components/Calculator.vue";
import Contactform from "@/components/Contactform.vue";

const routes = [
  {
    path: "/",
    name: "Calculator",
    component: Calculator,
  },
  {
    path: "/contactform",
    name: "Contactform",
    component: Contactform,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
