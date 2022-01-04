import { configureStore } from "@reduxjs/toolkit";
import postsReducer from "./posts/posts.slice";

export const createStore = () =>
  configureStore({
    reducer: { posts: postsReducer },
    middleware: getDefaultMiddleware => getDefaultMiddleware()
  });

export const store = createStore();
