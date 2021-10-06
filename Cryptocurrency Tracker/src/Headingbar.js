import React from "react";
import "./Coin.css";

function Headingbar() {
  return (
    <div className="coin-container">
      <div className="coin-row">
        <div className="coin">
          <h1>Name</h1>
          <p className="coin-symbol">Symbol</p>
        </div>
        <div className="coin-data">
          <p className="coin-price">₹ PRICE&nbsp;&nbsp;</p>
          <p className="coin-volume"> ₹ VOLUME</p>
          <p className="coin-percent green">CHANGE %</p>
          <p className="coin-marketcap">Mkt CAP: &nbsp;₹ MARKETCAP</p>
        </div>
      </div>
    </div>
  );
}

export default Headingbar;
