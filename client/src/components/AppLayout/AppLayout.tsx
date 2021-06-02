import { FC } from 'react';

interface AppLayoutProps {
  children?: React.ReactNode;
}

const AppLayout: FC<{}> = ({ children }: AppLayoutProps) => {
  return (
    <>
      <span>Menu</span>
      {children}

      {/* 
        반복되는 상단 Header layout 적용
        로고  --  둥지소개, 공지사항, 커뮤니티, 프로젝트, 캘린터, Q & A, 상단 로그인/회원가입
      */}
    </>
  );
};

export default AppLayout;
