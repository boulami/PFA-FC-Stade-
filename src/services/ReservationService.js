import axios from "axios";
import authHeader from './auth-header';

const RESERVATION_API_BASE_URL = "http://localhost:8080/reservation";

class ReservationService {
    saveReservation(reservation){
        return axios.post(RESERVATION_API_BASE_URL + "/add", reservation, { headers: authHeader() });
    }

    getReservations(){
        return axios.get(RESERVATION_API_BASE_URL + "/getAllReservations", { headers: authHeader() })
    }

    getReservation(id){
        return axios.get(RESERVATION_API_BASE_URL + "/getReservation/" + id, { headers: authHeader() })
    }

    getReservationTimeslots(id){
        return axios.get(RESERVATION_API_BASE_URL + "/getReservationTimes/" + id, {headers: authHeader()})
    }

    updateReservation(id, reservation){
        return axios.put(RESERVATION_API_BASE_URL + "/update/" + id, reservation, { headers: authHeader() })
    }

    deleteReservation(id){
        return axios.delete(RESERVATION_API_BASE_URL + "/" + id, { headers: authHeader() });
    }
}
export default new ReservationService();