import { createEntityAdapter } from "@reduxjs/toolkit";

export const postsAdapter = createEntityAdapter({
  selectId: post => post.id
});
