import React from "react";
import PropTypes from "prop-types";
import AntButton from "antd/lib/button/index";
import clsx from "clsx";

const MemButton = ({
  className,
  type = "primary",
  disabled,
  children,
  ...rest
}) => {
  return (
    <AntButton
      className={clsx("taButton", className)}
      type={type}
      disabled={disabled}
      {...rest}
    >
      {children}
    </AntButton>
  );
};

MemButton.propTypes = {
  className: PropTypes.string,
  type: PropTypes.string,
  disabled: PropTypes.bool,
  ...AntButton.propTypes
};

export default MemButton;
