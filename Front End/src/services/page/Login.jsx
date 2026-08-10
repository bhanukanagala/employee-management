import {useState} from "react";

import api from "../services/api";

import {
    useNavigate
}
from "react-router-dom";
function Login(){
    const navigate = useNavigate();
    const [username,setUsername] =
        useState("");
    const [password,setPassword] =
        useState("");
    const login = async()=>{
        try{
            await api.post(
                "/auth/login",
                {
                    username,
                    password
                }
            );
            navigate("/employees");
        }
        catch(error){

            alert(
                "Invalid Login"
            );

        }

    };
    return (
        <div>
            <h2>
                Employee Management Login
            </h2>
            <input
                placeholder="Username"
                value={username}
                onChange={
                    e=>setUsername(
                        e.target.value
                    )
                }

            />


            <br/>


            <input

                type="password"

                placeholder="Password"

                value={password}

                onChange={
                    e=>setPassword(
                        e.target.value
                    )
                }

            />


            <br/>


            <button onClick={login}>

                Login

            </button>


        </div>

    );

}


export default Login;
