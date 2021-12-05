import React from "react";
import PropTypes from "prop-types";
import { Button } from "antd";
import clsx from "clsx";

const MemButton = ({
  className,
  type = "primary",
  disabled,
  children,
  ...rest
}) => {
  return (
    <Button
      className={clsx("taButton", className)}
      type={type}
      disabled={disabled}
      {...rest}
    >
      {children}
    </Button>
  );
};

MemButton.propTypes = {
  className: PropTypes.string,
  type: PropTypes.string,
  disabled: PropTypes.bool,
  ...Button.propTypes
};

export default MemButton;
