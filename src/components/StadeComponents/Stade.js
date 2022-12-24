import React from "react";
import { useNavigate } from "react-router-dom";

const Stade = ({ stade, deleteStade, user }) => {
    const navigate = useNavigate();
    
    const editStade = (e, stadeId) => {
        e.preventDefault();
        navigate(`/editStade/${stadeId}`);
        window.location.reload();
      }   

    return(
        <tr key={stade.id}>
            <td className="text-left px-5 py-2 whitespace-nowrap font-medium text-sm">
        <div className="text-gray-600">{stade.name}</div>
      </td>
      <td className="text-left px-5 py-2 whitespace-nowrap font-medium text-sm">
        <div className="text-gray-600">{stade.address}</div>
      </td>
            <td>
        <a onClick={(e, id) => editStade(e, stade.id)}
        className="text-gray-600 hover:bg-yellow-500 bg-yellow-400 px-2 py-1 rounded-xl hover: cursor-pointer"
        >
          modifier
        </a>
        <a onClick={(u, id) => deleteStade(u, stade.id)}
        className="text-gray-700 hover:bg-red-500 bg-red-400 px-2 py-1 rounded-xl hover: cursor-pointer"
        >
          supprimer
        </a>
        </td>
        </tr>
    );
};
export default Stade;