import React, { useState, useEffect } from "react";
import axios from "axios";
import "./App.css";
import Coin from './Coin';
import Headingbar from "./Headingbar";

function App() {
  const [coins, setCoins] = useState([]);
  const [search, setSearch] = useState('');

  useEffect(() => {
    axios
      .get(
        "https://api.coingecko.com/api/v3/coins/markets?vs_currency=INR&order=market_cap_desc&per_page=25&page=1&sparkline=false"
      )
      .then((res) => {
        setCoins(res.data);
        console.log(res.data);
      })
      .catch((error) => console.log(error));
  }, []);

  const handleChange = e => {
    setSearch(e.target.value);
  };

  const filteredCoins = coins.filter(coin =>
    coin.name.toLowerCase().includes(search.toLowerCase())
  );

  return (
    <div className="coin-app">
      <div className="coin-search">
        <h1 className="coin-text">Search a Currency 💵₿</h1>
        <form>
          <input
            className="coin-input"
            type="text"
            onChange={handleChange}
            placeholder="Search Name Of Cryptocurrency"
          />
        </form>
      </div>
      <Headingbar/>
      {filteredCoins.map((coin) => {
        return (
          <div>
          
          <Coin
            key={coin.id}
            name={coin.name}
            price={coin.current_price}
            symbol={coin.symbol}
            marketcap={coin.total_volume}
            volume={coin.market_cap}
            image={coin.image}
            priceChange={coin.price_change_percentage_24h}
          /></div>
        );
      })}
    </div>
  );
}

export default App;
