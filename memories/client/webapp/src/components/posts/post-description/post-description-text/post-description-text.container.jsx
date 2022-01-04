import React, { useMemo } from "react";
import PropTypes from "prop-types";
import PostDescriptionText from "./post-description-text.component.jsx";
import { createSelectPostDescription } from "../../../../store/posts/posts.selectors";
import { useSelector } from "react-redux";

const PostDescriptionTextContainer = ({ id }) => {
  const selectDescription = useMemo(
    () => createSelectPostDescription(id),
    [id]
  );

  const text = useSelector(selectDescription);

  return <PostDescriptionText text={text} />;
};

PostDescriptionTextContainer.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostDescriptionTextContainer);
