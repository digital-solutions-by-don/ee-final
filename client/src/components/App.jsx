import React from 'react';
import { ActionsProvider } from '../contexts/ActionsContext';
import { useMessageActions } from '../store/message/useMessageActions';
import Navigation from './shared/navigation/Navigation';
import Footer from './shared/footer/Footer';

function App () {
  const messageActions = useMessageActions();
  return (
    <ActionsProvider value={{ messageActions }}>
      <Navigation/>
      <h1>Hello World</h1>
      <Footer/>
    </ActionsProvider>
  );
}

export default App;