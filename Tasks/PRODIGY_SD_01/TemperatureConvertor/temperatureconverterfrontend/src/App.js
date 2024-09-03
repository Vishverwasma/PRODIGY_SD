import logo from './logo.svg';
import React, { useState } from 'react'; // Ensure useState is imported from React
import './App.css';

function App() {
  const [temperature, setTemperature] = useState('');
  const [fromUnit, setFromUnit] = useState('celsius');
  const [toUnit, setToUnit] = useState('fahrenheit');
  const [convertedTemperature, setConvertedTemperature] = useState('');
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [conversionHistory, setConversionHistory] = useState({ fromHistory: {}, toHistory: {} });

  const isValidTemperature = (temp) => !isNaN(temp) && temp.trim() !== '';

  const handleConvert = async () => {
    if (!isValidTemperature(temperature)) {
      setError('Please enter a valid number for temperature.');
      setConvertedTemperature('');
      return;
    }
    setLoading(true);
    setError('');

    try {
      const response = await fetch(`http://localhost:8080/api/convert?temperature=${temperature}&fromUnit=${fromUnit}&toUnit=${toUnit}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded',
        },
      });

      if (!response.ok) {
        const errorData = await response.json();
        throw new Error(errorData.message || 'Network response was not ok');
      }

      const result = await response.text();
      setConvertedTemperature(result);
    } catch (error) {
      console.error('Error occurred during conversion:', error);
      setError('Failed to convert temperature. Please try again.');
      setConvertedTemperature('');
    } finally {
      setLoading(false);
    }
  };

  const fetchConversionHistory = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/conversion-history');
      if (!response.ok) {
        throw new Error('Failed to fetch conversion history');
      }
      const data = await response.json();
      setConversionHistory(data);
    } catch (error) {
      console.error('Error fetching conversion history:', error);
    }
  };

  const handleClearHistory = async () => {
    try {
      const response = await fetch('http://localhost:8080/api/clear-history', {
        method: 'POST',
      });

      if (!response.ok) {
        throw new Error('Failed to clear conversion history');
      }

      alert('Conversion history cleared');
      setConversionHistory({ fromHistory: {}, toHistory: {} });
    } catch (error) {
      console.error('Error clearing conversion history:', error);
    }
  };

  return (
    <div className="App">
      <h1>Temperature Converter</h1>
      <div className="converter-form">
        <label htmlFor="temperature">
          Temperature:
          <input
            id="temperature"
            type="number"
            value={temperature}
            onChange={(e) => setTemperature(e.target.value)}
            aria-label="Temperature input"
          />
        </label>
        <label htmlFor="fromUnit">
          From Unit:
          <select
            id="fromUnit"
            value={fromUnit}
            onChange={(e) => setFromUnit(e.target.value)}
            aria-label="From Unit"
          >
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
            <option value="kelvin">Kelvin</option>
          </select>
        </label>
        <label htmlFor="toUnit">
          To Unit:
          <select
            id="toUnit"
            value={toUnit}
            onChange={(e) => setToUnit(e.target.value)}
            aria-label="To Unit"
          >
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
            <option value="kelvin">Kelvin</option>
          </select>
        </label>
        <button onClick={handleConvert} disabled={loading}>
          {loading ? 'Converting...' : 'Convert'}
        </button>
        <button onClick={fetchConversionHistory}>Fetch History</button>
        <button onClick={handleClearHistory}>Clear History</button>
      </div>
      {error && (
        <div className="error">
          <p>{error}</p>
        </div>
      )}
      {convertedTemperature && (
        <div className="result">
          <h2>Converted Temperature</h2>
          <p>{convertedTemperature}</p>
        </div>
      )}
      {conversionHistory.fromHistory && (
        <div className="history">
          <h2>Conversion History</h2>
          <table>
            <thead>
              <tr>
                <th>From Value and Unit</th>
                <th>To Value and Unit</th>
              </tr>
            </thead>
            <tbody>
              {Object.entries(conversionHistory.fromHistory).map(([key, value]) => (
                <tr key={key}>
                  <td>{key}</td>
                  <td>{conversionHistory.toHistory[key]}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
}

export default App;