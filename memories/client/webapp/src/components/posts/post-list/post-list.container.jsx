import React, { useCallback } from "react";
import { useSelector, useDispatch } from "react-redux";
import { selectPostsIds } from "../../../store/posts/posts.selectors";
import { loadPosts } from "../../../store/posts/posts.slice";
import PostList from "./post-list.component.jsx";

const PostListContainer = () => {
  const dispatch = useDispatch();

  const ids = useSelector(selectPostsIds);

  const handleLoadMore = useCallback(() => {
    dispatch(loadPosts());
  }, [dispatch]);

  return <PostList ids={ids} onLoadMore={handleLoadMore} />;
};

export default React.memo(PostListContainer);
