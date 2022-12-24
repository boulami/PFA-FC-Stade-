import React, { useState, useEffect } from 'react'
import { useParams, useNavigate} from "react-router-dom"
import AuthService from '../../services/auth.service';
import StadeService from '../../services/StadeService';
import Navbar from "../navbar/navbar";

const AddStade = () => {
    const navigaye = useNavigate();

    const [stade, setStade] = useState({
        name:"",
        address:""
    });

    const saveStade = (e) =>{
        e.preventDefault();
        StadeService.saveStade(stade)
        .then((response) => {
            console.log("name: " + stade.name + "add: " + stade.address);
            console.log(response);
            navigaye("/stadeList");
            window.location.reload();
        })
        .catch((error) => {
            console.log(error.response.data.errors);
        })
        
    };

    const handleChange = (e) => {
        const value = e.target.value;
        setStade({...stade, [e.target.name]: value});
    };

    return(
        <>
        <Navbar/>
        <div className='flex bg-gray-200 h-screen'>
            {/*<Sidebar/>*/}
            <div className="absolute top-10 right-10 h-16 ">
            {/*<DropdownMenu/>*/}
            </div>
    <div className='max-w-2xl shadow border-b m-auto bg-gray-200'>
        <div className='px-8 py-8'>
            <div className='font-semibold text-2xl tracking-wider text-gray-800'>
                <h1>Ajouter un nouveau stade</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='text-gray-800 text-xl font-bold'>Nom</label>
                <input type="text" name='name' value={stade.name} onChange={(e) => handleChange(e)} className='h-10 w-96 border mt-2 ml-24 px-2 mx-1.5'/>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='text-gray-800 text-xl font-bold absolute '>Adresse</label>
                {/*<input type="textarea" name='description' value={ticket.description} onChange={(e) => handleChange(e)} className='h-32 w-96 border mt-2 px-2 mx-8'/>*/}
                <textarea name='address' value={stade.address} onChange={(e) => handleChange(e)} rows={2} cols={5}className='w-96 border  mx-36 px-2 '/>
            </div>
            
            <div className='items-center justify-center h-14 w-full my-4 mt-36'>
                <button onClick={saveStade} className='block mx-auto bg-blue-500 hover:bg-blue-900 text-white font-semibold py-1 px-6'>Ajouter</button>
            </div>
        </div>
    </div>
    </div>
    </>
    )

}
export default AddStade