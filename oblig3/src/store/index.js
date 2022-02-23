import { createStore } from "vuex";
import FeedbackService from "../services/FeedbackService";

export default createStore({
  state: {
    user: "Monke",
    feedbacks: [],
    lastFeedback: {
      name: "state",
      email: "state",
      message: "state",
    },
  },
  mutations: {
    SET_LOADING(state, isloading) {
      state.isloading = isloading;
    },
    ADD_FEEDBACK(state, feedback) {
      state.feedbacks.push(feedback);
    },
    SET_FEEDBACKS(state, feedbacks) {
      state.feedbacks = feedbacks;
    },
    SET_LAST_FEEDBACK(state, feedback) {
      state.lastFeedback = feedback;
    },
  },
  actions: {
    createFeedback({ commit }, feedback) {
      FeedbackService.postFeedback(feedback)
        .then(() => {
          commit("ADD_FEEDBACK", feedback);
          feedback.message = "";
          commit("SET_LAST_FEEDBACK", feedback);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    fetchFeedbacks({ commit }) {
      FeedbackService.getFeedbacks()
        .then((r) => {
          commit("SET_FEEDBACKS", r.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
});
