import { Server } from "miragejs";
import { v4 as uuidv4 } from "uuid";
import fImg from "../public/f.jpeg";
import sImg from "../public/s.jpeg";
import tImg from "../public/t.jpg";
import profile from "../public/profile.png";

export function createServer() {
  return new Server({
    routes() {
      this.get("/api/posts", () => {
        const id1 = uuidv4();
        const id2 = uuidv4();
        const id3 = uuidv4();
        const id4 = uuidv4();
        const id5 = uuidv4();
        setTimeout(() => {}, 10000);
        return {
          ids: [id1, id2, id3, id4, id5],
          entities: {
            [id1]: {
              id: id1,
              description: "Test post 1",
              images: [fImg, sImg, tImg],
              liked: true,
              countOfLikes: 25,
              countOfComments: 125,
              author: {
                nickname: "Iohhanes",
                profile: profile
              }
            },
            [id2]: {
              id: id2,
              description: "Test post 2",
              images: [fImg, sImg, tImg],
              liked: false,
              countOfLikes: 49,
              countOfComments: 10009765,
              author: {
                nickname: "Iohhanes",
                profile: profile
              }
            },
            [id3]: {
              id: id3,
              description: "Test post 3",
              images: [fImg, sImg, tImg],
              liked: true,
              countOfLikes: 100000045,
              countOfComments: 6543,
              author: {
                nickname: "Iohhanes",
                profile: profile
              }
            },
            [id4]: {
              id: id4,
              description: "Test post 4",
              images: [fImg, sImg, tImg],
              liked: false,
              countOfLikes: 1009,
              countOfComments: 2,
              author: {
                nickname: "Iohhanes",
                profile: profile
              }
            },
            [id5]: {
              id: id5,
              description: "Test post 5",
              images: [fImg, sImg, tImg],
              liked: true,
              countOfLikes: 9879644,
              countOfComments: 76,
              author: {
                nickname: "Iohhanes",
                profile: profile
              }
            }
          }
        };
      });
    }
  });
}
