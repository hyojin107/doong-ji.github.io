import 'antd/dist/antd.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Global, ThemeProvider } from '@emotion/react';

import Home from '@/pages/Home';
import Signin from '@/pages/Signin';
import Signup from '@/pages/Signup';
import TestPage from '@/pages/TestPage';
import GlobalStyle from '@/theme/globalStyle';
import AppLayout from '@/components/AppLayout';
import About from '@/pages/About';
import Project from '@/pages/Project';
import Calendar from '@/pages/Calendar';
import theme from '@/theme';

function App(): JSX.Element {
  return (
    <Router>
      <ThemeProvider theme={theme}>
        <Global styles={GlobalStyle} />
        {/* components의 Header */}
        <Switch>
          <AppLayout>
            <Route path="/" component={Home} />
            <Route path="/signin" exact component={Signin} />
            <Route path="/signup" exact component={Signup} />
            <Route path="/testpage" exact component={TestPage} />
            <Route path="/about" exact component={About} />
            <Route path="/project" exact component={Project} />
            <Route path="/calendar" exact component={Calendar} />
          </AppLayout>
        </Switch>
      </ThemeProvider>
      {/* components의 Footer */}
    </Router>
  );
}

export default App;
