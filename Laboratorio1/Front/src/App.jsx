import './App.css'
import axios from 'axios'
import { useState } from 'react'
import FlightList from './FlightList'

const FlightSearchForm = () => {
  const [formData, setFormData] = useState({
    startDate: '',
    endDate: '',
    flightType: '',
    baggageType: '',
    origin: '',
    destination: '',
    maxPrice: '',
    maxPassengers: '',
  })

  const [search, setsearch] = useState(false)

  const [filters, setFilters] = useState({
    origin: false,
    destination: false,
    maxPrice: false,
    maxPassengers: false,
  })

  const [flights, setflights] = useState([])

  const handleInputChange = (e) => {
    if (search) {
      setsearch(!search)
    }
    const { name, value } = e.target
    setFormData({ ...formData, [name]: value })
  }

  const handleCheckboxChange = (e) => {
    const { name, checked } = e.target
    setFilters({ ...filters, [name]: checked })
    if (search) {
      setsearch(!search)
    }

    // Limpiar el input si el checkbox es deseleccionado
    if (!checked) {
      setFormData({ ...formData, [name]: '' })
    }
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    if (search) {
      return
    }

    const result = {
      startDate: formData.startDate,
      endDate: formData.endDate,
      flightType: formData.flightType,
      baggageType: formData.baggageType,
    }

    if (filters.origin && formData.origin) result.origin = formData.origin
    if (filters.destination && formData.destination)
      result.destination = formData.destination
    if (filters.maxPrice && formData.maxPrice)
      result.maxPrice = formData.maxPrice
    if (filters.maxPassengers && formData.maxPassengers)
      result.maxPassengers = formData.maxPassengers

    console.log(result)
    const queryParams = new URLSearchParams(result).toString()
    console.log(
      `Petición realizada: http://localhost:8080/api/flights/search?${queryParams}`
    )

    axios
      .get(`http://localhost:8080/api/flights/search?${queryParams}`)
      .then((response) => {
        console.log(response)
        setflights(response.data)
        setsearch(!search)
      })
      .catch((error) => console.error(error))
  }

  return (
    <div id="container">
      <form className="flight-search-form" onSubmit={handleSubmit}>
        <h2>Search Flights</h2>

        <div className="form-group">
          <label>Start Date:</label>
          <input
            type="date"
            name="startDate"
            value={formData.startDate}
            onChange={handleInputChange}
            required
          />
        </div>

        <div className="form-group">
          <label>End Date:</label>
          <input
            type="date"
            name="endDate"
            value={formData.endDate}
            onChange={handleInputChange}
            required
          />
        </div>
        <div id="dropdowns">
          <div className="form-group">
            <label>Flight Type:</label>
            <select
              name="flightType"
              value={formData.flightType}
              onChange={handleInputChange}
              required
            >
              <option value="">Select Flight Class</option>
              <option value="Economy">Economy</option>
              <option value="Business">Business</option>
            </select>
          </div>

          <div className="form-group">
            <label>Baggage Type:</label>
            <select
              name="baggageType"
              value={formData.baggageType}
              onChange={handleInputChange}
              required
            >
              <option value="">Select Baggage Type</option>
              <option value="Carry-on">Carry-on</option>
              <option value="Checked">Checked</option>
            </select>
          </div>
        </div>

        <div>
          <h3>Adititonal filters: </h3>
          <div className="form-group">
            <label>
              <input
                type="checkbox"
                name="origin"
                checked={filters.origin}
                onChange={handleCheckboxChange}
              />
              Filter by Origin
            </label>
            {filters.origin && (
              <input
                type="text"
                name="origin"
                placeholder="Enter origin"
                value={formData.origin}
                onChange={handleInputChange}
              />
            )}
          </div>

          <div className="form-group">
            <label>
              <input
                type="checkbox"
                name="destination"
                checked={filters.destination}
                onChange={handleCheckboxChange}
              />
              Filter by Destination
            </label>
            {filters.destination && (
              <input
                type="text"
                name="destination"
                placeholder="Enter destination"
                value={formData.destination}
                onChange={handleInputChange}
              />
            )}
          </div>

          <div className="form-group">
            <label>
              <input
                type="checkbox"
                name="maxPrice"
                checked={filters.maxPrice}
                onChange={handleCheckboxChange}
              />
              Filter by Max Price
            </label>
            {filters.maxPrice && (
              <input
                type="number"
                name="maxPrice"
                placeholder="Enter max price"
                value={formData.maxPrice}
                onChange={handleInputChange}
              />
            )}
          </div>

          <div className="form-group">
            <label>
              <input
                type="checkbox"
                name="maxPassengers"
                checked={filters.maxPassengers}
                onChange={handleCheckboxChange}
              />
              Filter by Max Passengers
            </label>
            {filters.maxPassengers && (
              <input
                type="number"
                name="maxPassengers"
                placeholder="Enter max passegers"
                value={formData.maxPassengers}
                onChange={handleInputChange}
              />
            )}
          </div>
        </div>

        <button type="submit" className="btn-submit">
          Search Flights
        </button>
        {search && (
          <div id="available-flights">
            <h1>Available Flights: </h1>
            {flights.length > 0 ? (
              <FlightList flights={flights} />
            ) : (
              <h2>No flights found matching your filters.</h2>
            )}
          </div>
        )}
      </form>
    </div>
  )
}

export default FlightSearchForm
