import React, { useState, useEffect } from "react";
import Navbar from "./navbar/navbar";
import { Link } from "react-router-dom";
import UserService from "../services/user.service";

const Home = () => {
  

  return (
    <>
    <Navbar/> 
    <div>  
                <div className="flex flex-row">
                    <div className="d-flex align-items-center justify-content-center font-semibold text-6xl text-gray-800 mt-48 ml-12">
                        <p>Découvrez le nouveau système <br/> de gestion des stades</p>
                        <Link to="/login" className="border bg-red-500 text-white font-semibold text-4xl font-sans lg:inline-block px-8 py-2 rounded-full mt-20">Commencez</Link>
                    </div>                   
                    <div><img src={require('./assets/stdd.png')} /></div>
                </div>
                
                
            </div>
    </>
  );
};

export default Home;