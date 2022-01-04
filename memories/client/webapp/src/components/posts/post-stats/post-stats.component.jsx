import React from "react";
import PropTypes from "prop-types";
import PostLikesCounterContainer from "./post-likes-counter/post-likes-counter.container.jsx";
import PostCommentsCounterContainer from "./post-comments-counter/post-comments-counter.container.jsx";

const PostStats = ({ id }) => {
  return (
    <div className="post-stats">
      <PostLikesCounterContainer id={id} />
      <PostCommentsCounterContainer id={id} />
    </div>
  );
};

PostStats.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostStats);
