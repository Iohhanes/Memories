import React from "react";
import PropTypes from "prop-types";
import PostDescription from "./post-description/post-description.component.jsx";
import PostStats from "./post-stats/post-stats.component.jsx";
import PostContentContainer from "./post-content/post-content.container.jsx";

const Post = ({ id }) => {
  return (
    <div className="post">
      <PostDescription id={id} />
      <PostContentContainer id={id} />
      <PostStats id={id} />
    </div>
  );
};

Post.propTypes = {
  id: PropTypes.string.isRequired
};

export default Post;
