import React, { useState } from 'react';
import LoginPage from './LoginPage';
import AdvertisementTypeModal from './AdvertisementTypeModal';

const MainContent = () => {
  const [loggedIn, setLoggedIn] = useState(false);
  const [advertisementTypeSelected, setAdvertisementTypeSelected] = useState(false);
  const [showLoginPage, setShowLoginPage] = useState(false);

  const handleAreaClick = () => {
    if (!loggedIn) {
      setShowLoginPage(true);
    } else {
      setAdvertisementTypeSelected(true);
    }
  };

  const handleLoginSuccess = () => {
    setShowLoginPage(false);
    setLoggedIn(true);
  };

  const handleAdvertisementTypeSelect = () => {
    setAdvertisementTypeSelected(true);
  };

  return (
    <div>
      {!advertisementTypeSelected && (
        <div onClick={handleAreaClick}>
          Click here to {loggedIn ? 'select advertisement type' : 'login/register'}
        </div>
      )}
      {showLoginPage && <LoginPage onSuccess={handleLoginSuccess} />}
      {advertisementTypeSelected && <AdvertisementTypeModal />}
    </div>
  );
};

export default MainContent;
