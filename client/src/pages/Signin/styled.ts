import styled from '@emotion/styled';

export const SignInSection = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0 1px 5px 0 rgb(0 0 0 / 50%);
  padding: 30px 60px;
  margin: 0 auto;
  border-radius: 20px;
  width: 100%;
  max-width: 700px;
  background-color: white;
`;

export const SignInImg = styled.div`
  margin: 0 auto;
`;

export const SignInForm = styled.div`
  margin: 0 auto;
  & > h1 {
    text-align: center;
    margin-bottom: 30px;
    font-weight: bold;
    font-size: 30px;
  }
`;

export const SocialLogo = styled.img`
  display: inline-block;
  width: 80px;
  height: 80px;
`;

export const SocialLogin = styled.div`
  margin-top: 15px;
  & :hover > img {
    overflow: hidden;
    transform: scale(1.2);
  }
`;

export const SigninText = styled.div`
  display: flex;
  justify-content: flex-end;

  & > a {
    margin-left: 20px;
  }
`;
