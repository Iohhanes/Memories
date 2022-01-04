import { createSelector } from "@reduxjs/toolkit";

import { postsAdapter } from "./posts.adapters";

const { selectAll, selectIds, selectById } = postsAdapter.getSelectors();

export const selectLoading = state => state.posts.loading;

export const selectPostsIds = state => selectIds(state.posts.items);
export const selectPosts = state => selectAll(state.posts.items);
export const selectPostById = (state, id) => selectById(state.posts.items, id);

// const createSelectPostById = id =>
//   createSelector([state => selectById(state.posts.items, id)], post => post);

export const createSelectPostCountOfLikes = id =>
  createSelector(
    [state => selectPostById(state, id)],
    post => post.countOfLikes
  );

export const createSelectIsPostLiked = id =>
  createSelector([state => selectPostById(state, id)], post => post.liked);

export const createSelectPostСountOfComments = id =>
  createSelector(
    [state => selectPostById(state, id)],
    post => post.countOfComments
  );

export const createSelectPostDescription = id =>
  createSelector(
    [state => selectPostById(state, id)],
    post => post.description
  );

export const createSelectPostImages = id =>
  createSelector([state => selectPostById(state, id)], post => post.images);

const createSelectPostAuthor = id =>
  createSelector([state => selectPostById(state, id)], post => post.author);

export const createSelectPostAuthorProfile = id => {
  const selectPostAuthor = createSelectPostAuthor(id);
  return createSelector([selectPostAuthor], author => author.profile);
};

export const createSelectPostAuthorNickname = id => {
  const selectPostAuthor = createSelectPostAuthor(id);
  return createSelector([selectPostAuthor], author => author.nickname);
};
