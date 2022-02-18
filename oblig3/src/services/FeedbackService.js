import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:3000", //Port must be 3000 for some reason
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  getFeedbacks() {
    return API.get("/feedbacks");
  },

  postFeedback(feedback) {
    return API.post("/feedbacks", feedback);
  },
};
