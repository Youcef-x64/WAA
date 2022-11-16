// import React, {useState} from "react";
import React, { useState } from "react";
import Posts from "../components/Posts";
import PostDetails from "../components/PostDetails";

function Dashboard() {
  const [postDetails, setPostDetails] = useState({});
  const [title, setTitle] = useState("");

  const postDataInitial = [
    { id: 111, title: "Happiness", author: "John" },
    { id: 112, title: "MIU", author: "Dean" },
    { id: 113, title: "Enjoy Life", author: "Jasmine" },
  ];

  const [postData, setPostData] = useState(postDataInitial);

  function fetchPostById(id) {
    let post = postDataInitial.filter((post) => post.id == id);
    setPostDetails(post);
  }

  function changeTitle(event) {
    event.preventDefault();
    let copy = [...postData];
    copy[0].title = title == "" ? "Happiness" : title;
    setPostData(copy);
    console.log(postData);
    setTitle("");
  }

  return (
    <div>
      <Posts data={postData} fetchPostById={fetchPostById} />

      <form onSubmit={changeTitle}>
        <input
          type="text"
          value={title}
          onChange={(event) => setTitle(event.target.value)}
        />
        <button type="submit">Add</button>
      </form>
      <div>
        <PostDetails postDetails={postDetails} />
      </div>
    </div>
  );
}
export default Dashboard;
