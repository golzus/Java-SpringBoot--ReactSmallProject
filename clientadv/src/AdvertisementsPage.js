import React, { useEffect, useState } from "react";
import "./advertisementsPage.css";
import AdvertisementsPageContent from "./AdvertisementsPageContent";

const AdvertisementsPage = () => {
  const [advertisements, setAdvertisements] = useState([]);
  const [imagePathArr, setImagePathArr] = useState([null, null, null, null]); // Array of image paths

  const fetchAdvertisements = async () => {
    try {
      const response = await fetch(
        "http://localhost:8080/advertisement/byVisits/"
      );
      const data = await response.json();
      setAdvertisements(data);
    } catch (error) {
      console.error("Error fetching advertisements:", error);
    }
  };

  useEffect(() => {
    fetchAdvertisements();
  }, []);

  useEffect(() => {
    const newArray = [...imagePathArr];
    advertisements.forEach((adv) => {
      switch (adv.location) {
        case "Lower right":
          if (!newArray[0]) newArray[0] = adv.path;
          break;
        case "Lower left":
          if (!newArray[1]) newArray[1] = adv.path;
          break;
        case "Upper right":
          if (!newArray[2]) newArray[2] = adv.path;
          break;
        case "Upper left":
          if (!newArray[3]) newArray[3] = adv.path;
          break;
        default:
          console.log("No correct location!");
          break;
      }
    });
    setImagePathArr(newArray);
  }, [advertisements]);

  console.log(advertisements, "Advertisements Data");
  console.log(imagePathArr, "Image Paths");

  return (
    <div className="AdvertisementsContent">
      <div>
        {!imagePathArr[0] ? (
          <AdvertisementsPageContent location="Lower right" />
        ) : (
          <img
            src={imagePathArr[0]}
            alt="Advertisement Lower Right"
            className="adv"
          />
        )}
      </div>

      <div>
        {!imagePathArr[1] ? (
          <AdvertisementsPageContent location="Lower left" />
        ) : (
          <img
            src={imagePathArr[1]}
            alt="Advertisement Lower Left"
            className="adv"
          />
        )}
      </div>

      <div>
        {!imagePathArr[2] ? (
          <AdvertisementsPageContent location="Upper right" />
        ) : (
          <img
            src={imagePathArr[2]}
            alt="Advertisement Upper Right"
            className="adv"
          />
        )}
      </div>

      <div>
        {!imagePathArr[3] ? (
          <AdvertisementsPageContent location="Upper left" />
        ) : (
          <img
            src={imagePathArr[3]}
            alt="Advertisement Upper Left"
            className="adv"
          />
        )}
      </div>
    </div>
  );
};

export default AdvertisementsPage;
