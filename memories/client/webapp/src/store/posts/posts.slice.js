import { createAsyncThunk, createSlice, isAnyOf } from "@reduxjs/toolkit";
import memAxios from "../../http/mem.axios";
import { postsAdapter } from "./posts.adapters";

// const DEFAULT_PAGE_SIZE = 10;

const initialState = {
  items: postsAdapter.getInitialState(),
  nextPage: 0,
  loading: false
};

export const loadPosts = createAsyncThunk(
  "posts/loadPosts",
  async (_, thunkAPI) => {
    const state = thunkAPI.getState();
    console.log(state.posts.nextPage);
    const { data } = await memAxios.get(`/api/posts`);
    return data;
  }
);

export const likePost = createAsyncThunk(
  "posts/likePost",
  async (id, nickname) => {
    const { data } = await memAxios.post(`/api/posts/${id}/like`, {
      author: nickname
    });
    return {
      id,
      countOfLikes: data
    };
  }
);

export const postsSlice = createSlice({
  name: "posts",
  initialState,
  reducers: {},
  extraReducers: builder => {
    builder.addCase(loadPosts.fulfilled, (state, action) => {
      postsAdapter.addMany(state.items, action.payload.entities);
      state.loading = false;
      state.nextPage++;
    });
    builder.addCase(likePost.fulfilled, (state, action) => {});
    builder.addMatcher(
      isAnyOf(loadPosts.rejected, loadPosts.pending),
      state => {
        state.loading = true;
      }
    );
  }
});

// export const {} = postsSlice.actions;

export default postsSlice.reducer;
