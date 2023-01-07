import React from "react";
import { useNavigate } from "react-router-dom";

const StadeU = ({ stade, deleteStade, user }) => {
    const navigate = useNavigate();
    
    const reservStade = (e, id) => {
        e.preventDefault();
        navigate(`/reservStade/${id}`);
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
            <td className="text-left px-5 py-2 whitespace-nowrap font-medium text-sm">
                <a onClick={(e, id) => reservStade(e, stade.id)}
                className="text-gray-600 hover:bg-yellow-500 bg-yellow-400 px-2 py-1 rounded-xl hover: cursor-pointer"
                >
                  Réserver
                </a>
            </td>
        </tr>
    );
};
export default StadeU;