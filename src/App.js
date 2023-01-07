import React, { useState, useEffect } from "react";
import { Router, Routes, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import Login from "./components/Login";
import Register from "./components/Register";
import Home from "./components/Home";
import Profile from "./components/Profile";
import BoardUser from "./components/BoardUser";
import StadeList from "./components/StadeComponents/StadeList";
import AddStade from "./components/StadeComponents/AddStade";
import UpdateStade from "./components/StadeComponents/UpdateStade";
import StadeListU from "./components/StadeComponentsU/StadeListU";
import EventBus from "./common/EventBus";
import ReservStade from "./components/StadeComponentsU/ReservStade";

const App = () => {
  
  return (
    <div>
      <Routes>
          <Route path="/" element={<Home/>} />
          <Route path="/home" element={<Home/>} />
          <Route path="/login" element={<Login/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/profile" element={<Profile/>} />
          <Route path="/user" element={<BoardUser/>} />
          <Route path='/stadeList' element={<StadeList/>} />
          <Route path='/addStade' element={<AddStade/>}/>
          <Route path='/editStade/:stadeId' element={<UpdateStade/>}/>
          <Route path='/stadeListU' element={<StadeListU/>} />
          <Route path='/reservStade/:id' element={<ReservStade/>}/>
        </Routes>
    </div>
  );
};

export default App;