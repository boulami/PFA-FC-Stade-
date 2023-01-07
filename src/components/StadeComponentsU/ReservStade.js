import React, { useState, useEffect } from "react";
import { useParams,useNavigate } from "react-router-dom";
import StadeService from "../../services/StadeService";
import Navbar from "../navbar/navbar";
import Sidebar from "../sidebar/sidebar";
import ReservationService from "../../services/ReservationService";
import AuthService from "../../services/auth.service";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import InputDatetimeLocal from 'react-input-datetime-local';
import authHeader from "../../services/auth-header";


const ReservStade = () => {
    const { id } = useParams();

    const navigaye = useNavigate();

    const[reservation, setReservation] = useState({
        stadiumId: id,
        day:"",
        time:"",
        guestName:"",
        guestEmail:""
    });

    const saveReservation = (e) =>{
        e.preventDefault();
        console.log("id: "+id);
        console.log("stadiumId: " + reservation.stadiumId);
        ReservationService.saveReservation(reservation)
        .then((response) => {
            console.log(response);
            navigaye("/stadeListU");
            window.location.reload();
        })
        .catch((error) => {
            console.log(error.response.data.errors);
        })
        
    };

    const timeSlots = ['7:00 - 8:00','8:00 - 9:00', '9:00 - 10:00',
                     '10:00 - 11:00', '11:00 - 12:00', '17:00 - 18:00',
                     '18:00 - 19:00', '19:00 - 20:00', '20:00 - 21:00',
                     '21:00 - 22:00',];
    
    let timeOptions = [];
    timeOptions = timeSlots;

    const [minDate, setMinDate] = useState('');

    useEffect(() => {
        const today = new Date();
        const dd = String(today.getDate()).padStart(2, '0');
        const mm = String(today.getMonth() + 1).padStart(2, '0'); // January is 0!
        const yyyy = today.getFullYear();
        setMinDate(`${yyyy}-${mm}-${dd}`);
    }, []);


    const [loading, setLoading] = useState(true);

    const [stade, setStade] = useState([]);


    const [reservedDayss, setReservedDayss] = useState([]);
    const reservedDays = [];
    const [data, setData] = useState({});

    const [items, setItems] = useState(
        {
            time: "",
            day: ""
        }
    );
    const [loading2, setLoading2] = useState(true);

    /*useEffect(() => {
      async function fetchData2() {
        const response = await fetch('http://localhost:8080/reservation/getReservationTimes/'+id, { headers: authHeader() });
        const data = await response.json();
        console.log("data"+data)
        setItems(data.map(item => ({ key: item.value, value: item })));
        setLoading2(false);
      }
      fetchData2();
    }, []);*/

    useEffect(() => {
        const fetchData = async () => {
            //setLoading(true);
          try{
            const response = await StadeService.getStade(id);
            const stadee = response.data;
            setData(stadee);
            console.log("stade: " + data);

            const response2 = await ReservationService.getReservationTimeslots(id);
            const data1 = await response2.data;
            console.log("data: "+data)
            await setItems(data1.map(item => ({ key: item.value, value: item })));
            setLoading2(false);
            //stadee.reservations.map(res => {
            //    reservedTimes.push(res.time);
            //    reservedDays.push(res.day);
            //});
            //console.log("reservedTimes: "+reservedTimes);
            //console.log("reservedDays: "+reservedDays);
          } 
          catch (error) {
            console.log(error);
          }
          setLoading2(true);
        };
        
        fetchData();
    }, []);
    console.log("items: "+items)
    
    const [reservedTimeslotss, setReservedTimeslotss] = useState([]);
    /*function fillArray() {
        console.log("reservedTimess: "+reservedTimess)
        setReservedTimeslotss(reservedTimess.map(item => ({ value: item })));
        console.log("reservedTimeslotss: "+reservedTimeslotss)  
    }*/

    const reservedTimess = [];
    const reservedTimes = [];
    const handleChange = (e) => {
        const value = e.target.value;       
        setReservation({...reservation, [e.target.name]: value});
        if(e.target.name==="day"){
            console.log("e.target.value: "+e.target.value);
            console.log("reservation.day: "+value);
            items.map((item)=>{
                console.dir("item.day: " +item.time)
                if(value===item.day){
                    console.log("yesss: ")
                }
            });
            //setReservedTimeslotss(reservedTimeslotss.concat(reservedTimess));
        } 
    };

    

    return(
        <>
        <Navbar/>
        <div className='flex bg-gray-200 h-screen'>
            {/*<Sidebar/>*/}
            <div className="absolute top-10 right-10 h-16 ">
            {/*<DropdownMenu/>*/}
            </div>
    <div className='max-w-2xl shadow border-b m-auto bg-gray-200'>
        <div className='px-8 py-8'>
            <div className='font-semibold text-2xl tracking-wider text-gray-800'>
                <h1>Réserver un stade</h1>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='text-gray-800 text-xl font-bold'>Day</label>
                {/*<input type="datetime-local" name='startDate' step={3600} value={reservation.startDate} onChange={(e) => handleChange(e)} className='h-10 w-96 border mt-2 ml-36 px-2 mx-1.5'/>*/}
                <input type="date" id="day" name="day" value={reservation.day} min={minDate} onChange={(e) => handleChange(e)} className='h-10 w-96 border mt-2 ml-24 px-2 mx-1.5'/>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='text-gray-800 text-xl font-bold'>Time</label>
                {/*<input type="datetime-local" name='endDate' step={3600} value={reservation.endDate} onChange={(e) => handleChange(e)} className='h-10 w-96 border mt-2 ml-36 px-2 mx-1.5'/>*/} 
                <select id="time" name="time" value={reservation.time} onChange={(e) => handleChange(e)}className='h-10 w-96 border mt-2 ml-24 px-2 mx-1.5'>
                    <option value="">-- Select a time --</option>
                        {timeOptions.map((time) => (
                          <option 
                          key={time} 
                          value={time} 
                          disabled={reservedTimess.includes(time)}>
                            {time}
                          </option>
                        ))}
                </select>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='text-gray-800 text-xl font-bold  '>Guest Name</label>
                <input type="text" name='guestName' value={reservation.guestName} onChange={(e) => handleChange(e)} className='h-10 w-96 border mt-2 ml-7 px-2 mx-1.5'/>
            </div>
            <div className='items-center justify-center h-14 w-full my-4'>
                <label className='text-gray-800 text-xl font-bold  '>Guest Email</label>
                <input type="text" name='guestEmail' value={reservation.guestEmail} onChange={(e) => handleChange(e)} className='h-10 w-96 border mt-2 ml-8 px-2 mx-1.5'/>
            </div>
            <div className='items-center justify-center h-14 w-full my-4 mt-36'>
                <button onClick={saveReservation} className='block mx-auto bg-blue-500 hover:bg-blue-900 text-white font-semibold py-1 px-6'>Réserver</button>
            </div>
        </div>
    </div>
    </div>
    </>
    )
};
export default ReservStade;