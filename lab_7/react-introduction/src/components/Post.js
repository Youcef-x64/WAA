import React from "react"
function Post(props){
    return (
        <div style={{border:"2px blue groove",margin:"1.5em"}}
        onClick={()=>props.fetchPostById(props.id)}>
            <p>{props.id}</p>

            <p>{props.title}</p>
            <p>{props.author}</p>
        </div>

    )
}
export default Post;