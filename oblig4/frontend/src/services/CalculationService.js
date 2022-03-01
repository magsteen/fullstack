import axios from "axios";

const API = axios.create({
  baseURL: "http://localhost:8888",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
});

export default {
  doCalculation(expression) {
    return API.post("/calculation", { expression: expression }).then(
      (response) => {
        console.log(response);
        return response.data.result;
      }
    );
  },
};
