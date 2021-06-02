import { FC, useState, useCallback } from 'react';
import { useHistory } from 'react-router-dom';
import { Button, Input, Form } from 'antd';
import styled from '@emotion/styled';
import { ExclamationCircleTwoTone, CheckCircleTwoTone } from '@ant-design/icons';

import useValidator from '@/hooks/useValidator';
import { isName, isEmail, isPassword } from '@/utils/validators';
import theme from '@/theme';
import { Message } from '@/utils/signupMessage';

const SignupSection = styled.section`
  width: 50%;
  height: 100%;
  display: flex;
  flex-direction: column;
`;

const Signup: FC = () => {
  const history = useHistory();
  const [name, , onChangeName, isNameValid] = useValidator('', isName);
  const [email, , onChangeEmail, isEmailValid] = useValidator('', isEmail);
  const [password, , onChangePassword, isPasswordValid] = useValidator('', isPassword); //패스워드 체크
  const [passwordConfirm, setPasswordConfirm] = useState(''); //패스워드 재 확인
  const [isPasswordReValid, setIsPasswordReValid] = useState(false);

  const onClickBackHandler = useCallback(() => {
    history.push('/signin');
  }, []);

  const onChangePasswordReHandler = useCallback(
    (e: React.ChangeEvent<HTMLInputElement>) => {
      setPasswordConfirm(e.target.value);
      setIsPasswordReValid(e.target.value === password);
    },
    [password],
  );

  const suffix = (isVaildValue: boolean) => {
    return isVaildValue ? (
      <CheckCircleTwoTone twoToneColor={theme.PRIMARY_COLOR} />
    ) : (
      <ExclamationCircleTwoTone twoToneColor={theme.WARNING_COLOR} />
    );
  };

  const validateStatus = (isVaildValue: boolean, value: string) => {
    return !isVaildValue && value.length !== 0 ? 'error' : '';
  };

  const help = (isVaildValue: boolean, value: string, helpMessage: string): string | false => {
    return !isVaildValue && value.length !== 0 && helpMessage;
  };

  return (
    <SignupSection>
      <Form layout="vertical">
        <Form.Item
          name="이름"
          label="이름"
          validateStatus={validateStatus(isNameValid, name)}
          help={help(isNameValid, name, Message.NameMessage)}
        >
          <Input
            title="이름"
            value={name}
            placeholder="이름을 입력해 주세요."
            onChange={onChangeName}
            suffix={suffix(isNameValid)}
            autoComplete="off"
            defaultValue={name}
          />
        </Form.Item>
        <Form.Item
          name="이메일"
          label="이메일"
          validateStatus={validateStatus(isEmailValid, email)}
          help={help(isEmailValid, email, Message.EmailMessage)}
        >
          <Input
            value={email}
            title="이메일"
            placeholder="이메일을 입력해 주세요."
            onChange={onChangeEmail}
            suffix={suffix(isEmailValid)}
            autoComplete="off"
            defaultValue={email}
          />
        </Form.Item>
        <Form.Item
          name="비밀번호"
          label="비밀번호"
          validateStatus={validateStatus(isPasswordValid, password)}
          help={help(isPasswordValid, password, Message.PasswordMessage)}
        >
          <Input
            value={password}
            type="password"
            title="비밀번호"
            placeholder="비밀번호를 입력해 주세요."
            onChange={onChangePassword}
            suffix={suffix(isPasswordValid)}
            autoComplete="off"
            defaultValue={password}
          />
        </Form.Item>

        <Form.Item
          name="비밀번호 재확인"
          label="비밀번호 재확인"
          validateStatus={validateStatus(isPasswordReValid, passwordConfirm)}
          help={help(isPasswordReValid, passwordConfirm, Message.PasswordCheckMessage)}
        >
          <Input
            value={passwordConfirm}
            type="password"
            title="비밀번호 재확인"
            placeholder="비밀번호를 한번 더 입력해 주세요."
            onChange={onChangePasswordReHandler}
            suffix={suffix(isPasswordReValid)}
            autoComplete="off"
            defaultValue={passwordConfirm}
          />
        </Form.Item>
      </Form>
      <div>
        <Button
          block
          type="primary"
          onClick={onClickBackHandler}
          disabled={!isNameValid || !isEmailValid || !isPasswordValid || !isPasswordReValid}
        >
          회원가입
        </Button>
        <Button block type="primary" onClick={onClickBackHandler}>
          로그인화면이동
        </Button>
      </div>
    </SignupSection>
  );
};

export default Signup;
