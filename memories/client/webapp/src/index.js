import { ReactKeycloakProvider } from "@react-keycloak/web";
import React from "react";
import ReactDOM from "react-dom";
import keycloak from "./security/keycloak";
import MemoriesApp from "./components/memories-app.jsx";
import { Provider } from "react-redux";
import { store } from "./store/store";
import "./styles/styles.less";
import { createServer } from "./server";
import { configResponsive } from "ahooks";
import {
  DESKTOP,
  DESKTOP_WIDTH,
  TABLET,
  TABLET_WIDTH,
  MOBILE,
  MOBILE_WIDTH
} from "./constants/common.js";

createServer();

configResponsive({
  [DESKTOP]: DESKTOP_WIDTH,
  [TABLET]: TABLET_WIDTH,
  [MOBILE]: MOBILE_WIDTH
});

ReactDOM.render(
  <React.StrictMode>
    <ReactKeycloakProvider authClient={keycloak}>
      <Provider store={store}>
        <MemoriesApp />
      </Provider>
    </ReactKeycloakProvider>
  </React.StrictMode>,
  document.getElementById("root")
);
