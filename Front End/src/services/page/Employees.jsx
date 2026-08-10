import {
    useEffect,
    useState
}
from "react";


import api from "../services/api";



function Employees(){


    const [employees,setEmployees] =
        useState([]);



    useEffect(()=>{


        loadEmployees();


    },[]);




    const loadEmployees = async()=>{


        const response =
            await api.get(
                "/employees"
            );


        setEmployees(
            response.data
        );


    };




    return (

        <div>


            <h2>
                Employee List
            </h2>



            {

                employees.map(
                    employee=>(

                        <div key={employee.id}>


                            {employee.firstName}

                            {" "}

                            {employee.lastName}


                            {" - "}

                            {employee.department}


                        </div>

                    )

                )

            }


        </div>

    );


}


export default Employees;
