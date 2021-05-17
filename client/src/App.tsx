import 'antd/dist/antd.css';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import { Global } from '@emotion/react';
import Home from '@/pages/Home';
import Signin from '@/pages/Signin';
import Signup from '@/pages/Signup';
import TestPage from '@/pages/TestPage';
import reset from '@/theme/globalStyle';

function App(): JSX.Element {
  return (
    <Router>
      <Global styles={reset} />
      {/* components의 Header */}
      <Switch>
        <Route path="/signin" exact component={Signin} />
        <Route path="/signup" exact component={Signup} />
        <Route path="/testpage" exact component={TestPage} />
        <Route path="/" exact component={Home} />
      </Switch>
      {/* components의 Footer */}
    </Router>
  );
}

export default App;
