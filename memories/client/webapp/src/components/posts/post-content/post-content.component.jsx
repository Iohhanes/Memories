import React from "react";
import PropTypes from "prop-types";
import MemCarousel from "../../common/mem-carousel.component.jsx";

const PostContent = ({ images }) => {
  return <MemCarousel sliders={images} size={"500px"} />;
};

PostContent.propTypes = {
  images: PropTypes.arrayOf(PropTypes.string).isRequired
};

export default PostContent;
