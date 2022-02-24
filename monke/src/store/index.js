import { createStore } from "vuex";
import FeedbackService from "../services/FeedbackService";

export default () =>
  createStore({
    state: {
      username: "",
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
      SET_USERNAME(state, username) {
        console.log(username);
        state.username = username;
      },
    },
    actions: {
      createFeedback({ commit }, feedback) {
        FeedbackService.postFeedback(feedback)
          .then(() => {
            commit("ADD_FEEDBACK", feedback);
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
      registerUser({ commit }, username) {
        console.log(username);
        commit("SET_USERNAME", username);
      },
      loginUser({ commit }, username) {
        console.log(username);
        commit("SET_USERNAME", username);
      },
    },
    modules: {},
  });
