import React from "react";
import "./PostDetails.css"
import Comment from "../Comments/Comments";

function PostDetails(props){
    return(
        <div className="details">
            {props.postDetails.length && (
                <>
                    <h5>{props.postDetails[0].title}</h5>
                    <h6>{props.postDetails[0].author}</h6>
                    <p>
                        <em>Posted by:</em> {props.postDetails[0].author}
                    </p>

                    <div>
                        <Comment comments={props.postDetails[0].comments} />
                    </div>

                    <div>
                        <button>Edit</button>
                        <button onClick={() => props.deleteById()}>Delete</button>
                    </div>
                </>
            )}
        </div>
    );
}

export default React.memo(PostDetails);
