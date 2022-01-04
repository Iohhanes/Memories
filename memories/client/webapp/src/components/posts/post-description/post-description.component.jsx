import React from "react";
import PropTypes from "prop-types";
import PostDescriptionAuthorContainer from "./post-description-author/post-description-author.container.jsx";
import PostDescriptionTextContainer from "./post-description-text/post-description-text.container.jsx";

const PostDescription = ({ id }) => {
  return (
    <div className="post-description">
      <PostDescriptionAuthorContainer id={id} />
      <PostDescriptionTextContainer id={id} />
    </div>
  );
};

PostDescription.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostDescription);
