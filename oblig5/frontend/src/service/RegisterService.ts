import { UserCredentials } from "@/types/UserCredentials";
import axios from "axios";
import { string } from "yup";

const CONFIG = {
  baseURL: process.env.VUE_APP_DEV_API_ENDPOINT + "/user",
  withCredentials: false,
  headers: {
    Accept: "application/json",
    "Content-Type": "application/json",
  },
};

export async function register(
  email: string,
  password: string
): Promise<string> {
  return await axios.post("", { email, password }, CONFIG);
}
