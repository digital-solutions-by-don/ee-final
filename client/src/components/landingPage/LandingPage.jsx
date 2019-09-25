import React, { useEffect, useState } from 'react';
import Header from './header/Header';
import About from './about/About';
import Services from './services/Services';
import Testimonials from './testimonials/Testimonials';
import Goals from './goals/Goals';
import Contact from './contact/Contact';
import { useSelector } from 'react-redux';
import MessageDisplay from './messageDisplay/MessageDisplay';

function LandingPage () {
  const [showDisplay, setShowDisplay] = useState(false);
  const isSuccess = useSelector(state => state.messages.isSuccess);
  const errors = useSelector(state => state.messages.errors);

  useEffect(() => {
    if (isSuccess || errors) {
      setShowDisplay(true);
    } else {
      setShowDisplay(false);
    }
  }, [isSuccess, errors]);

  return (
    <>
      <Header />
      <About />
      <Services />
      <Testimonials />
      <Goals />
      <Contact />
      {showDisplay && <MessageDisplay />}
    </>
  );
}

export default LandingPage;