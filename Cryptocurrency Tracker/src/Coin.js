import React from "react";
import "./Coin.css";

const Coin = ({
  name,
  price,
  symbol,
  marketcap,
  volume,
  image,
  priceChange,
}) => {
  return (
    <div className="coin-container">
        
      <div className="coin-row">
        <div className="coin">
          <img src={image} alt="crypto" />
          <h1>{name}&nbsp;</h1>
          <p className="coin-symbol">&nbsp;{symbol}</p>
        </div>
        <div className="coin-data">
          <p className="coin-price">₹{price}&nbsp;&nbsp;</p> 
          <p className="coin-volume"> ₹{volume.toLocaleString()}</p> 

          {priceChange < 0 ? (
            <p className="coin-percent red">{priceChange.toFixed(2)}%</p>
          ) : (
            <p className="coin-percent green">{priceChange.toFixed(2)}%</p>
          )}

          <p className="coin-marketcap">
            Mkt Cap: &nbsp;₹{marketcap.toLocaleString()}
          </p>
        </div>
      </div>
    </div>
  );
};

export default Coin;
