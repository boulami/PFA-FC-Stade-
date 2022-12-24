import React, { useState, useEffect } from 'react'
import {useNavigate} from "react-router-dom"
import StadeService from '../../services/StadeService';
import Stade from './Stade';
import Navbar from "../navbar/navbar";

const StadeList = () =>{

    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [stades, setStades] = useState(''); 

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
          try{
            const response = await StadeService.getStades();
            const stades = response.data;
            const reversed = [...stades].reverse();
            setStades(reversed);
          }
          catch (error) {
            console.log(error);
          }
          setLoading(false);
        };
        fetchData();
    }, []);

    const deleteStade = (u, id) => {
        u.preventDefault();
        StadeService.deleteStade(id)
        .then((res) =>{
            setStades((prevElement)=>{
                return prevElement.filter((stade) => stade.id !== id);
            });
        });
    };

    return(
        <>
        <Navbar/>
        <div className='flex bg-gray-100'>
        
        <div className='container mx-auto my-8'>
        <div className='h-12'>
            <button 
            onClick={() => navigate("/addStade")}
            className='rounded-2xl bg-white border-black border-2 border-gray-400 px-2 py-1 font-semibold text-lg text-gray-500'>
                Ajouter Stade
            </button>
        </div>
        <div className='flex shadow border-b'>
        <table className='min-w-full'>
        <thead className='bg-gray-100'>
        <tr>
            <th className='text-left font-medium text-gray-600 -tracking-wider px-5'>Nom</th>
            <th className='text-left font-medium text-gray-600 -tracking-wider px-5'>Adresse</th>
            <th className='text-left font-medium text-gray-600 -tracking-wider px-5'>Actions</th>
        </tr>
        </thead>
        {!loading && (
                <tbody className='bg-white '>
                    {stades.map((stade) => (
                        <Stade 
                        stade={stade} 
                        deleteStade={deleteStade} 
                        key={stade.id}></Stade>
                    ))}
                </tbody>
                )}
        </table>
        </div>
        </div>
        </div>
    </>
    );
}
export default StadeList