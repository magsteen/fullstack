import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8888", //Port must be 3000 for some reason
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  postFeedback(feedback) {
    return API.post("/feedbacks", feedback);
  },
  getFeedbacks() {
    return API.get("/feedbacks");
  },
  getFeedback(id) {
    return API.get("/feedbacks/" + id);
  },
};

export function updateStatus(context) {
  context.status = "isoading";
  setTimeout(() => {}, 1500);
}
