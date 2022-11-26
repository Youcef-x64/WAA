import React from "react";
import "./Post.css";

function Post(props){
    return(
        <div 
            className="post"
            onClick={() => props.postClicked(props.id)}
        >
            <p>Id: {props.id}</p>
            <p>Title: {props.title}</p>
            <p>Author: {props.author}</p>
        </div>
    );
}

export default Post;