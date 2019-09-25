import styled, {css} from 'styled-components';
import headerImage from '../../images/electrical-electrician-electricity-1435183.jpg';

export const Section = styled.section`
  padding: 8rem 0;
  h2 {
    font-size: 3rem;
  }
  
  h3 {
    font-size: 1.5rem;
    text-transform: uppercase;
  }
  
  ${props => props.header && css`
    min-height: 30rem;
    position: relative;
    display: table;
    width: 100%;
    height: auto;
    background: linear-gradient(90deg, rgba(255,255,255,0.1) 0, rgba(255,255,255,0.1) 100%),url(${headerImage});
    background-position: center center;
    background-repeat: no-repeat;
    background-size: cover;
    
    @media (min-width: 992px) {
      height: 100vh;
    }
    h1 {
      font-size: 4rem;
      margin: 0;
      padding: 0;
      
      @media (min-width: 992px) {
        font-size: 5.5rem;
      }
    }
`}

`;