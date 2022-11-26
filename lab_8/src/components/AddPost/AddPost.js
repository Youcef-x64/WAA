import React, { useState } from "react";

import "./AddPost.css";

function AddPost(props) {
  const [formData, setFormData] = useState({
    author: "",
    title: "",
    content: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    
    setFormData((prev) => {
      return { ...prev, [name]: value };
    });
  };

  function handleSubmit(event) {
    event.preventDefault();
    props.addPost(formData);
  }

  return (
    <div>
      <h2>ADD POST</h2>
      <form onSubmit={handleSubmit}>
        <div className="div-form">
          <label>Title: </label>
          <input
            type="text"
            name="title"
            value={formData.title}
            onChange={handleChange}
          />
        </div>

        <div className="div-form">
          <label>Content: </label>
          <textarea
            name="content"
            value={formData.content}
            onChange={handleChange}
          />
        </div>

        <div className="div-form">
          <label>Author: </label>
          <input
            type="text"
            name="author"
            value={formData.author}
            onChange={handleChange}
          />
        </div>

        <div className="div-form">
          <button>Submit</button>
        </div>
      </form>
    </div>
  );
}

export default AddPost;