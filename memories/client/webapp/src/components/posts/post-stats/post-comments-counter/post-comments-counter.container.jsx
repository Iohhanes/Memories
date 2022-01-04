import React, { useMemo } from "react";
import PropTypes from "prop-types";
import { createSelectPostСountOfComments } from "../../../../store/posts/posts.selectors";
import { useSelector } from "react-redux";
import PostCommentsCounter from "./post-comments-counter.component.jsx";

const PostLikesCounterContainer = ({ id }) => {
  const selectPostCountOfComments = useMemo(
    () => createSelectPostСountOfComments(id),
    [id]
  );

  const count = useSelector(selectPostCountOfComments);

  return <PostCommentsCounter count={count} />;
};

PostLikesCounterContainer.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostLikesCounterContainer);
