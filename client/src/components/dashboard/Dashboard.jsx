import React, {useEffect, useContext} from 'react';
import { Section } from '../customStyles/Section';
import { ActionsContext } from '../../contexts/ActionsContext';

function Dashboard(){
  const {userActions: {getCurrentUser}} = useContext(ActionsContext)
  useEffect(()=> {
    getCurrentUser();
  }, []);
  return (
    <Section>
      <h1>Dashboard</h1>
    </Section>
  )
}

export default Dashboard;