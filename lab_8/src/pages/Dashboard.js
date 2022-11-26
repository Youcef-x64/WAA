import axios from "axios";
import React, { useEffect, useState } from "react";
import PostDetails from "../components/PostDetails/PostDetails";
import Posts from "../components/Posts/Posts";
import AddPost from "../components/AddPost/AddPost";

function Dashboard(){
    const [title, setTitle ] = useState("");
    const [data, setData ] = useState([]);
    const [details, setDetails ] = useState("");
    const [id, setId] = useState(0);
    const [btnVisible, showHideBtn] = useState(false);
    const [formData, setFormData] = useState({});

    useEffect(() => {
        function fetchData(){
            axios
                .get("http://localhost:8080/api/v1/posts")
                .then(response => setData(response.data))
                .catch(console.log("Error fetching data"));
        }
        fetchData();
    },[btnVisible]);

    const submitPost = event => {
        event.preventDefault();

        const copy = [...data];

        copy[0].title = title;

        setData(copy);
        setTitle("");
    };

    const postClicked = (id) => {
        let details = data.filter(post => post.id === id);

        setDetails(details);
    };

    function deleteById() {
        axios.delete(`http://localhost:8080/api/v1/posts/${id}`).then(() => {
          showHideBtn(!btnVisible);
          setDetails([]);
        });
      }
    
      function addPost(post) {
        console.log(post);
        axios
          .post(`http://localhost:8080/api/v1/users/1/posts`, post)
          .then(() => showHideBtn(!btnVisible));
      }

    return(
        <div>
            <Posts data={data} postClicked={postClicked} />

            <form onSubmit={submitPost}>
                <div>
                    <input 
                        type = "text"
                        value={title}
                        onChange={event => setTitle(event.target.value)}
                    />
                </div>
                <button>Change Name</button>
            </form>

            <div>
        <PostDetails
          postDetails={details}
          deleteById={deleteById}
        />
      </div>

      <div>
        <AddPost addPost={addPost} />
      </div>


        </div>
    );
}

export default Dashboard;
