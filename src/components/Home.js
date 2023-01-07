import React, { useState, useEffect } from "react";
import Navbar from "./navbar/navbar";
import { Link } from "react-router-dom";
import UserService from "../services/user.service";

const Home = () => {
  

  return (
    <>
    <Navbar/> 
    <div>  
                <div className="container mx-auto">
                <p class="text-center font-bold text-2xl mb-6">Découvrez notre application <br/> de gestion des stades</p>
                    <div><img class="flex justify-center mb-6" src={require('./assets/stdd.png')} /></div>
                    <div className="flex justify-center">
                        <Link to="/login" className="border bg-red-500 text-white font-semibold text-4xl font-sans lg:inline-block px-8 py-2 rounded-full mt-20">Commencez</Link>
                    </div>                   
                </div>
                
                
            </div>
    </>
  );
};

export default Home;