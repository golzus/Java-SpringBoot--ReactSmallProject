import React from "react";
import "./advertisementsPageContent.css";
import { useNavigate } from "react-router-dom";
const AdvertisementsPageContent = ({ location }) => {
  const clickFuncLocalKeepLocation = () => {
    localStorage.setItem("clickedAdLocation", location);
    navigate("login");
  };
  const navigate = useNavigate();
  const clickFuncAddAdv = () => {
    console.log(location, "location");
    clickFuncLocalKeepLocation();
    navigate("login");
  };
  return (
    <div className="AdvertisementsPageContent">
      <button onClick={clickFuncAddAdv} className="btnAdvertiseHere">
        {" "}
        <h1>Advertise here</h1>
      </button>
    </div>
  );
};

export default AdvertisementsPageContent;
