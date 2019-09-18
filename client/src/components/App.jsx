import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { ActionsProvider } from '../contexts/ActionsContext';
import { useMessageActions } from '../store/message/useMessageActions';
import Navigation from './shared/navigation/Navigation';
import Footer from './shared/footer/Footer';
import LandingPage from './landingPage/LandingPage';

function App () {
  const messageActions = useMessageActions();
  return (
    <ActionsProvider value={{ messageActions }}>
      <Navigation />
      <Switch>
        <Route
          exact
          path='/'
          component={LandingPage}
        />
      </Switch>
      <Footer />
    </ActionsProvider>
  );
}

export default App;