import { configureStore } from "@reduxjs/toolkit";

export const createStore = () =>
  configureStore({
    reducer: {},
    middleware: getDefaultMiddleware => getDefaultMiddleware()
  });

export const store = createStore();
