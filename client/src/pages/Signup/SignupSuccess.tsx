import { useCallback } from 'react';
import { useHistory } from 'react-router-dom';

const SignupSuccess: React.FC = () => {
  const history = useHistory();
  const onClickLoginHandler = useCallback(() => {
    history.replace('/signin');
  }, []);
  const onClickMainHandler = useCallback(() => {
    history.replace('/');
  }, []);

  return <div>SignupSuccess</div>;
};

export default SignupSuccess;
