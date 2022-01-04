import React, { useMemo } from "react";
import { useSelector } from "react-redux";
import { createSelectPostImages } from "../../../store/posts/posts.selectors";
import PostContent from "./post-content.component.jsx";
import PropTypes from "prop-types";

const PostContentContainer = ({ id }) => {
  const selectPostImages = useMemo(() => createSelectPostImages(id), [id]);

  const images = useSelector(selectPostImages);

  return <PostContent images={images} />;
};

PostContentContainer.propTypes = {
  id: PropTypes.string.isRequired
};

export default React.memo(PostContentContainer);
