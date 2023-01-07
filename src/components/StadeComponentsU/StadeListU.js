import React, { useState, useEffect } from 'react'
import {useNavigate} from "react-router-dom"
import StadeService from '../../services/StadeService';
import StadeU from './StadeU';
import Navbar from "../navbar/navbar";

const StadeListU = () =>{

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
        <div className='flex bg-gray-200 h-screen'>
        
        <div className='container mx-auto my-8'>
        
        <div className='shadow border-b overflow-x-auto'>
        <table className='w-full'>
        <thead className='bg-gray-100'>
        <tr>
            <th className='text-left font-medium text-gray-600 -tracking-wider px-4 py-2'>Nom</th>
            <th className='text-left font-medium text-gray-600 -tracking-wider px-4 py-2'>Adresse</th>
            <th className='text-left font-medium text-gray-600 -tracking-wider px-4 py-2'>Actions</th>
        </tr>
        </thead>
        {!loading && (
                <tbody className='bg-white '>
                    {stades.map((stade) => (
                        <StadeU 
                        stade={stade} 
                        deleteStade={deleteStade} 
                        key={stade.id}></StadeU>
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
export default StadeListU