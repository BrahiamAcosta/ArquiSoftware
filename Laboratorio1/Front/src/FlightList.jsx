import './FlightList.css'
/* eslint-disable react/prop-types */
export default function FlightList({ flights }) {
  return (
    <table width={'90%'}>
      <thead>
        <tr>
          <th>Origin</th>
          <th>Destination</th>
          <th>Date</th>
          <th>Price</th>
          <th>Passengers</th>
          <th>Baggage Type</th>
          <th>Class Type</th>
        </tr>
      </thead>
      <tbody>
        {flights.map((flight) => {
          return (
            <tr key={flight.id}>
              <td>{flight.origin}</td>
              <td>{flight.destination}</td>
              <td>{flight.date}</td>
              <td>{flight.price}</td>
              <td>{flight.maxPassengers}</td>
              <td>{flight.baggageType}</td>
              <td>{flight.flightType}</td>
            </tr>
          )
        })}
      </tbody>
    </table>
  )
}
