FROM node
WORKDIR /webapp
ENV PATH /node_modules/.bin:$PATH
COPY package.json .
RUN npm install

COPY . .
ENV PORT 9060
EXPOSE $PORT
CMD ["npm", "start"]

