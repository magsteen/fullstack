import { createStore } from "vuex";
import FeedbackService from "../services/FeedbackService";

export default createStore({
  state: {
    user: "Monke",
    feedbacks: [],
    feedback: {},
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
  },
  actions: {
    createFeedback({ commit }, feedback) {
      FeedbackService.postFeedback(feedback)
        .then(() => {
          commit("ADD_FEEDBACK", feedback);
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
    fetchFeedback({ commit }, id) {
      FeedbackService.getFeedback(id)
        .then((r) => {
          commit("SET_FEEDBACK", r.data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  modules: {},
  getters: {
    feedback: (state) => {
      return state.feedback;
    },
  },
});
