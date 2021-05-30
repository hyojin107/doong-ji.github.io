import 'antd/dist/antd.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Global } from '@emotion/react';
import Home from '@/pages/Home';
import Signin from '@/pages/Signin';
import Signup from '@/pages/Signup';
import TestPage from '@/pages/TestPage';
import reset from '@/theme/globalStyle';
import AppLayout from '@/layouts/AppLayout';
import About from '@/pages/About';
import Project from '@/pages/Project';
import Calendar from '@/pages/Calendar';

function App(): JSX.Element {
  return (
    <Router>
      <Global styles={reset} />
      {/* components의 Header */}
      <Switch>
        <AppLayout>
          <Route path="/signin" exact component={Signin} />
          <Route path="/signup" exact component={Signup} />
          <Route path="/testpage" exact component={TestPage} />
          <Route path="/" exact component={Home} />
          <Route path="/about" exact component={About} />
          <Route path="/project" exact component={Project} />
          <Route path="/calendar" exact component={Calendar} />
        </AppLayout>
      </Switch>
      {/* components의 Footer */}
    </Router>
  );
}

export default App;
