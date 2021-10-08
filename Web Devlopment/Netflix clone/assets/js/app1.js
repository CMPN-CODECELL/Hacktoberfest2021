import React, { useState, useEffect } from "react";
import "./styles.css";
import { firebase } from "./firebase";


let arrData = [];
export default function App() {
  const API = "3c9ce8e6b70419c4e30672da076b963a";
  const [data, setData] = useState([]);
  let count = 10;
  useEffect(() => {
    fetch(
      `https://api.themoviedb.org/3/movie/popular?api_key=${API}&language=en-US&page=${count}`
    )
      .then((res) => res.json())
      .then((datas) => {
        setData(datas.results);
        arrData = [...data];
        seedDatabase(firebase);
      });
  }, []);

  return (
    <div className="App">
      <h1>Hello CodeSandbox</h1>
      <h2>Start editing to see some magic happen!</h2>=
    </div>
  );
}

function seedDatabase(vs) {
  arrData.forEach((el) => {
    firebase.firestore().collection("films").add({
      id: el.id,
      title: el.original_title,
      description: el.overview,
      genre: el.genre_ids[0],
      maturity: el.vote_average,
      slug: el.title
    });
  });
}
