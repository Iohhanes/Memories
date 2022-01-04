import axios from "axios";

const memAxios = axios.create({
  baseURL: "/",
  responseType: "json",
  headers: { "Access-Control-Allow-Origin": "*" }
});

export default memAxios;
