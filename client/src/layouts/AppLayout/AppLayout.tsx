import { FC } from 'react';
import PropTypes from 'prop-types';

const AppLayout: FC<{}> = ({ children }) => {
  return (
    <>
      {children}
      <span>Insert</span>
      {/* 
        반복되는 상단 Header layout 적용
        로고  --  둥지소개, 공지사항, 커뮤니티, 프로젝트, 캘린터, Q & A, 상단 로그인/회원가입
      */}
    </>
  );
};

AppLayout.propTypes = {
  children: PropTypes.node,
};

export default AppLayout;
