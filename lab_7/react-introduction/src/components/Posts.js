import React from "react";
import Post from "./Post";
import "./Post.css";

function Posts(data, fetchPostById) {
  console.log(data.data);
  return (
    <div className="posts">
      {data.data.map((post) => {
        return (
          <Post
            fetchPostById={fetchPostById}
            id={post.id}
            title={post.title}
            author={post.author}
            key={post.id}
          />
        );
      })}
    </div>
  );
}
export default Posts;
