import { useCallback } from 'react';
import { useHistory } from 'react-router-dom';
import { Button, Form } from 'antd';
import styled from '@emotion/styled';

const SignupSuccess: React.FC = () => {
  const history = useHistory();
  const onClickLoginHandler = useCallback(() => {
    history.replace('/signin');
  }, []);
  const onClickMainHandler = useCallback(() => {
    history.replace('/');
  }, []);

  return (
    <SignupSuccessSection>
      <Form>
        <SuccessTitle>환영합니다!</SuccessTitle>
        <SuccessContents>홍길동 님, 회원가입을 축하드립니다.</SuccessContents>
        <SuccessContents>둥지와 함께 하게되어 기뻐요 !</SuccessContents>

        <Form.Item>
          <Button style={{ margin: '10px' }} size="large" onClick={onClickLoginHandler}>
            로그인
          </Button>
          <Button style={{ margin: '10px' }} size="large" onClick={onClickMainHandler}>
            메인으로
          </Button>
        </Form.Item>
      </Form>
    </SignupSuccessSection>
  );
};

const SignupSuccessSection = styled.section`
  box-shadow: 0 1px 5px 0 rgb(0 0 0 / 50%);
  padding: 30px 60px;
  margin: 0 auto;
  border-radius: 20px;
  width: 100%;
  max-width: 800px;
  max-height: 800px;
  background-color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;
  text-align: center;
`;

const SuccessTitle = styled.h1`
  margin-bottom: 100px;
  font-weight: bold;
  font-size: 40px;
`;
const SuccessContents = styled.p`
  margin-bottom: 10px;
  font-size: 30px;
`;

export default SignupSuccess;
