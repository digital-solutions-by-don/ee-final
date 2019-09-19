import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { ActionsProvider } from '../contexts/ActionsContext';
import { useMessageActions } from '../store/message/useMessageActions';
import Navigation from './shared/navigation/Navigation';
import Footer from './shared/footer/Footer';
import LandingPage from './landingPage/LandingPage';
import Login from './auth/Login';

function App () {
  const messageActions = useMessageActions();
  return (
    <ActionsProvider value={{ messageActions }}>
      <Navigation />
      <Switch>
        <Route
          path='/register'
          component={Login}
        />
        <Route
          path='/login'
          component={Login}
        />
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