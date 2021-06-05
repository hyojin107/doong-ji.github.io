import 'antd/dist/antd.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Global, ThemeProvider } from '@emotion/react';
import GlobalStyle from '@/theme/globalStyle';
import AppLayout from '@/components/AppLayout';
import Home from '@/pages/Home';
import About from '@/pages/About';
import Notice from '@/pages/Notice';
import Community from '@/pages/Community';
import Project from '@/pages/Project';
import Calendar from '@/pages/Calendar';
import Question from '@/pages/Question';
import Signin from '@/pages/Signin';
import Signup from '@/pages/Signup';
import TestPage from '@/pages/TestPage';
import theme from '@/theme';

function App(): JSX.Element {
  return (
    <Router>
      <ThemeProvider theme={theme}>
        <Global styles={GlobalStyle} />
        {/* components의 Header */}
        <Switch>
          <AppLayout>
            <Route path="/" exact component={Home} />
            <Route path="/about" exact component={About} />
            <Route path="/notice" exact component={Notice} />
            <Route path="/community" exact component={Community} />
            <Route path="/project" exact component={Project} />
            <Route path="/calendar" exact component={Calendar} />
            <Route path="/question" exact component={Question} />

            <Route path="/signin" exact component={Signin} />
            <Route path="/signup" exact component={Signup} />
            <Route path="/testpage" exact component={TestPage} />
          </AppLayout>
        </Switch>
      </ThemeProvider>
      {/* components의 Footer */}
    </Router>
  );
}

export default App;
