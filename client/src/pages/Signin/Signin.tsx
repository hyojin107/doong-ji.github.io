import { useCallback } from 'react';
import { useHistory } from 'react-router-dom';
import { UserOutlined, LockOutlined } from '@ant-design/icons';

import { SignInSection, SignInTitle } from './styled';
import useChange from '@/hooks/useChange';
import { Form, Input, Button, Checkbox, Row, Col, message } from 'antd';

const Signin = () => {
  const history = useHistory();
  const [email, setEmail, onChangeEmail] = useChange('');
  const [password, setPassword, onChangePassword] = useChange('');
  const onClickSignIn = useCallback(() => {}, [email, password]);
  return (
    <SignInSection>
      <Row>
        <Col span={12}>col-12</Col>
        <Col span={12}>
          <SignInTitle>로그인</SignInTitle>
          <Form
            name="normal_login"
            className="login-form"
            initialValues={{
              remember: true,
            }}
          >
            <Form.Item
              name="email"
              rules={[
                {
                  required: true,
                  message: 'Please input your Username!',
                },
              ]}
            >
              <Input prefix={<UserOutlined className="site-form-item-icon" />} placeholder="Email" />
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
              <Input prefix={<LockOutlined className="site-form-item-icon" />} type="password" placeholder="Password" />
            </Form.Item>
            <Form.Item>
              <Form.Item name="remember" valuePropName="checked" noStyle>
                <Checkbox>Remember me</Checkbox>
              </Form.Item>

              <a className="login-form-forgot" href="">
                비밀번호 찾기
              </a>
              <span>/</span>
              <a href="">회원가입</a>
            </Form.Item>

            <Form.Item>
              <Button type="primary" htmlType="submit" className="login-form-button">
                Log in
              </Button>
            </Form.Item>
          </Form>
        </Col>
      </Row>
    </SignInSection>
  );
};

export default Signin;
