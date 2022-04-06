import { createStore } from "vuex";
import FeedbackService from "../service/FeedbackService";
import { authentication } from "./modules/Authentication";

let store = createStore({
  state: {
    username: "",
    email: "",
    feedbacks: [],
    status: "",
    unfinishedFeedback: {
      username: "",
      email: "",
      message: "",
      status: "",
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
    SET_STATUS(state, status) {
      state.status = status;
    },
    SET_USERNAME(state, username) {
      state.username = username;
    },
    SET_EMAIL(state, email) {
      state.email = email;
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
    updateStatus({ commit }, status) {
      commit("SET_STATUS", status);
    },
    registerUser({ commit }, registerFields) {
      console.log(registerFields);
      commit("SET_USERNAME", registerFields.username);
      commit("SET_EMAIL", registerFields.email);
    },
    loginUser({ commit }, username) {
      console.log(username);
      commit("SET_USERNAME", username);
    },
  },
  modules: {
    authentication: authentication,
  },
});

export default store;
