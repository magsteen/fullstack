import axios from "axios";

const CONFIG = {
  baseURL: process.env.VUE_APP_DEV_API_ENDPOINT + "/calculator",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
};

export async function doCalculation(expression: string): Promise<void> {
  return await axios.post("/calculate", expression, CONFIG);
}

export async function getCalculations(): Promise<Array<string>> {
  return await axios.get("/calculations", CONFIG);
}
