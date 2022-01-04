import React from "react";
import PropTypes from "prop-types";
import Carousel from "antd/lib/carousel/index";

const MemCarousel = ({ sliders, size, ...rest }) => {
  return (
    <div className="mem-carousel" style={{ width: `${size}` }}>
      <Carousel dotPosition="bottom" infinite={false} arrows {...rest}>
        {sliders.map((imgSrc, index) => (
          <div key={index}>
            <div
              style={{
                height: `${size}`,
                backgroundImage: `url(${imgSrc})`,
                backgroundSize: "100% 100%"
              }}
            />
          </div>
        ))}
      </Carousel>
    </div>
  );
};

MemCarousel.propTypes = {
  sliders: PropTypes.arrayOf(PropTypes.string).isRequired,
  size: PropTypes.oneOfType([PropTypes.string, PropTypes.number]).isRequired,
  ...Carousel.propTypes
};

export default MemCarousel;
