import React from 'react';
import { ActionsProvider } from '../contexts/ActionsContext';
import { useMessageActions } from '../store/message/useMessageActions';

function App () {
  const messageActions = useMessageActions();
  return (
    <ActionsProvider value={{ messageActions }}>
      <h1>Hello World</h1>
    </ActionsProvider>
  );
}

export default App;