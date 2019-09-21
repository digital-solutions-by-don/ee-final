import React from 'react';
import { Route, Switch } from 'react-router-dom';
import { ActionsProvider } from '../contexts/ActionsContext';
import { useMessageActions } from '../store/message/useMessageActions';
import Navigation from './shared/navigation/Navigation';
import Footer from './shared/footer/Footer';
import LandingPage from './landingPage/LandingPage';
import Login from './auth/Login';
import { useAuthActions } from '../store/auth/useAuthActions';

function App () {
  const messageActions = useMessageActions();
  const authActions = useAuthActions();
  return (
    <ActionsProvider value={{ authActions, messageActions }}>
      <Navigation />
      <Switch>
        <Route
          path='/register'
          render={props => <Login
            register={authActions.register}
            login={authActions.login} {...props} />}
        />
        <Route
          path='/login'
          render={props => <Login
            register={authActions.register}
            login={authActions.login} {...props} />}
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