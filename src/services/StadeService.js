import axios from "axios";
import authHeader from './auth-header';

const STADE_API_BASE_URL = "http://localhost:8080/stadium";

class StadeService {
    saveStade(stade){
        return axios.post(STADE_API_BASE_URL + "/add", stade, { headers: authHeader() });
    }

    getStades(){
        return axios.get(STADE_API_BASE_URL + "/getAllStades", { headers: authHeader() })
    }

    getStade(id){
        return axios.get(STADE_API_BASE_URL + "/getStade/" + id, { headers: authHeader() })
    }

    updateStade(id, stade){
        return axios.put(STADE_API_BASE_URL + "/update/" + id, stade, { headers: authHeader() })
    }

    deleteStade(id){
        return axios.delete(STADE_API_BASE_URL + "/" + id, { headers: authHeader() });
    }
}
export default new StadeService();