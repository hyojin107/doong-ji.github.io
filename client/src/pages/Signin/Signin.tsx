import { useCallback, useState } from 'react';
import { Link } from 'react-router-dom';
import { UserOutlined, LockOutlined, EyeInvisibleOutlined, EyeTwoTone } from '@ant-design/icons';
import { Form, Input, Button, Checkbox } from 'antd';

import { SignInSection, SocialLogin, SigninText, SocialLogo, SignInForm, SignInImg } from './styled';
import { GOOGLE_AUTH_URL, NAVER_AUTH_URL, KAKAO_AUTH_URL } from '@/utils/socialUrl';
import useChange from '@/hooks/useChange';
import naver from '@/images/Signin/naver.png';
import kakao from '@/images/Signin/kakao.png';
import google from '@/images/Signin/google.png';
import doongji from '@/images/Main/doongji.png';

const Signin = () => {
  const [email, onChangeEmail] = useChange('');
  const [password, onChangePassword] = useChange('');
  const [isLoginState, setIsLoginState] = useState(false); //로그인 상태 유지

  const onClickSignIn = useCallback(() => {
    //signin dispatch
  }, [email, password]); //signin

  const onChangeLoginState = useCallback(() => {
    setIsLoginState(!isLoginState);
  }, []); //로그인 상태 유지

  return (
    <SignInSection>
      <SignInImg>
        <img src={doongji} alt="logo" />
      </SignInImg>
      <SignInForm>
        <h1>로그인</h1>
        <Form
          name="login"
          initialValues={{
            remember: true,
          }}
        >
          <Form.Item
            name="email"
            rules={[
              {
                required: true,
                message: 'Please input your Email!',
              },
            ]}
          >
            <Input prefix={<UserOutlined />} placeholder="Email" value={email} onChange={onChangeEmail} />
          </Form.Item>

          <Form.Item
            name="password"
            rules={[
              {
                required: true,
                message: 'Please input your Password!',
              },
            ]}
          >
            <Input.Password
              prefix={<LockOutlined />}
              placeholder="Password"
              iconRender={(visible) => (visible ? <EyeTwoTone /> : <EyeInvisibleOutlined />)}
              value={password}
              onChange={onChangePassword}
            />
          </Form.Item>

          <div style={{ display: 'flex', justifyContent: 'space-between' }}>
            <Form.Item name="remember">
              <Checkbox checked={isLoginState} onChange={onChangeLoginState}>
                Remember me
              </Checkbox>
            </Form.Item>
            <Form.Item>
              <Button type="primary" onClick={onClickSignIn} disabled={!email || !password}>
                Log in
              </Button>
            </Form.Item>
          </div>

          <SigninText>
            <Link to="/signup">비밀번호 찾기</Link>
            <Link to="/signup">회원가입</Link>
          </SigninText>

          <SocialLogin>
            <Link to={GOOGLE_AUTH_URL}>
              <SocialLogo src={google} />
            </Link>
            <Link to={NAVER_AUTH_URL}>
              <SocialLogo src={naver} />
            </Link>
            <Link to={KAKAO_AUTH_URL}>
              <SocialLogo src={kakao} />
            </Link>
          </SocialLogin>
        </Form>
      </SignInForm>
    </SignInSection>
  );
};

export default Signin;
