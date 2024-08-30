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

  const handleConvert = async () => {
    if (isNaN(temperature) || temperature.trim() === '') {
      setError('Please enter a valid number for temperature.');
      return;
    }
    setLoading(true);
    setError('');

    try {
      const response = await fetch('http://localhost:2215/api/convert', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify({
          temperature: parseFloat(temperature),
          fromUnit,
          toUnit
        })
      });

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const result = await response.text();
      setConvertedTemperature(result);
    } catch (error) {
      console.error('Error occurred during conversion:', error);
      setConvertedTemperature('Error occurred during conversion.');
    } finally {
      setLoading(false);
    }
  };


  return (
    <div className="App">
      <h1>Temperature Converter</h1>
      <div className="converter-form">
        <label>
          Temperature:
          <input
            type="number"
            value={temperature}
            onChange={(e) => setTemperature(e.target.value)}
          />
        </label>
        <label>
          From Unit:
          <select value={fromUnit} onChange={(e) => setFromUnit(e.target.value)}>
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
            <option value="kelvin">Kelvin</option>
          </select>
        </label>
        <label>
          To Unit:
          <select value={toUnit} onChange={(e) => setToUnit(e.target.value)}>
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
            <option value="kelvin">Kelvin</option>
          </select>
        </label>
        <button onClick={handleConvert} disabled={loading}>
          {loading ? 'Converting...' : 'Convert'}
        </button>
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
    </div>
  );
}

export default App;