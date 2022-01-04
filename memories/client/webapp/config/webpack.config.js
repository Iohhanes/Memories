const webpack = require("webpack");
const path = require("path");
const HtmlWebpackPlugin = require("html-webpack-plugin");

const lessLoaders = loaders => {
  const lessLoader = {
    loader: "less-loader",
    options: {
      lessOptions: {
        javascriptEnabled: true
      }
    }
  };

  return [
    {
      test: /\.(le|c)ss$/,
      exclude: /\.module\.less$/,
      use: [...loaders, "css-loader", "postcss-loader", lessLoader]
    },
    {
      test: /\.module\.less$/,
      use: [
        ...loaders,
        {
          loader: "css-loader",
          options: {
            modules: {
              localIdentName: "[name]__[local]___[hash:base64:5]"
            }
          }
        },
        "postcss-loader",
        lessLoader
      ]
    }
  ];
};

module.exports = {
  entry: path.resolve(__dirname, "../src/index.js"),
  resolve: {
    extensions: [".js", ".jsx", ".ts", ".json"],
    modules: ["node_modules"]
  },
  module: {
    rules: [
      {
        test: /\.(js|jsx)$/,
        exclude: /node_modules/,
        use: [
          {
            loader: "babel-loader",
            options: {
              cacheDirectory: true,
              plugins: ["@babel/plugin-transform-runtime"]
            }
          }
        ]
      },
      {
        test: /\.(jpe?g|png|gif|woff2?|ttf|eot)$/i,
        loader: "file-loader",
        options: {
          digest: "hex",
          hash: "sha512",
          name: "images/[contenthash].[ext]"
        }
      },
      ...lessLoaders(["style-loader"])
    ]
  },
  output: {
    path: path.resolve(__dirname, "../dist"),
    filename: "bundle.js"
  },
  plugins: [
    new HtmlWebpackPlugin({
      template: "./public/index.html"
    }),
    new webpack.HotModuleReplacementPlugin()
  ],
  devServer: {
    port: 9060,
    hot: true,
    static: {
      directory: path.resolve(__dirname, "../dist")
    }
  }
};
