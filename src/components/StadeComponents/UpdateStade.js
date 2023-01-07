import React, { useState, useEffect } from "react";
import { useParams,useNavigate } from "react-router-dom";
import StadeService from "../../services/StadeService";
import Navbar from "../navbar/navbar";
import Sidebar from "../sidebar/sidebar";

const UpdateStade = () => {

  const { stadeId } = useParams();

  const navigate = useNavigate()

  const [stade, setStade] = useState({
    id: parseInt(stadeId),
    name: "",
    address: ""
  });

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await StadeService.getStade(stadeId);
        console.log('stadeId: '+stadeId);
        setStade(response.data);      
        console.log("stade: "+stade.name)  
      } catch (error) {
        console.log(error.response.data.errors);
      }
      setLoading(false);
    };
    fetchData();
  }, []);
  
  const handleChange = (e) => {
    const value = e.target.value;
    setStade({ ...stade, [e.target.name]: value });
  };

  const [loading, setLoading] = useState(true);

  
  const updateStade = (e) => {
    e.preventDefault();
    console.log('stadeId: '+stadeId);
    StadeService.updateStade(stadeId, stade)
      .then((response) => {
        navigate("/stadeList");
      })
      .catch((error) => {
        console.log(error.response.data.errors);
      });
  };

  const naviguer = () => {
          navigate("/stadeList");
          window.location.reload();
  }


  return (
    <>
    <Navbar/>
    <div className='flex bg-gray-100 h-screen'>
    {/*<Sidebar/>*/}
    <div className="absolute top-10 right-10 h-16 ">
        {/*<DropdownMenu/>*/}
    </div>
    <div className="flex max-w-2xl shadow border-b m-auto bg-gray-100">
      <div className="px-8 py-8">
        <div className="font-semibold text-2xl tracking-wider text-gray-500">
          <h1>Modifier un stade</h1>
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="text-gray-500 text-xl font-bold">Nom</label>
          <input
            type="text"
            name="name"
            value={stade.name}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 mx-14"
          />
        </div>
        <div className="items-center justify-center h-14 w-full my-4">
          <label className="text-gray-500 text-xl font-bold ">Adresse</label>
          <input
            type="text"
            name="address"
            value={stade.address}
            onChange={(e) => handleChange(e)}
            className="h-10 w-96 border mt-2 px-2 mx-8"
          />
        </div>
        <div className="items-center justify-center grid grid-cols-2 gap-4 h-14 w-full my-4">
          <button
            onClick={updateStade}
            className=" bg-blue-500 hover:bg-blue-900 text-white font-semibold py-1 px-6"
          >
            Modifier
          </button>
          <button onClick={naviguer} 
          className=" bg-blue-500 hover:bg-blue-900 text-white font-semibold py-1 px-6">
            Annuler
          </button>
        </div>
      </div>
    </div>
    </div>
    </>
  );
};

export default UpdateStade;
